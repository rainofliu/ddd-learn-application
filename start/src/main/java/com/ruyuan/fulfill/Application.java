package com.ruyuan.fulfill;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot Starter
 *
 * @author Frank Zhang
 */
@SpringBootApplication(scanBasePackages = {"com.ruyuan.fulfill","com.alibaba.cola"})
@MapperScan("com.ruyuan.fulfill.infrastructure.gatewayimpl.database")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
