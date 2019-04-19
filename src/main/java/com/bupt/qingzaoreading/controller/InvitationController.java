package com.bupt.qingzaoreading.controller;

import com.alibaba.fastjson.JSONObject;
import com.bupt.qingzaoreading.po.User;
import com.bupt.qingzaoreading.service.InvitationService;
import com.bupt.qingzaoreading.service.UserRegisterLoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Controller
public class InvitationController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private InvitationService invitationPageService;

    @Autowired
    private UserRegisterLoginService userRegisterLoginService;

    @RequestMapping("/invite")
    public String invitation(HttpServletRequest request, String id, ModelMap model) {
        System.out.println("id="+id);
        logger.info(String.format("getUserById()方法开始执行，参数use_id:{%s}",id));
        String user_name = userRegisterLoginService.getUserById(id).getUserName();
        logger.info(String.format("getUserById()方法结束，结果use_name:{%s}",user_name));
        HttpSession session = request.getSession();
        JSONObject json = null;
        json = new JSONObject();
        json.put("user_id", id);
        request.getSession().setAttribute("user_id", json);
        model.addAttribute("user_name", user_name);
        return "invite";
    }


    //invitee
    @RequestMapping("/invitee")
    @ResponseBody
    public Map<String,Object> invitee(HttpServletRequest request, String user_phone) {

        JSONObject json = (JSONObject)request.getSession().getAttribute("user_id");
        String  user_id =json.getString("user_id");
        System.out.println("user_id:"+user_id);
        System.out.println("user_phone:"+user_phone);
        int user_total=userRegisterLoginService.getUserTotal();
        User user=new User();
        user.setUserName("用户"+(user_total+1));
        user.setUserHeadPortraitUrl("szp.jpg");

        user.setUserIntegral(0L);
        user.setUserPassword(null);
        user.setUserInvitedUserId(Long.parseLong(user_id));
        user.setUserIsItVip("0");
        user.setUserMoney(new BigDecimal("0.0"));
        user.setUserPhone(user_phone);
        user.setUserStudentId(user_total+100000L);
        user.setUserType("0");
        user.setUserVipExpirationTime(null);
        user.setUserWechatNumber(null);
        logger.info(String.format("getUserByPhoneNumber()方法开始执行，参数use_phone:{%s}",user_phone));
        User u = userRegisterLoginService.getUserByPhoneNumber(user);
        logger.info(String.format("getUserByPhoneNumber()方法结束，结果use_id:{%s}",user.getUserId()));
        if(u==null){
            userRegisterLoginService.addUser(user);
        }
        Map map=new HashMap<String,Object>();
        map.put("result",true);
        return map;
    }

}
