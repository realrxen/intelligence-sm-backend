package cn.edu.cumt.sm.utils;

import java.util.UUID;

/**
 * @author Seeumt
 * @version 1.0
 * @date 2020/5/3 23:46
 */
public class UuidUtil {
    public static String getUuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
