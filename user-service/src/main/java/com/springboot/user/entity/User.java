package com.springboot.user.entity;

import com.springboot.user.converter.EncryptionConverter;
import com.springboot.user.converter.HashingConverter;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author: Leonardo Siagian
 * Created on 08/03/2024
 */
@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Convert(converter = EncryptionConverter.class)
    private String username;

    @Convert(converter = EncryptionConverter.class)
    private String email;

    @Convert(converter = HashingConverter.class)
    private String password;

    private Integer age;
}
