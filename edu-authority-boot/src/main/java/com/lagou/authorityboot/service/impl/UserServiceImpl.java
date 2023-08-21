package com.lagou.authorityboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lagou.authorityboot.entity.EduConstant;
import com.lagou.authorityboot.entity.User;
import com.lagou.authorityboot.entity.UserDTO;
import com.lagou.authorityboot.mapper.UserMapper;
import com.lagou.authorityboot.service.UserService;
import com.lagou.authorityboot.tool.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public UserDTO login(String phone, String password) {
        UserDTO<Object> dto = new UserDTO<>();
        QueryWrapper<User> qw = new QueryWrapper<User>();
        qw.eq("phone",phone);
        Integer integer = userMapper.selectCount(qw);
        if (integer == 0){
            /**
             * 手机不存在
             */
            dto.setState(EduConstant.ERROR_NOT_FOUND_PHONE_CODE);
            dto.setMessage(EduConstant.ERROR_NOT_FOUND_PHONE);
        }else {
            qw.eq("password",password);
            User user = userMapper.selectOne(qw);
            if (user == null){
                dto.setState(EduConstant.ERROR_PASSWORD_CODE);
                dto.setMessage(EduConstant.ERROR_PASSWORD);

            }else {
                dto.setState(EduConstant.LOGIN_SUCCESS_CODE);
                dto.setMessage(EduConstant.LOGIN_SUCCESS);
                // 生成token
                System.out.println(user.getId());
                String token = JwtUtil.createToken(user);
                // 将token保存到redis中，并设置过期时间
                redisTemplate.opsForValue().set(token,token,600, TimeUnit.SECONDS);
                dto.setToken(token);
            }

        }

        return dto;

    }

    @Override
    public UserDTO checkToken(String token) {
        return null;
    }
}
