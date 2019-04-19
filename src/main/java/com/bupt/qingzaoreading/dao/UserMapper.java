package com.bupt.qingzaoreading.dao;

import com.bupt.qingzaoreading.po.User;
import com.bupt.qingzaoreading.util.MyMapper;

public interface UserMapper extends MyMapper<User> {

    User getUserByid(User user);

    User getUserByPhoneNumber(User user);

    int getUserTotal();

    void setPasswordAndUserTypeToTrue(User user);

    User getUserByPhoneNumberAndPassword(User user);

    void updateUser(User user);

    User getUserById(String user_id);
}