package com.bupt.qingzaoreading.controller;


import com.bupt.qingzaoreading.md5.Md5;
import com.bupt.qingzaoreading.oss.FilePath;
import com.bupt.qingzaoreading.po.User;
import com.bupt.qingzaoreading.po.VerifyCode;
import com.bupt.qingzaoreading.service.UserRegisterLoginService;
import com.bupt.qingzaoreading.service.VerifyCodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;

@Controller
public class UserRegisterLoginController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserRegisterLoginService userRegisterLoginService;

    @Autowired
    private VerifyCodeService verifyCodeService;



    public static final String REGEX_MOBILE = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";


    @RequestMapping(value = {"/sendSms"}, method={RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public Map<String,Object> sendSms(String user_phone) {
        Map map=new HashMap<String,Object>();

        if(!Pattern.matches(REGEX_MOBILE, user_phone)) {
            map.put("result", false);
            map.put("information", "手机号错误");
            return map;
        }
        String testUsername = "qingzao"; //在短信宝注册的用户名
        String testPassword = "qingzao2018"; //在短信宝注册的密码
        String testPhone = user_phone;
        String verifyCode = String.valueOf(new Random().nextInt(899999) + 100000);
        String testContent = "【青枣读书】您的验证码为"+verifyCode+"，在1分钟内有效。"; // 注意测试时，也请带上公司简称或网站签名，发送正规内容短信。千万不要发送无意义的内容：例如 测一下、您好。否则可能会收不到

        String httpUrl = "http://api.smsbao.com/sms";

        StringBuffer httpArg = new StringBuffer();
        httpArg.append("u=").append(testUsername).append("&");
        httpArg.append("p=").append(md5(testPassword)).append("&");
        httpArg.append("m=").append(testPhone).append("&");
        httpArg.append("c=").append(encodeUrlString(testContent, "UTF-8"));

        //节约成本的开发
        //String result = request(httpUrl, httpArg.toString());

        System.out.println("验证码："+verifyCode);

        VerifyCode vc=new VerifyCode();
        vc.setUserPhone(user_phone);
        vc.setVerifyCode(verifyCode);
        vc.setData(new Date());
        verifyCodeService.deleteVerifyCode(vc);
        verifyCodeService.addVerifyCode(vc);
        map.put("result", true);
        map.put("information", "发送成功");
        return map;
    }


    //register
    /**
     *
     * @param user_phone
     * @param user_password
     * @param verifyCode
     * @return
     */

    @RequestMapping(value = {"/register"}, method={RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public Map<String,Object> register(
            String user_phone,
            String user_password,
            String verifyCode) {
//		System.out.println("user_phone"+user_phone);
//		System.out.println("user_password"+user_password);
//		System.out.println("verifyCode"+verifyCode);

        VerifyCode vc=verifyCodeService.getVerifyCodeByphone(user_phone);

        Map map=new HashMap<String,Object>();

        if(vc==null||(vc!=null&&!vc.getVerifyCode().equals(verifyCode))){

            map.put("result", false);
            map.put("date", "验证码错误");
            return map;
        }
        if(vc!=null) {
            long dis=new Date().getTime()-vc.getData().getTime();
            if(dis>1000*60) {
                map.put("result", false);
                map.put("date", "验证码超时");
                verifyCodeService.deleteVerifyCode(vc);
                return map;
            }
        }
        User u=new User();

        u.setUserPhone(user_phone);
        User user=userRegisterLoginService.getUserByPhoneNumber(u);
        int user_total=userRegisterLoginService.getUserTotal();


        if(user==null) {

            User newuser=new User();
            newuser.setUserName("用户"+(user_total+1));
            newuser.setUserHeadPortraitUrl("szp.jpg");

            newuser.setUserIntegral(0L);
            System.out.println("user_password"+user_password);
            if(user_password!=null &&!user_password.isEmpty())
                newuser.setUserPassword(Md5.GetMD5Code(user_password));
            else
                newuser.setUserPassword(null);
            newuser.setUserInvitedUserId(null);
            newuser.setUserIsItVip("0");
            newuser.setUserMoney(new BigDecimal("0.0"));
            newuser.setUserPhone(user_phone);
            newuser.setUserStudentId((user_total+1)+100000L);
            newuser.setUserType("1");
            newuser.setUserVipExpirationTime(null);
            newuser.setUserWechatNumber(null);
            userRegisterLoginService.addUser(newuser);
            map.put("result", true);
            map.put("information", "注册成功");

            map.put("user_name", newuser.getUserName());
            map.put("user_student_id", newuser.getUserStudentId());
            String url= FilePath.getUrl("szp.jpg");
            map.put("user_head_portrait_url", url);
            map.put("user_is_it_vip", newuser.getUserIsItVip());
            map.put("user_vip_expiration_time", newuser.getUserVipExpirationTime());
            map.put("user_sex", newuser.getUserSex());
            map.put("user_birthday", newuser.getUserBirthday());
            map.put("user_grade", newuser.getUserGrade());
            verifyCodeService.deleteVerifyCode(vc);
            return map;
        }
        else if(user.getUserId()!=null&&user.getUserType().equals("1")) //真用户
        {

            map.put("result", false);
            map.put("information", "手机号已经存在");
            verifyCodeService.deleteVerifyCode(vc);
            return map;
        }
        else //假用户
        {
            //给假用户设置密码
            System.out.println("给假用户设置密码"+user_password);
            System.out.println("用户名为"+user.getUserName());
            if(user.getUserPassword()!=null)
                user.setUserPassword(Md5.GetMD5Code(user_password));
            else
                user.setUserPassword(null);

            //修改用户密码和用户类型设为真用户
            userRegisterLoginService.setPasswordAndUserTypeToTrue(user);


            map.put("result", true);
            map.put("user_name", user.getUserName());

            map.put("user_name", user.getUserName());
            map.put("user_student_id", user.getUserStudentId());
            String url= FilePath.getUrl(user.getUserHeadPortraitUrl());
            map.put("user_head_portrait_url", url);
            map.put("user_is_it_vip", user.getUserIsItVip());
            map.put("user_vip_expiration_time", user.getUserVipExpirationTime());
            map.put("user_sex", user.getUserSex());
            map.put("user_birthday", user.getUserBirthday());
            map.put("user_grade", user.getUserGrade());
            verifyCodeService.deleteVerifyCode(vc);
            return map;
        }


    }



    @RequestMapping(value = {"/loginbypassword"}, method={RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public Map<String,Object> loginbypassword(
            HttpServletRequest request,
            String user_phone,
            String user_password) {

        Map map=new HashMap<String,Object>();

        User u=new User();

        u.setUserPhone(user_phone);
        u.setUserPassword(Md5.GetMD5Code(user_password));
        User user=userRegisterLoginService.getUserByPhoneNumberAndPassword(u);
        if(user==null)
            map.put("result", false);
        else
        {
            map.put("result", true);
            map.put("user_id", user.getUserId());
            map.put("user_name", user.getUserName());
            map.put("user_student_id", user.getUserStudentId());
            String url= FilePath.getUrl(user.getUserHeadPortraitUrl());
            map.put("user_head_portrait_url", url);
            map.put("user_is_it_vip", user.getUserIsItVip());
            map.put("user_vip_expiration_time", user.getUserVipExpirationTime());
            map.put("user_sex", user.getUserSex());
            map.put("user_birthday", user.getUserBirthday());
            map.put("user_grade", user.getUserGrade());
        }

        return map;


    }

    /**
     *注册登陆
     * @param user_phone
     * @param verifyCode
     * @return
     */
    @RequestMapping(value = {"/registerAndLogin"}, method={RequestMethod.POST, RequestMethod.GET})
@ResponseBody
public Map<String,Object> registerAndLogin(
        String user_phone,
        String verifyCode) {
    VerifyCode vc=verifyCodeService.getVerifyCodeByphone(user_phone);
    vc.setUserPhone(user_phone);
    Map map=new HashMap<String,Object>();

    if(vc!=null&&!vc.getVerifyCode().equals(verifyCode)){
        map.put("result", false);
        map.put("date", "验证码错误");
        return map;
    }
    if(vc!=null) {
        long dis=new Date().getTime()-vc.getData().getTime();

        if(dis>1000*60) {
            map.put("result", false);
            map.put("date", "验证码超时");
            verifyCodeService.deleteVerifyCode(vc);
            return map;
        }
    }
    User u=new User();

    u.setUserPhone(user_phone);
    User user=userRegisterLoginService.getUserByPhoneNumber(u);
    if(user==null) {
        //用户不存在，开始注册
        int user_total=userRegisterLoginService.getUserTotal();
        User newuser=new User();
        newuser.setUserName("用户"+(user_total+1));
        newuser.setUserHeadPortraitUrl("szp.jpg");

        newuser.setUserIntegral(0L);
        newuser.setUserPassword(null);
        newuser.setUserInvitedUserId(null);
        newuser.setUserIsItVip("0");
        newuser.setUserMoney(new BigDecimal("0.0"));
        newuser.setUserPhone(user_phone);
        newuser.setUserStudentId((user_total+1)+100000L);
        newuser.setUserType("1");
        newuser.setUserVipExpirationTime(null);
        newuser.setUserWechatNumber(null);
        userRegisterLoginService.addUser(newuser);
        map.put("result", true);
        map.put("information", "注册成功");

        map.put("user_name", newuser.getUserName());
        map.put("user_student_id", newuser.getUserStudentId());
        String url= FilePath.getUrl("szp.jpg");
        map.put("user_head_portrait_url", url);
        map.put("user_is_it_vip", newuser.getUserIsItVip());
        map.put("user_vip_expiration_time", newuser.getUserVipExpirationTime());
        map.put("user_sex", newuser.getUserSex());
        map.put("user_birthday", newuser.getUserBirthday());
        map.put("user_grade", newuser.getUserGrade());
        verifyCodeService.deleteVerifyCode(vc);
        return map;

    }
    else if(user.getUserType()=="1")//真用户，正常登陆
    {
        map.put("result", true);
        map.put("information", "登陆成功");
        map.put("user_id", user.getUserId());
        map.put("user_name", user.getUserName());
        map.put("user_student_id", user.getUserStudentId());
        String url=FilePath.getUrl(user.getUserHeadPortraitUrl());
        map.put("user_head_portrait_url", url);
        map.put("user_is_it_vip", user.getUserIsItVip());
        map.put("user_vip_expiration_time", user.getUserVipExpirationTime());
        map.put("user_sex", user.getUserSex());
        map.put("user_birthday", user.getUserBirthday());
        System.out.println("生日："+user.getUserBirthday());
        map.put("user_grade", user.getUserGrade());
        verifyCodeService.deleteVerifyCode(vc);
        return map;
    }
    //假用户，先注册修改用户属性在登陆
    else {

        user.setUserPassword(null);

        //修改用户密码和用户类型设为真用户
        userRegisterLoginService.setPasswordAndUserTypeToTrue(user);


        map.put("result", true);
        map.put("information", "注册登陆成功");
        map.put("user_name", user.getUserName());
        map.put("user_student_id", user.getUserStudentId());
        String url= FilePath.getUrl(user.getUserHeadPortraitUrl());
        map.put("user_head_portrait_url", url);
        map.put("user_is_it_vip", user.getUserIsItVip());
        map.put("user_vip_expiration_time", user.getUserVipExpirationTime());
        map.put("user_sex", user.getUserSex());
        map.put("user_birthday", user.getUserBirthday());
        map.put("user_grade", user.getUserGrade());
        verifyCodeService.deleteVerifyCode(vc);
        return map;
    }


}



    @RequestMapping(value = {"/loginbyverifycode"}, method={RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public Map<String,Object> login(
            String user_phone,
            String verifyCode) {
        VerifyCode vc=verifyCodeService.getVerifyCodeByphone(user_phone);
        vc.setUserPhone(user_phone);
        Map map=new HashMap<String,Object>();

        if(vc!=null&&!vc.getVerifyCode().equals(verifyCode)){
            map.put("result", false);
            map.put("date", "验证码错误");
            return map;
        }
        if(vc!=null) {
            long dis=new Date().getTime()-vc.getData().getTime();

            if(dis>1000*60) {

                map.put("result", false);
                map.put("date", "验证码超时");
                verifyCodeService.deleteVerifyCode(vc);
                return map;
            }
        }
        User u=new User();

        u.setUserPhone(user_phone);
        User user=userRegisterLoginService.getUserByPhoneNumber(u);
        if(user==null) {
            map.put("result", false);
        }
        else {
            map.put("result", true);
            map.put("user_id", user.getUserId());
            map.put("user_name", user.getUserName());
            map.put("user_student_id", user.getUserStudentId());
            String url=FilePath.getUrl(user.getUserHeadPortraitUrl());
            map.put("user_head_portrait_url", url);
            map.put("user_is_it_vip", user.getUserIsItVip());
            map.put("user_vip_expiration_time", user.getUserVipExpirationTime());
            map.put("user_sex", user.getUserSex());
            map.put("user_birthday", user.getUserBirthday());
            System.out.println("生日："+user.getUserBirthday());
            map.put("user_grade", user.getUserGrade());
        }
        verifyCodeService.deleteVerifyCode(vc);
        return map;


    }

    /**
     * 修改用户信息
     * @param user_id
     * @param name
     * @param gender
     * @param birthday
     * @param grade
     * @return
     */
    @RequestMapping(value = {"/updateuserinfo"}, method={RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public Map<String,Object> updateUserInfo(
            String user_id,
            String name,
            String gender,
            String birthday,
            String grade
    ){
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(birthday);
        Long saveBirthdaySecond = Long.parseLong(birthday);
        Date saveBirthday = new Date(saveBirthdaySecond);
        Map map=new HashMap<String,Object>();
        User user=new User();
        if(user_id!=null)
            user.setUserId(Long.valueOf(user_id));
        else
        {
            map.put("result",false);
            return  map;
        }
        user.setUserName(name);
        user.setUserBirthday(saveBirthday);
        user.setUserSex(gender);
        user.setUserGrade(grade);
        try{
            userRegisterLoginService.updateUser(user);
            map.put("result",true);
        }catch (Exception e){
            map.put("result",false);
        }
        return map;
    }


    public static String request(String httpUrl, String httpArg) {
        BufferedReader reader = null;
        String result = null;
        StringBuffer sbf = new StringBuffer();
        httpUrl = httpUrl + "?" + httpArg;

        try {
            URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            InputStream is = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String strRead = reader.readLine();
            if (strRead != null) {
                sbf.append(strRead);
                while ((strRead = reader.readLine()) != null) {
                    sbf.append("\n");
                    sbf.append(strRead);
                }
            }
            reader.close();
            result = sbf.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String md5(String plainText) {
        StringBuffer buf = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();
            int i;
            buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return buf.toString();
    }

    public static String encodeUrlString(String str, String charset) {
        String strret = null;
        if (str == null)
            return str;
        try {
            strret = java.net.URLEncoder.encode(str, charset);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return strret;
    }



}
