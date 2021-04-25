package com.IoT.data.access.backend.common.utils;

import java.util.UUID;

/**
 * @author NIUNIU
 * @version 1.0
 * @date 2021/4/23 14:13
 */
public class UUIDGenerator {

    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }

}
