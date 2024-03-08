package com.springboot.user.configuration;

import com.springboot.user.service.HashService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Leonardo Siagian
 * Created on 08/03/2024
 */
@Configuration
public class PropertiesConfiguration {
    @Value("${encrypt.security.hashCount}")
    private Integer hashCount;
    @Value("${encrypt.security.salt}")
    private String salt;
    @Bean
    public HashService hashService() {
        return new HashService().setHashCount(hashCount).setSalt(salt);
    }
}
