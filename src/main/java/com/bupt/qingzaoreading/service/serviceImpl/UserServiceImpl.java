package com.bupt.qingzaoreading.service.serviceImpl;

import com.bupt.qingzaoreading.dao.UserMapper;
import com.bupt.qingzaoreading.po.User;
import com.bupt.qingzaoreading.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {
    /**
     *
     */
    @Autowired
    private UserMapper userMapper;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Override
    public User getUserInfoById(User user) {
        if(user!=null)
            System.out.println("in_service"+user.getUserId());
        return userMapper.getUserByid(user);
    }
}
