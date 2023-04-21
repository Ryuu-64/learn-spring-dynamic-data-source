package org.ryuu.learn.spring.dynamicdatasource.service;

import org.ryuu.learn.spring.dynamicdatasource.dto.User;

import java.util.List;

public interface UserService {
    List<User> queryAll();
}
