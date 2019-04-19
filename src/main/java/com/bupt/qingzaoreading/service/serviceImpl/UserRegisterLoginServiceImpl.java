package com.bupt.qingzaoreading.service.serviceImpl;

import com.bupt.qingzaoreading.dao.UserMapper;
import com.bupt.qingzaoreading.po.User;
import com.bupt.qingzaoreading.service.UserRegisterLoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserRegisterLoginServiceImpl")
public class UserRegisterLoginServiceImpl implements UserRegisterLoginService {



    @Autowired
    private UserMapper userMapper;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public User getUserByPhoneNumber(User user) {
        // TODO Auto-generated method stub

        return userMapper.getUserByPhoneNumber(user);
    }

    @Override
    public int getUserTotal() {

        return userMapper.getUserTotal();
    }

    @Override
    public void addUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public void setPasswordAndUserTypeToTrue(User user) {
        userMapper.setPasswordAndUserTypeToTrue(user);
    }

    @Override
    public User getUserByPhoneNumberAndPassword(User user) {
        return userMapper.getUserByPhoneNumberAndPassword(user);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public User getUserById(String user_id) {
        return userMapper.getUserById(user_id);
    }


}
