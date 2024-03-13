package com.springboot.user.service;

import com.springboot.user.dto.request.UserRequestDTO;
import com.springboot.user.entity.User;
import com.springboot.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @Author: Leonardo Siagian
 * Created on 13/03/2024
 */
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public void register(UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setName(userRequestDTO.getName());
        user.setUsername(userRequestDTO.getUsername());
        user.setEmail(userRequestDTO.getEmail());
        user.setPassword(userRequestDTO.getPassword());
        user.setAge(userRequestDTO.getAge());
        userRepository.save(user);
    }
}
