package io.spike.service;

import io.spike.domain.User;

import java.util.List;

public interface UserService {

    User getUserByPhone(String phone);

    User getUserById(Long userId);

    int saveUser(User user);

    int updateUserByUserId(User user);

    List<User> listUsers();

}
