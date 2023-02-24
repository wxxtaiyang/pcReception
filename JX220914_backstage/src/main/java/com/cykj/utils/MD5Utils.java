package com.cykj.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Utils {
    public static String md5Hex(String str){
        // 无密钥加密后的字符串
        String md5str = DigestUtils.md5Hex(str);
        return md5str;
    }
}
