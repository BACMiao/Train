package com.bapocalypse.train.po;

import java.util.HashMap;
import java.util.Map;

/**
 * @package: com.bapocalypse.train.po
 * @Author: 陈淼
 * @Date: 2016/11/12
 * @Description:
 */
public class Cache {
    private static Map<String, ImageResult> cache = new HashMap<>();

    public static void put(String note, ImageResult ir){
        cache.put(note, ir);
    }

    public static ImageResult get(String note){
        return cache.get(note);
    }

    public static void remove(String note){
        cache.remove(note);
    }
}
