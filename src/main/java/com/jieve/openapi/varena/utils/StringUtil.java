package com.jieve.openapi.varena.utils;

import java.util.Random;

/**
 * @ClassName StringUtil
 * @Description 自定义字符串工具类
 * @Author Jieve
 * @Date 2018/9/5 22:12
 * @Version 1.0
 **/
public class StringUtil {

    /**
     * 私有构造器，不允许实例化
     */
    private StringUtil() {
    }

    /**
     * 获取固定长度的随机字符串
     * @param strLength
     * @return
     */
    public static String getFixLenthString(int strLength) {

        Random rm = new Random();
        // 获得随机数
        double pross = (1 + rm.nextDouble()) * Math.pow(10, strLength);
        String fixLenthString = String.valueOf(pross);
        // 返回固定的长度的随机数
        return fixLenthString.substring(2, strLength + 2);
    }
}
