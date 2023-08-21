package com.lagou.authorityboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author HP认证中心
 */
@SpringBootApplication
@MapperScan("com.lagou.authorityboot.mapper")
public class AuthorityApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthorityApplication.class,args);
    }
}
