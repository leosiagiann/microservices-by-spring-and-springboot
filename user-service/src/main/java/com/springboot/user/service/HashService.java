package com.springboot.user.service;

import io.micrometer.common.util.StringUtils;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * @Author: Leonardo Siagian
 * Created on 08/03/2024
 */
public class HashService {

    private String salt = "";
    private int hashCount = 1;

    public HashService setSalt(String salt) {
        if (StringUtils.isNotBlank(salt)) {
            this.salt = salt;
        }
        return this;
    }

    public HashService setHashCount(int hashCount) {
        if (hashCount >= 0) {
            this.hashCount = hashCount;
        }
        return this;
    }

    public String encrypt(String originValue) {
        if (StringUtils.isBlank(originValue)) {
            return "";
        }
        String encryptedValue = originValue.trim();
        for (int i = 0; i < this.hashCount; i++) {
            encryptedValue = DigestUtils.md5Hex(encryptedValue + this.salt);
        }
        return encryptedValue;
    }
}
