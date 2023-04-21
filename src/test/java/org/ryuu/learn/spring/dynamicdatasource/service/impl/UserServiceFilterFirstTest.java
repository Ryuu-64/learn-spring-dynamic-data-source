package org.ryuu.learn.spring.dynamicdatasource.service.impl;

import org.junit.jupiter.api.Test;
import org.ryuu.learn.spring.dynamicdatasource.dto.User;
import org.ryuu.learn.spring.dynamicdatasource.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceFilterFirstTest {
    @Autowired
    @Qualifier("userServiceFilterFirst")
    private UserService userService;

    @Test
    void queryAll() {
        List<User> users = userService.queryAll();
        assertNotEquals(0, users.size());
    }
}