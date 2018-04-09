package io.spike;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableAutoConfiguration
@MapperScan("io.spike.mapper")
public class XianCaiDemoApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(XianCaiDemoApplication.class, args);
    }
}
