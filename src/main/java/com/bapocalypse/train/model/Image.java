package com.bapocalypse.train.model;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @package: com.bapocalypse.train.model
 * @Author: 陈淼
 * @Date: 2016/11/8
 * @Description:
 */
public class Image {
    private static Map<String, ImageGroup> imageGroupMap = new HashMap<>();
    private static Map<Integer, Map<String, ImageGroup>> countGroupsMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        generateImage();
    }
    private static BufferedImage getBufferedImage(String fileUrl) throws IOException{
        File f = new File("E:\\computer\\Project\\train\\src\\main\\webapp\\WEB-INF\\resources\\sourceImage" + fileUrl);
        return ImageIO.read(f);
    }

    private static boolean saveImage(BufferedImage savedImg, String fileUrl, String format){
        File file = new File(fileUrl);
        try {
            return ImageIO.write(savedImg, format, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static  ImageResult mergeImage(List<BufferedImageWrap> imageWraps, String tip){
        Collections.shuffle(imageWraps);

        int width = 200;
        int high = 200;
        int totalWidth = width * 4;

        BufferedImage destImage = new BufferedImage(totalWidth, 400, BufferedImage.TYPE_INT_RGB);
        int x1 = 0;
        int x2 = 0;
        int order = 0;
        List<Integer> keysOrderList = new ArrayList<>();
        StringBuilder keysOrder = new StringBuilder();
        Set<Integer> keySet = new HashSet<>();
        for (BufferedImageWrap image:imageWraps){
            int[] rgb = image.getBufferedImage().getRGB(0, 0, width, high, null, 0, width);
            if (image.isKey()){
                keysOrderList.add(order);
                int x = (order%4)*200;
                int y = (order < 4)?0:200;
                keySet.add(order);
                keysOrder.append(order).append("(").append(x).append(",").append(y).append(")|");
            }
            if (order < 4){
                destImage.setRGB(x1, 0, width, high, rgb, 0, width);
                x1 += width;
            } else {
                destImage.setRGB(x2, high, width, high, rgb, 0, width);
                x2 += width;
            }
            order++;
        }
        keysOrder.deleteCharAt(keysOrder.length() - 1);
        System.out.println("答案位置：" + keysOrder);
        String fileName =UUID.randomUUID().toString().replaceAll("-","");
        String fileUrl = "E:\\computer\\Project\\train\\src\\main\\webapp\\WEB-INF\\resources\\targetImage\\" + fileName + ".jpeg";
        saveImage(destImage, fileUrl, "jpeg");

        ImageResult ir = new ImageResult();
        ir.setName(fileName + ".jpeg");
        ir.setKeySet(keySet);
        ir.setUniqueKey(fileName);
        ir.setTip(tip);
        return ir;
    }
    public static ImageResult generateImage() throws IOException{
        initImageGroup();
        GenerateImageGroup generateImageGroup = randomImageGroups();
        List<BufferedImageWrap> images = new ArrayList<>();
        for (ImageGroup group:generateImageGroup.getGroups()){
            for (String imgName:group.getImages()){
                images.add(new BufferedImageWrap(false, getBufferedImage(imgName)));
            }
        }

        for (String imgName:generateImageGroup.getKeyGroup().getImages()){
            images.add(new BufferedImageWrap(true, getBufferedImage(imgName)));
        }
        return mergeImage(images, generateImageGroup.getKeyGroup().getName());
    }
    private static GenerateImageGroup randomImageGroups(){
        List<ImageGroup> result = new ArrayList<>();
        int num = random(0, imageGroupMap.size()-1);

        String name = new ArrayList<>(imageGroupMap.keySet()).get(num);
        ImageGroup keyGroup = imageGroupMap.get(name);

        Map<Integer, Map<String, ImageGroup>> thisCountGroupsMap = new HashMap<>(countGroupsMap);
        thisCountGroupsMap.get(keyGroup.getCount()).remove(name);
        int leftCount = 8 - keyGroup.getCount();
        if (leftCount == 4){
            if (new Random().nextInt()%2 == 0){
                List<ImageGroup> groups = new ArrayList<>(thisCountGroupsMap.get(4).values());
                if (groups.size() > 1){
                    num = random(0, groups.size()-1);
                } else {
                    num = 0;
                }
                result.add(groups.get(num));
            } else {
                List<ImageGroup> groups = new ArrayList<>(thisCountGroupsMap.get(2).values());
                int num1 = random(0, groups.size()-1);
                result.add(groups.get(num1));

                int num2 = random(0, groups.size()-1, num1);
                result.add(groups.get(num2));
            }
        } else if (leftCount == 6){
            if (new Random().nextInt()%2 == 0){
                List<ImageGroup> groups1 = new ArrayList<>(thisCountGroupsMap.get(4).values());
                int num1 = random(0, groups1.size()-1);
                result.add(groups1.get(num1));

                List<ImageGroup> groups2 = new ArrayList<>(thisCountGroupsMap.get(2).values());
                int num2 = random(0, groups2.size()-1);
                result.add(groups2.get(num2));
            } else {
                List<ImageGroup> groups = new ArrayList<>(thisCountGroupsMap.get(2).values());
                int num1 = random(0, groups.size()-1);
                result.add(groups.get(num1));

                int num2 = random(0, groups.size()-1, num1);
                result.add(groups.get(num2));

                int num3 = random(0, groups.size()-1, num1, num2);
                result.add(groups.get(num3));
            }
        }
        return new GenerateImageGroup(keyGroup, result);
    }

    private static void initImageGroup(){
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
        initMap(group1, group2, group3, group4, group5, group6);
    }

    private static void initMap(ImageGroup... groups){
        for (ImageGroup group:groups){
            imageGroupMap.put(group.getName(), group);
            if (!countGroupsMap.containsKey(group.getCount())){
                countGroupsMap.put(group.getCount(), new HashMap<>());
            }
            countGroupsMap.get(group.getCount()).put(group.getName(), group);
        }
    }

    private static int random(int min, int max){
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    private static int random(int min, int max, Integer... not){
        int num = random(min, max);
        List<Integer> notList = Arrays.asList(not);
        while (notList.contains(num)){
            num = random(min, max);
        }
        return num;
    }
}
