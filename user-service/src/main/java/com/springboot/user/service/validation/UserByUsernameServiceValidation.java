package com.springboot.user.service.validation;

import com.springboot.user.entity.User;
import com.springboot.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @Author: Leonardo Siagian
 * Created on 14/03/2024
 */
@Service
@RequiredArgsConstructor
public class UserByUsernameServiceValidation {
    private User user;

    private final UserRepository userRepository;
    public User getUserByUsername(String username) {
        if (Objects.isNull(user)) {
            return userRepository.findByUsername(username).orElse(null);
        }
        return user;
    }
}
