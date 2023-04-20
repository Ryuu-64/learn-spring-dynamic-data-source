package org.ryuu.learn.spring.dynamicdatasource.controller;

import lombok.AllArgsConstructor;
import org.ryuu.learn.spring.dynamicdatasource.dto.User;
import org.ryuu.learn.spring.dynamicdatasource.service.impl.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("queryAll")
    public List<User> queryAll() {
        return userService.queryAll();
    }
}
