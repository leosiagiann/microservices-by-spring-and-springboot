package com.springboot.user.validator;

import com.springboot.user.entity.User;
import com.springboot.user.service.validation.UserByUsernameServiceValidation;
import com.springboot.user.validator.constraint.UsernameMustExists;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @Author: Leonardo Siagian
 * Created on 14/03/2024
 */
@Component
@RequiredArgsConstructor
public class UsernameMustExistsValidator implements ConstraintValidator<UsernameMustExists, String> {
    private final UserByUsernameServiceValidation userByUsernameServiceValidation;
    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        User user = userByUsernameServiceValidation.getUserByUsername(username);
        return Objects.isNull(user);
    }
}
