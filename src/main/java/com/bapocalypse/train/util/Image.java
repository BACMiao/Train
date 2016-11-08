//package com.bapocalypse.train.util;
//
//import javax.imageio.ImageIO;
//import javax.servlet.http.HttpServletResponse;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @package: com.bapocalypse.train.util
// * @Author: 陈淼
// * @Date: 2016/11/8
// * @Description:
// */
//public class Image {
//    public static List<Object> getEightImages() {
//        //保存取到的每一个图片的path，保证图片不会重复
//        List<String> paths = new ArrayList<String>();
//
//        File[] finalImages = new File[8];
//        List<Object> object = new ArrayList<Object>();
//
//        //保存tips
//        String[] tips = new String[8];
//
//        for (int i = 0; i < 8; i++) {
//            //获取随机的二级目录
//            int dirIndex = getRandom(secondaryDirNumbers);
//            File secondaryDir = getFiles()[dirIndex];
//
//            //随机到的文件夹名称保存到tips中
//            tips[i] = secondaryDir.getName();
//
//            //获取二级图片目录下的文件
//            File[] images = secondaryDir.listFiles();
//
//            int imageIndex = getRandom(imageRandomIndex);
//            File image = images[imageIndex];
//
//            //图片去重
//            image = dropSameImage(image, paths, tips, i);
//
//            paths.add(image.getPath());
//
//            finalImages[i] = image;
//
//        }
//        object.add(finalImages);
//        object.add(tips);
//        return object;
//    }
//
//    public static List<Object> getLocation(String[] tips) {
//        List<Object> locations = new ArrayList<Object>();
//
//        //获取Key分类
//        String tip = getTip(tips);
//        locations.add(tip);
//
//        int length = tips.length;
//        for (int i = 0; i < length; i++) {
//            if (tip.equals(tips[i])) {
//
//                locations.add(i+1);
//            }
//        }
//        return locations;
//    }
//
//    public static void mergeImage(File[] finalImages, HttpServletResponse response) throws IOException {
//
//        //读取图片
//        BufferedImage mergeImage = new BufferedImage(800, 400, BufferedImage.TYPE_INT_BGR);
//
//        for (int i = 0; i < 8; i++) {
//            File image = finalImages[i];
//
//            BufferedImage bufferedImage = ImageIO.read(image);
//            int width = bufferedImage.getWidth();
//            int height = bufferedImage.getHeight();
//            //从图片中读取RGB
//            int[] imageBytes = new int[width*height];
//            imageBytes = bufferedImage.getRGB(0, 0, width, height, imageBytes, 0, width);
//            if ( i < 4) {
//                mergeImage.setRGB(i*200, 0, width, height, imageBytes, 0, width);
//            } else {
//                mergeImage.setRGB((i -4 )*200, 200, width, height, imageBytes, 0, width);
//            }
//
//        }
//
//
//        ImageIO.write(mergeImage, "jpg", response.getOutputStream());
//        //ImageIO.write(mergeImage, "jpg", destImage);
//    }
//}
