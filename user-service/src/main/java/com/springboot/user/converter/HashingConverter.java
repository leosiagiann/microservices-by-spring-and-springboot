package com.springboot.user.converter;

import com.springboot.user.service.HashService;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @Author: Leonardo Siagian
 * Created on 08/03/2024
 */
@Converter
@Component
@RequiredArgsConstructor
public class HashingConverter implements AttributeConverter<String, String> {
    private final HashService hashService;
    @Override
    public String convertToDatabaseColumn(String attribute) {
        return hashService.encrypt(attribute);
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        return dbData;
    }
}
