package com.springboot.user.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;

/**
 * @Author: Leonardo Siagian
 * Created on 13/03/2024
 */
@Slf4j
public class PropertyCopyUtil {
    public static void copyNonNullProperties(Object source, Object destination) {
        BeanWrapper srcWrapper = new BeanWrapperImpl(source);
        BeanWrapper destWrapper = new BeanWrapperImpl(destination);

        for (PropertyDescriptor propertyDescriptor : srcWrapper.getPropertyDescriptors()) {
            String propertyName = propertyDescriptor.getName();
            if (srcWrapper.getPropertyValue(propertyName) != null) {
                try {
                    destWrapper.setPropertyValue(propertyName, srcWrapper.getPropertyValue(propertyName));
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                }
            }
        }
    }
}
