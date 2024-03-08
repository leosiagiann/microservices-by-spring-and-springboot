package com.springboot.product.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * @Author: Leonardo Siagian
 * Created on 08/03/2024
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
                    // Handle exceptions if needed
                    log.error(e.getMessage(), e);
                }
            }
        }
    }
}
