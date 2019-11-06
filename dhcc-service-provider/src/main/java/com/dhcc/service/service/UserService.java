package com.dhcc.service.service;

import com.dhcc.service.mapper.UserMapper;
import com.dhcc.service.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lipengfei
 * @create 2019-10-22-14:49
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public User queryUserById(Long id){
        return this.userMapper.selectByPrimaryKey(id);


    }

}
