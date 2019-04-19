package com.bupt.qingzaoreading.po;

import javax.persistence.Column;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

public class User {
    /**
     * 用户id,用户唯一标识
     */
    @Id
    @Column(name = "user_id")
    private Long userId;

    /**
     * 用户的学号=user_id+100000
     */
    @Column(name = "user_student_id")
    private Long userStudentId;

    /**
     * 用户姓名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 出生年月
     */
    @Column(name = "user_birthday")
    private Date userBirthday;

    /**
     * 用户性别
     */
    @Column(name = "user_sex")
    private String userSex;

    /**
     * 用户手机号
     */
    @Column(name = "user_phone")
    private String userPhone;

    /**
     * 用户是否是vip;1标识是；0标识不是
     */
    @Column(name = "user_is_it_vip")
    private String userIsItVip;

    /**
     * 用户vip到期时间
     */
    @Column(name = "user_vip_expiration_time")
    private Date userVipExpirationTime;

    /**
     * 被邀请的用户id,就是邀请本用户的那个用户id
     */
    @Column(name = "user_invited_user_id")
    private Long userInvitedUserId;

    /**
     * 用户积分
     */
    @Column(name = "user_integral")
    private Long userIntegral;

    /**
     * 用户余额
     */
    @Column(name = "user_money")
    private BigDecimal userMoney;

    /**
     * 用户微信号
     */
    @Column(name = "user_wechat_number")
    private String userWechatNumber;

    /**
     * 用户类型;0标识“假“用户；1标识“真”用户
     */
    @Column(name = "user_type")
    private String userType;

    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "user_grade")
    private String userGrade;

    /**
     * 用户头像url
     */
    @Column(name = "user_head_portrait_url")
    private String userHeadPortraitUrl;

    /**
     * 获取用户id,用户唯一标识
     *
     * @return user_id - 用户id,用户唯一标识
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户id,用户唯一标识
     *
     * @param userId 用户id,用户唯一标识
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取用户的学号=user_id+100000
     *
     * @return user_student_id - 用户的学号=user_id+100000
     */
    public Long getUserStudentId() {
        return userStudentId;
    }

    /**
     * 设置用户的学号=user_id+100000
     *
     * @param userStudentId 用户的学号=user_id+100000
     */
    public void setUserStudentId(Long userStudentId) {
        this.userStudentId = userStudentId;
    }

    /**
     * 获取用户姓名
     *
     * @return user_name - 用户姓名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户姓名
     *
     * @param userName 用户姓名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取出生年月
     *
     * @return user_birthday - 出生年月
     */
    public Date getUserBirthday() {
        return userBirthday;
    }

    /**
     * 设置出生年月
     *
     * @param userBirthday 出生年月
     */
    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    /**
     * 获取用户性别
     *
     * @return user_sex - 用户性别
     */
    public String getUserSex() {
        return userSex;
    }

    /**
     * 设置用户性别
     *
     * @param userSex 用户性别
     */
    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    /**
     * 获取用户手机号
     *
     * @return user_phone - 用户手机号
     */
    public String getUserPhone() {
        return userPhone;
    }

    /**
     * 设置用户手机号
     *
     * @param userPhone 用户手机号
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    /**
     * 获取用户是否是vip;1标识是；0标识不是
     *
     * @return user_is_it_vip - 用户是否是vip;1标识是；0标识不是
     */
    public String getUserIsItVip() {
        return userIsItVip;
    }

    /**
     * 设置用户是否是vip;1标识是；0标识不是
     *
     * @param userIsItVip 用户是否是vip;1标识是；0标识不是
     */
    public void setUserIsItVip(String userIsItVip) {
        this.userIsItVip = userIsItVip;
    }

    /**
     * 获取用户vip到期时间
     *
     * @return user_vip_expiration_time - 用户vip到期时间
     */
    public Date getUserVipExpirationTime() {
        return userVipExpirationTime;
    }

    /**
     * 设置用户vip到期时间
     *
     * @param userVipExpirationTime 用户vip到期时间
     */
    public void setUserVipExpirationTime(Date userVipExpirationTime) {
        this.userVipExpirationTime = userVipExpirationTime;
    }

    /**
     * 获取被邀请的用户id,就是邀请本用户的那个用户id
     *
     * @return user_invited_user_id - 被邀请的用户id,就是邀请本用户的那个用户id
     */
    public Long getUserInvitedUserId() {
        return userInvitedUserId;
    }

    /**
     * 设置被邀请的用户id,就是邀请本用户的那个用户id
     *
     * @param userInvitedUserId 被邀请的用户id,就是邀请本用户的那个用户id
     */
    public void setUserInvitedUserId(Long userInvitedUserId) {
        this.userInvitedUserId = userInvitedUserId;
    }

    /**
     * 获取用户积分
     *
     * @return user_integral - 用户积分
     */
    public Long getUserIntegral() {
        return userIntegral;
    }

    /**
     * 设置用户积分
     *
     * @param userIntegral 用户积分
     */
    public void setUserIntegral(Long userIntegral) {
        this.userIntegral = userIntegral;
    }

    /**
     * 获取用户余额
     *
     * @return user_money - 用户余额
     */
    public BigDecimal getUserMoney() {
        return userMoney;
    }

    /**
     * 设置用户余额
     *
     * @param userMoney 用户余额
     */
    public void setUserMoney(BigDecimal userMoney) {
        this.userMoney = userMoney;
    }

    /**
     * 获取用户微信号
     *
     * @return user_wechat_number - 用户微信号
     */
    public String getUserWechatNumber() {
        return userWechatNumber;
    }

    /**
     * 设置用户微信号
     *
     * @param userWechatNumber 用户微信号
     */
    public void setUserWechatNumber(String userWechatNumber) {
        this.userWechatNumber = userWechatNumber;
    }

    /**
     * 获取用户类型;0标识“假“用户；1标识“真”用户
     *
     * @return user_type - 用户类型;0标识“假“用户；1标识“真”用户
     */
    public String getUserType() {
        return userType;
    }

    /**
     * 设置用户类型;0标识“假“用户；1标识“真”用户
     *
     * @param userType 用户类型;0标识“假“用户；1标识“真”用户
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     * @return user_password
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * @param userPassword
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * @return user_grade
     */
    public String getUserGrade() {
        return userGrade;
    }

    /**
     * @param userGrade
     */
    public void setUserGrade(String userGrade) {
        this.userGrade = userGrade;
    }

    /**
     * 获取用户头像url
     *
     * @return user_head_portrait_url - 用户头像url
     */
    public String getUserHeadPortraitUrl() {
        return userHeadPortraitUrl;
    }

    /**
     * 设置用户头像url
     *
     * @param userHeadPortraitUrl 用户头像url
     */
    public void setUserHeadPortraitUrl(String userHeadPortraitUrl) {
        this.userHeadPortraitUrl = userHeadPortraitUrl;
    }
}