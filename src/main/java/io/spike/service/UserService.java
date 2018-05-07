package io.spike.service;

import io.spike.domain.User;

public interface UserService {

    User getUserByPhone(String phone);

    int saveUser(User user);

}
