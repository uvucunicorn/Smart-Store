package com.unicorn;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class SmartStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartStoreApplication.class, args);
        log.info("项目启动成功。。。。。。。。。。");
    }

}
