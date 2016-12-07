package com.aiyun.utils;

import java.util.UUID;

/**
 * UUID生成工具
 */
public class UUIDGenerator {

    /**
     * 生成UUID
     * @return
     */
    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    /**
     * 获得指定数量的UUID
     * @param number
     * @return
     */
    public static String[] getUUID(int number) {
        if (number < 1) {
            return null;
        }
        String[] ss = new String[number];
        for (int i = 0; i < number; i++) {
            ss[i] = getUUID();
        }
        return ss;
    }

}
