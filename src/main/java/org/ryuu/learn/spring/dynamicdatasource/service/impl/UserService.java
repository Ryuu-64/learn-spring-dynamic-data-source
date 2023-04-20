package org.ryuu.learn.spring.dynamicdatasource.service.impl;

import lombok.AllArgsConstructor;
import org.ryuu.learn.spring.dynamicdatasource.DataSourceRouting;
import org.ryuu.learn.spring.dynamicdatasource.dto.User;
import org.ryuu.learn.spring.dynamicdatasource.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@DataSourceRouting(key = "schemaA")
public class UserService {
    private final UserMapper userMapper;

    public int create(User user) {
        return userMapper.insert(user);
    }

    public List<User> queryAll() {
        return userMapper.selectAll();
    }

    public User selectByUsername(String username) {
        return userMapper.selectByUsername(username);
    }

    public int deleteByUsername(String username) {
        return userMapper.deleteByUsername(username);
    }
}
