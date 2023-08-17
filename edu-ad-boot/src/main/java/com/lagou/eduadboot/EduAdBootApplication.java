package com.lagou.eduadboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author HP广告位启动类
 */
@SpringBootApplication
@MapperScan("com.lagou.eduadboot.mapper")//对mapper注解扫描
public class EduAdBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduAdBootApplication.class,args);
    }
}
