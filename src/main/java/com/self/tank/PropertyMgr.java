package com.self.tank;

import java.io.IOException;
import java.util.Properties;

/**
 * @Author: ZST
 * @Date: 2020/7/20
 */
public class PropertyMgr {
    private static Properties properties = new Properties();
    static {
        try {
            properties.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object getValue(String key) {
        if(properties == null) {
            return null;
        }
        return properties.get(key);
    }

    public static void main(String[] args) {
        System.out.println(PropertyMgr.getValue("enemy.tank.count"));
    }
}
