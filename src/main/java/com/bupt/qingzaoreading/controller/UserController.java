package com.bupt.qingzaoreading.controller;


import com.bupt.qingzaoreading.po.User;
import com.bupt.qingzaoreading.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


@Controller
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    
    @PostMapping(value = "/getUserInfoById")
    @ResponseBody
    public Map<String,Object> getUserInfoById(@RequestBody User user) {
        System.out.println("in");
        logger.info(String.format("getUserInfoById()方法开始执行，参数user:{%s}",user.getUserId()));
        Map map=new HashMap<String,Object>();
        if (user.getUserId() == null) {
            map.put("result",false);
            return map;
        }

        User u = userService.getUserInfoById(user);
        System.out.println("out"+u);

        if(u!=null){
            map.put("result",true);
            System.out.println("out"+u.getUserId());
        }
        else{
            map.put("result",false);
        }

        logger.info("getUserInfoById()方法结束执行");
        return map;
    }
}
