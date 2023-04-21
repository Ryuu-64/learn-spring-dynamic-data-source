package org.ryuu.learn.spring.dynamicdatasource.controller;

import org.ryuu.learn.spring.dynamicdatasource.dto.User;
import org.ryuu.learn.spring.dynamicdatasource.service.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
@RestController
@RequestMapping("user/noDataSourceRouting/")
public class NoDataSourceRoutingUserController {
    private final UserService userService;

    public NoDataSourceRoutingUserController(
            @Qualifier("userServiceNoDataSourceRouting")
            UserService userService
    ) {
        this.userService = userService;
    }

    @PostMapping("queryAll")
    public List<User> queryAll() {
        return userService.queryAll();
    }
}
