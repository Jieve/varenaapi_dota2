package com.jieve.openapi.varena.utils;

import com.jieve.openapi.varena.commons.Constant;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @ClassName InitUtil
 * @Description 初始化配置
 * @Author Jieve
 * @Date 2018/9/5 21:39
 * @Version 1.0
 **/
public class InitUtil {

    public static void init(String configPath) throws IOException{

        FileInputStream in = null;
        try {
            Constant.properties = new Properties();
            in = new FileInputStream(configPath);
            Constant.properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        } finally {
            if (null != in){
                in.close();
            }
        }
    }
}
