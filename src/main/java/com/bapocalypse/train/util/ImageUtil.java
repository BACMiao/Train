package com.bapocalypse.train.util;

import com.bapocalypse.train.po.BufferedImageWrap;
import com.bapocalypse.train.po.GenerateImageGroup;
import com.bapocalypse.train.po.ImageGroup;
import com.bapocalypse.train.po.ImageResult;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @package: com.bapocalypse.train.util
 * @Author: 陈淼
 * @Date: 2016/11/8
 * @Description: 将八张小图片合起来生成验证码图片的工具类
 */
public class ImageUtil {
    //小图片实物名字和图片组对象的映射关系
    private static Map<String, ImageGroup> imageGroupMap = new HashMap<>();
    //小图片数量和实物名字、图片组对象的映射关系
    private static Map<Integer, Map<String, ImageGroup>> countGroupsMap = new HashMap<>();

    /**
     * @param fileUrl 小图片路径和文件名
     * @param request 页面的Http请求
     * @return BufferedImage 图片缓冲区
     * @throws IOException
     * @funtion getBufferedImage
     * @Description 将同一组的几张小图片放到指定的BufferedImage中
     */
    private static BufferedImage getBufferedImage(String fileUrl,
                                                  HttpServletRequest request) throws IOException {
        String realPathDir = request.getSession().getServletContext().getRealPath("/");
        File f = new File(realPathDir + "resources" + File.separator + "sourceImage"
                + fileUrl);
        //读取指定的图片内容，将其写进BufferedImage中
        return ImageIO.read(f);
    }

    /**
     * @param savedImg 需要保存的图片缓冲区
     * @param fileUrl  保存验证码图片的路径
     * @param format   图片的格式
     * @return boolean 写入是否成功
     * @funtion saveImage
     * @Description 保存生成的验证码图片
     */
    private static boolean saveImage(BufferedImage savedImg,
                                     String fileUrl,
                                     String format) {
        File file = new File(fileUrl);
        try {
            //使用支持给定格式的将一个图像写入file中
            return ImageIO.write(savedImg, format, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * @param imageWraps 要生成的验证码图片的小图片缓冲集合
     * @param tip        验证码需要选择的实物名称
     * @param request    页面的Http请求
     * @return ImageResult 返回合成后验证码图片的对象
     * @funtion mergeImage
     * @Description 合成选出的图片形成新的验证码图片
     */
    private static ImageResult mergeImage(List<BufferedImageWrap> imageWraps,
                                          String tip,
                                          HttpServletRequest request) {
        //使用默认随机源对imageWraps列表进行置换，即打乱顺序
        Collections.shuffle(imageWraps);
        //原始图片高度为200像素，宽度为200像素
        int width = 200;
        int high = 200;
        int totalWidth = width * 4;
        //构造一个类型为指定图像类型的BufferedImage
        BufferedImage destImage = new BufferedImage(totalWidth, 400, BufferedImage.TYPE_INT_RGB);
        int x1 = 0;     //第一行
        int x2 = 0;     //第二行
        int order = 0;  //小图片在验证码图片中的位置
        //在控制台显示答案图片的顺序以及所在坐标
        StringBuilder keysOrder = new StringBuilder();
        //答案图片所在验证码图片中的位置
        Set<Integer> keySet = new HashSet<>();
        for (BufferedImageWrap image : imageWraps) {
            //获取图片的RGB信息
            int[] rgb = image.getBufferedImage().getRGB(0, 0, width, high, null, 0, width);
            if (image.isKey()) {
                int x = (order % 4) * 200;
                int y = (order < 4) ? 0 : 200;
                keySet.add(order);
                keysOrder.append(order).append("(").append(x).append(",").append(y).append(")|");
            }
            if (order < 4) {
                //设置上半部分的RGB
                destImage.setRGB(x1, 0, width, high, rgb, 0, width);
                x1 += width;
            } else {
                //设置下半部分的RGB
                destImage.setRGB(x2, high, width, high, rgb, 0, width);
                x2 += width;
            }
            order++;
        }
        //删除在控制台打印字符串的最后的竖线
        keysOrder.deleteCharAt(keysOrder.length() - 1);
        System.out.println("答案位置：" + keysOrder);
        String fileName = UUID.randomUUID().toString().replaceAll("-", "");
        String realPathDir = request.getSession().getServletContext().getRealPath("/");
        String fileUrl = realPathDir + "resources" + File.separator
                + "targetImage" + File.separator + fileName + ".jpeg";
        saveImage(destImage, fileUrl, "jpeg");

        ImageResult ir = new ImageResult();
        ir.setName(fileName + ".jpeg");
        ir.setKeySet(keySet);
        ir.setUniqueKey(fileName);
        ir.setTip(tip);
        return ir;
    }

    /**
     * @param request 页面的Http请求
     * @return ImageResult 合成后的验证码图片对象
     * @throws IOException 读写异常
     * @funtion generateImage
     * @Description 选取几张答案图片和干扰项图片，用于组成一张验证码图片，并给每一个小图片标识一个自己
     * 的boolean，用于之后的验证来验证是否
     */
    public static ImageResult generateImage(HttpServletRequest request) throws IOException {
        initImageGroup();
        GenerateImageGroup generateImageGroup = randomImageGroups();
        List<BufferedImageWrap> images = new ArrayList<>();
        //找到generateImageGroup中的所有干扰项
        for (ImageGroup group : generateImageGroup.getGroups()) {
            //根据小图片路径和文件名，将同一组小图片放入缓冲区再放到要生成的验证码图片的集合中
            for (String imgName : group.getImages()) {
                images.add(new BufferedImageWrap(false, getBufferedImage(imgName, request)));
            }
        }
        //根据小图片路径和文件名，将正确的同一组小图片放入缓冲区再放到要生成的验证码图片的集合中
        for (String imgName : generateImageGroup.getKeyGroup().getImages()) {
            images.add(new BufferedImageWrap(true, getBufferedImage(imgName, request)));
        }
        return mergeImage(images, generateImageGroup.getKeyGroup().getName(), request);
    }

    /**
     * @return GenerateImageGroup 生成验证码的图片组，即组成验证码的小图片（包含作为答案的和干扰项的）
     * @funtion randomImageGroups
     * @Description 选出作为正确项的答案图片和作为干扰项的小图片用于作为生成验证码图片
     */
    private static GenerateImageGroup randomImageGroups() {
        //用于存放所有随机选出的干扰项小图片
        List<ImageGroup> result = new ArrayList<>();
        //imageGroupMap.size()是初始化时的小图片组的组数
        int num = random(0, imageGroupMap.size() - 1);
        //imageGroupMap.keySet()返回此映射中所包含的键的Set视图
        String name = new ArrayList<>(imageGroupMap.keySet()).get(num);
        ImageGroup keyGroup = imageGroupMap.get(name);

        //构造一个映射关系与countGroupsMap相同的新HashMap，将countGroupsMap转为方法私有
        Map<Integer, Map<String, ImageGroup>> thisCountGroupsMap = new HashMap<>(countGroupsMap);
        //去除作为key的小图片组
        thisCountGroupsMap.get(keyGroup.getCount()).remove(name);
        int leftCount = 8 - keyGroup.getCount();
        if (leftCount == 4) {
            if (new Random().nextInt() % 2 == 0) {
                //获取张数为4的小图片加入剩下的组中
                List<ImageGroup> groups = new ArrayList<>(thisCountGroupsMap.get(4).values());
                if (groups.size() > 1) {
                    num = random(0, groups.size() - 1);
                } else {
                    num = 0;
                }
                result.add(groups.get(num));
            } else {
                List<ImageGroup> groups = new ArrayList<>(thisCountGroupsMap.get(2).values());
                int num1 = random(0, groups.size() - 1);
                result.add(groups.get(num1));

                int num2 = random(0, groups.size() - 1, num1);
                result.add(groups.get(num2));
            }
        } else if (leftCount == 6) {
            if (new Random().nextInt() % 2 == 0) {
                List<ImageGroup> groups1 = new ArrayList<>(thisCountGroupsMap.get(4).values());
                int num1 = random(0, groups1.size() - 1);
                result.add(groups1.get(num1));

                List<ImageGroup> groups2 = new ArrayList<>(thisCountGroupsMap.get(2).values());
                int num2 = random(0, groups2.size() - 1);
                result.add(groups2.get(num2));
            } else {
                List<ImageGroup> groups = new ArrayList<>(thisCountGroupsMap.get(2).values());
                int num1 = random(0, groups.size() - 1);
                result.add(groups.get(num1));

                int num2 = random(0, groups.size() - 1, num1);
                result.add(groups.get(num2));

                int num3 = random(0, groups.size() - 1, num1, num2);
                result.add(groups.get(num3));
            }
        }
        return new GenerateImageGroup(keyGroup, result);
    }

    private static void initImageGroup() {
        ImageGroup group1 = new ImageGroup("包包", 4, "/baobao/1.jpg",
                "/baobao/2.jpg",
                "/baobao/3.jpg",
                "/baobao/4.jpg");
        ImageGroup group2 = new ImageGroup("磁铁", 2, "/citie/1.jpg",
                "/citie/2.jpg");
        ImageGroup group3 = new ImageGroup("老虎", 4, "/laohu/1.jpg",
                "/laohu/2.jpg",
                "/laohu/3.jpg",
                "/laohu/4.jpg");
        ImageGroup group4 = new ImageGroup("柚子", 4, "/youzi/1.jpg",
                "/youzi/2.jpg",
                "/youzi/3.jpg",
                "/youzi/4.jpg");
        ImageGroup group5 = new ImageGroup("蘑菇", 2, "/mogu/1.jpg",
                "/mogu/2.jpg");
        ImageGroup group6 = new ImageGroup("订书机", 2, "/dingshuji/1.jpg",
                "/dingshuji/2.jpg");
        ImageGroup group7 = new ImageGroup("土豆", 2, "/tudou/1.jpg",
                "/tudou/2.jpg");
        initMap(group1, group2, group3, group4, group5, group6, group7);
    }

    private static void initMap(ImageGroup... groups) {
        for (ImageGroup group : groups) {
            imageGroupMap.put(group.getName(), group);
            if (!countGroupsMap.containsKey(group.getCount())) {
                countGroupsMap.put(group.getCount(), new HashMap<>());
            }
            countGroupsMap.get(group.getCount()).put(group.getName(), group);
        }
    }

    /**
     * @param min 最小值
     * @param max 最大值
     * @return int 返回一个在最小值和最大值之间的随机数
     * @funtion random
     * @Description 生成一个随机数
     */
    private static int random(int min, int max) {
        Random random = new Random();
        //在0和参数之间生成一个伪随机数后，再加上最小值
        return random.nextInt(max - min + 1) + min;
    }

    /**
     * @param min 最小值
     * @param max 最大值
     * @param not 需要除去的数字
     * @return int 返回一个在最小值和最大值之间的随机数，且不等于not的随机数
     * @funtion random
     * @Description 生成除去数字not一个随机数
     */
    private static int random(int min, int max, Integer... not) {
        int num = random(min, max);
        List<Integer> notList = Arrays.asList(not);
        //如果在notList中存在新生成的数字，则重新随机
        while (notList.contains(num)) {
            num = random(min, max);
        }
        return num;
    }
}
