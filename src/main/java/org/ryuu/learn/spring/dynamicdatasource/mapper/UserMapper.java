package org.ryuu.learn.spring.dynamicdatasource.mapper;

import org.ryuu.learn.spring.dynamicdatasource.dto.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    List<User> selectAll();
}
