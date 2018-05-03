package io.spike.mapper;

import io.spike.domain.User;

import java.util.List;

public interface UserMapper {

    User getUserByPhone(String phone);

    int saveUser(User user);

    int updateUserByUserId(User user);

    int removeUserByUserId(Integer userId);

    List<User> listUsers();
}
