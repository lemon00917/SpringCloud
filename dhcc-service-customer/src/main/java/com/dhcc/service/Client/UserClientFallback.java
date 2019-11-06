package com.dhcc.service.Client;

import com.dhcc.service.pojo.User;
import org.springframework.stereotype.Component;

@Component
public class UserClientFallback implements UserClient{
    @Override
    public User queryUserById(Long id) {
        User user=new User();
        user.setPassword("服务器正忙，请稍后再试！！");
        return user;
    }
}
