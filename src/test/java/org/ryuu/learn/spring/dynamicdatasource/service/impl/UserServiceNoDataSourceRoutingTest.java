package org.ryuu.learn.spring.dynamicdatasource.service.impl;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.MyBatisSystemException;
import org.ryuu.learn.spring.dynamicdatasource.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class UserServiceNoDataSourceRoutingTest {
    @Autowired
    @Qualifier("userServiceNoDataSourceRouting")
    private UserService userService;

    @Test
    void queryAll() {
        try {
            userService.queryAll();
        } catch (Exception e) {
            assertTrue(e instanceof MyBatisSystemException);
        }
    }
}