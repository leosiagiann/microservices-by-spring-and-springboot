package com.springboot.user.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @Author: Leonardo Siagian
 * Created on 08/03/2024
 */
@Slf4j
@Component
public class EncryptionUtils {

    public static final String ALGORITHM_STR = "AES/ECB/PKCS5Padding";
    public static final String ALGORITHM_NAME = "AES";

    public static byte[] accessTokenEncryptionKey;

    @Autowired
    public void setAccessTokenEncryptionKey(@Value("${encrypt.security.secret-key}") String accessTokenEncryptionKey) {
        EncryptionUtils.accessTokenEncryptionKey = accessTokenEncryptionKey.getBytes(StandardCharsets.ISO_8859_1);
    }

    public static String encrypt(String attribute) {
        try {
            Cipher encryptCipher=Cipher.getInstance(ALGORITHM_STR);
            encryptCipher.init(1, new SecretKeySpec(accessTokenEncryptionKey, ALGORITHM_NAME));
            byte[] encryptedBytes = encryptCipher.doFinal(attribute.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception ex) {
            log.error("EncryptionConverter::convertToDatabaseColumn detail ", ex);
            return attribute;
        }
    }

    public static String decrypt(String attribute) {
        try {
            Cipher decryptionCipher = Cipher.getInstance(ALGORITHM_STR);
            decryptionCipher.init(2, new SecretKeySpec(accessTokenEncryptionKey, ALGORITHM_NAME));
            byte[] decryptedBytes = decryptionCipher.doFinal(Base64.getDecoder().decode(attribute));
            return new String(decryptedBytes);
        } catch (Exception e) {
            log.error("EncryptionConverter::convertToEntityAttribute detail, attribute:{}", attribute, e);
            return attribute;
        }
    }
}
