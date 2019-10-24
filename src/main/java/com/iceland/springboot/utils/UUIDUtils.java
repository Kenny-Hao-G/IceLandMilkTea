package com.iceland.springboot.utils;

import java.util.UUID;

public class UUIDUtils {

    public static String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
