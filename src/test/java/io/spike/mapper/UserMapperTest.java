package io.spike.mapper;

import io.spike.XianCaiDemoApplication;
import io.spike.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserMapper userMapper;

    @Test
    public void getUserByPhone() throws Exception {
        String phone = "15600057761";
        User user = userMapper.getUserByPhone(phone);
        logger.info("user={}", user);
    }

    @Test
    public void saveUser() throws Exception {
        User user = new User();
        user.setPhone("13482930474");
        user.setPassword("123");
        user.setUsername("test");
        user.setRealName("测试");
        int insertCount = userMapper.saveUser(user);
        logger.info("insertCount={}", insertCount);
    }

    @Test
    public void updateUserByUserId() throws Exception {
    }

    @Test
    public void removeUserByUserId() throws Exception {
    }

    @Test
    public void listUsers() throws Exception {
    }

}