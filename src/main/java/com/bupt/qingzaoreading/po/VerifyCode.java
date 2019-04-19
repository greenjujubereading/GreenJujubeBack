package com.bupt.qingzaoreading.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "verify_code")
public class VerifyCode {
    /**
     * 用户手机号
     */
    @Id
    @Column(name = "user_phone")
    private String userPhone;

    /**
     * 验证码
     */
    @Column(name = "verify_code")
    private String verifyCode;

    /**
     * 时间
     */
    private Date data;

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
     * 获取验证码
     *
     * @return verify_code - 验证码
     */
    public String getVerifyCode() {
        return verifyCode;
    }

    /**
     * 设置验证码
     *
     * @param verifyCode 验证码
     */
    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    /**
     * 获取时间
     *
     * @return data - 时间
     */
    public Date getData() {
        return data;
    }

    /**
     * 设置时间
     *
     * @param data 时间
     */
    public void setData(Date data) {
        this.data = data;
    }
}