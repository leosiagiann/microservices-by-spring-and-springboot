package com.springboot.user.repository;

import com.springboot.user.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

/**
 * @Author: Leonardo Siagian
 * Created on 08/03/2024
 */
@RepositoryRestResource
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
