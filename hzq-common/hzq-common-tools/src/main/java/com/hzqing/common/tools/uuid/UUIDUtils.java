package com.hzqing.common.tools.uuid;

import java.util.UUID;

/**
 * @author hzqing
 * @date 2019-08-17 10:04
 */
public class UUIDUtils {
    private UUIDUtils() {
        new Exception("私有构造不能实例!");
    }

    /**
     * 获取32位uuid
     * @return
     */
    public static String get32UUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}