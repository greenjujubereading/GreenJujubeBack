package com.bupt.qingzaoreading.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user_history")
public class UserHistory {
    /**
     * id
     */
    @Id
    @Column(name = "user_history_id")
    private Long userHistoryId;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 视频id
     */
    @Column(name = "video_id")
    private Long videoId;

    /**
     * 时间
     */
    private Date time;

    /**
     * 播放次数
     */
    private Integer number;

    /**
     * 获取id
     *
     * @return user_history_id - id
     */
    public Long getUserHistoryId() {
        return userHistoryId;
    }

    /**
     * 设置id
     *
     * @param userHistoryId id
     */
    public void setUserHistoryId(Long userHistoryId) {
        this.userHistoryId = userHistoryId;
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
     * 获取视频id
     *
     * @return video_id - 视频id
     */
    public Long getVideoId() {
        return videoId;
    }

    /**
     * 设置视频id
     *
     * @param videoId 视频id
     */
    public void setVideoId(Long videoId) {
        this.videoId = videoId;
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
     * 获取播放次数
     *
     * @return number - 播放次数
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * 设置播放次数
     *
     * @param number 播放次数
     */
    public void setNumber(Integer number) {
        this.number = number;
    }
}