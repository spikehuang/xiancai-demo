package io.spike.service.impl;

import io.spike.domain.User;
import io.spike.mapper.UserMapper;
import io.spike.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByPhone(String phone) {
        return userMapper.getUserByPhone(phone);
    }

    @Override
    public int saveUser(User user) {
        return userMapper.saveUser(user);
    }
}
