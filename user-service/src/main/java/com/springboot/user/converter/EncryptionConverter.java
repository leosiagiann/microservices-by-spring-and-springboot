package com.springboot.user.converter;

import com.springboot.user.common.utils.EncryptionUtils;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @Author: Leonardo Siagian
 * Created on 08/03/2024
 */
@Converter
@Component
@Slf4j
@NoArgsConstructor
public class EncryptionConverter implements AttributeConverter<String, String> {
    @Override
    public String convertToDatabaseColumn(String attribute) {
        if (Objects.isNull(attribute)) {
            return null;
        }
        return EncryptionUtils.encrypt(attribute);
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        if (null == dbData) {
            return null;
        }
        return EncryptionUtils.decrypt(dbData);
    }
}
