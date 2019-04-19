package com.bupt.qingzaoreading.service;

import com.bupt.qingzaoreading.po.User;

public interface UserRegisterLoginService {

    User getUserByPhoneNumber(User u);

    int getUserTotal();

    void addUser(User user);

    void setPasswordAndUserTypeToTrue(User user);

    User getUserByPhoneNumberAndPassword(User user);

    void updateUser(User user);

    User getUserById(String user_id);
}
