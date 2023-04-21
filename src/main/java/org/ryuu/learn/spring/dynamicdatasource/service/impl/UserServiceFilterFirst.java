package org.ryuu.learn.spring.dynamicdatasource.service.impl;

import lombok.AllArgsConstructor;
import org.ryuu.learn.spring.dynamicdatasource.DataSourceRouting;
import org.ryuu.learn.spring.dynamicdatasource.PriorityPolicy;
import org.ryuu.learn.spring.dynamicdatasource.dto.User;
import org.ryuu.learn.spring.dynamicdatasource.mapper.UserMapper;
import org.ryuu.learn.spring.dynamicdatasource.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@DataSourceRouting(key = "schemaA", priorityPolicy = PriorityPolicy.FILTER_FIRST)
public class UserServiceFilterFirst implements UserService {
    private UserMapper userMapper;

    @Override
    public List<User> queryAll() {
        return userMapper.selectAll();
    }
}
