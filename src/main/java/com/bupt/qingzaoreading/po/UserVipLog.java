package com.bupt.qingzaoreading.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user_vip_log")
public class UserVipLog {
    /**
     * id
     */
    @Id
    @Column(name = "user_vip_log_id")
    private Long userVipLogId;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 增加的vip时长
     */
    @Column(name = "increased_vip_duration")
    private Integer increasedVipDuration;

    /**
     * 时间
     */
    private Date time;

    /**
     * 获得VIP时长的操作类型;0标识分享用户获得的vip时长；1标识花钱获得vip时长
     */
    @Column(name = "operation_type")
    private String operationType;

    /**
     * 获取id
     *
     * @return user_vip_log_id - id
     */
    public Long getUserVipLogId() {
        return userVipLogId;
    }

    /**
     * 设置id
     *
     * @param userVipLogId id
     */
    public void setUserVipLogId(Long userVipLogId) {
        this.userVipLogId = userVipLogId;
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
     * 获取增加的vip时长
     *
     * @return increased_vip_duration - 增加的vip时长
     */
    public Integer getIncreasedVipDuration() {
        return increasedVipDuration;
    }

    /**
     * 设置增加的vip时长
     *
     * @param increasedVipDuration 增加的vip时长
     */
    public void setIncreasedVipDuration(Integer increasedVipDuration) {
        this.increasedVipDuration = increasedVipDuration;
    }

    /**
     * 获取时间
     *
     * @return time - 时间
     */
    public Date getTime() {
        return time;
    }

    /**
     * 设置时间
     *
     * @param time 时间
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * 获取获得VIP时长的操作类型;0标识分享用户获得的vip时长；1标识花钱获得vip时长
     *
     * @return operation_type - 获得VIP时长的操作类型;0标识分享用户获得的vip时长；1标识花钱获得vip时长
     */
    public String getOperationType() {
        return operationType;
    }

    /**
     * 设置获得VIP时长的操作类型;0标识分享用户获得的vip时长；1标识花钱获得vip时长
     *
     * @param operationType 获得VIP时长的操作类型;0标识分享用户获得的vip时长；1标识花钱获得vip时长
     */
    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }
}