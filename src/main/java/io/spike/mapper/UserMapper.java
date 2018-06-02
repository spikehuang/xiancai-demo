package io.spike.mapper;

import io.spike.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    User getUserByPhone(String phone);

    User getUserById(Long userId);

    int saveUser(User user);

    int updateUserByUserId(User user);

    int removeUserByUserId(Integer userId);

    List<User> listUsers();
}
