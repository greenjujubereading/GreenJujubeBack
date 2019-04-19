package com.bupt.qingzaoreading.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user_login_log")
public class UserLoginLog {
    /**
     * id
     */
    @Id
    @Column(name = "user_login_log_id")
    private Long userLoginLogId;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 用户登陆或登出时间
     */
    @Column(name = "login_time")
    private Date loginTime;

    /**
     * 操作类型;1标识登陆；0标识登出
     */
    @Column(name = "operation_type")
    private String operationType;

    /**
     * 手机型号/设备号，手机标识。
     */
    @Column(name = "phone_model")
    private String phoneModel;

    /**
     * 获取id
     *
     * @return user_login_log_id - id
     */
    public Long getUserLoginLogId() {
        return userLoginLogId;
    }

    /**
     * 设置id
     *
     * @param userLoginLogId id
     */
    public void setUserLoginLogId(Long userLoginLogId) {
        this.userLoginLogId = userLoginLogId;
    }

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取用户登陆或登出时间
     *
     * @return login_time - 用户登陆或登出时间
     */
    public Date getLoginTime() {
        return loginTime;
    }

    /**
     * 设置用户登陆或登出时间
     *
     * @param loginTime 用户登陆或登出时间
     */
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    /**
     * 获取操作类型;1标识登陆；0标识登出
     *
     * @return operation_type - 操作类型;1标识登陆；0标识登出
     */
    public String getOperationType() {
        return operationType;
    }

    /**
     * 设置操作类型;1标识登陆；0标识登出
     *
     * @param operationType 操作类型;1标识登陆；0标识登出
     */
    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    /**
     * 获取手机型号/设备号，手机标识。
     *
     * @return phone_model - 手机型号/设备号，手机标识。
     */
    public String getPhoneModel() {
        return phoneModel;
    }

    /**
     * 设置手机型号/设备号，手机标识。
     *
     * @param phoneModel 手机型号/设备号，手机标识。
     */
    public void setPhoneModel(String phoneModel) {
        this.phoneModel = phoneModel;
    }
}