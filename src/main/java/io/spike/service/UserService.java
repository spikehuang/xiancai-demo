package io.spike.service;

import io.spike.domain.User;

public interface UserService {

    User getUserByPhone(String phone);

    User getUserById(Long userId);

    int saveUser(User user);

}
