package com.example.demotest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demotest.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {
}
