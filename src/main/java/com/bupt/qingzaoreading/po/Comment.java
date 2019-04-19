package com.bupt.qingzaoreading.po;

import java.util.Date;
import javax.persistence.*;

public class Comment {
    /**
     * 评论id
     */
    @Id
    @Column(name = "comment_id")
    private Long commentId;

    /**
     * 视频id
     */
    @Column(name = "video_id")
    private Long videoId;

    /**
     * 评论的用户id
     */
    @Column(name = "from_user_id")
    private Long fromUserId;

    /**
     * 回复的用户id
     */
    @Column(name = "to_user_id")
    private Long toUserId;

    /**
     * 主题类型
     */
    @Column(name = "topic_type")
    private String topicType;

    /**
     * 评论内容
     */
    private String cotent;

    /**
     * 评论时间
     */
    @Column(name = "comment_date")
    private Date commentDate;

    /**
     * 主题
     */
    @Column(name = "topic_id")
    private String topicId;

    /**
     * 获取评论id
     *
     * @return comment_id - 评论id
     */
    public Long getCommentId() {
        return commentId;
    }

    /**
     * 设置评论id
     *
     * @param commentId 评论id
     */
    public void setCommentId(Long commentId) {
        this.commentId = commentId;
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
     * 获取评论的用户id
     *
     * @return from_user_id - 评论的用户id
     */
    public Long getFromUserId() {
        return fromUserId;
    }

    /**
     * 设置评论的用户id
     *
     * @param fromUserId 评论的用户id
     */
    public void setFromUserId(Long fromUserId) {
        this.fromUserId = fromUserId;
    }

    /**
     * 获取回复的用户id
     *
     * @return to_user_id - 回复的用户id
     */
    public Long getToUserId() {
        return toUserId;
    }

    /**
     * 设置回复的用户id
     *
     * @param toUserId 回复的用户id
     */
    public void setToUserId(Long toUserId) {
        this.toUserId = toUserId;
    }

    /**
     * 获取主题类型
     *
     * @return topic_type - 主题类型
     */
    public String getTopicType() {
        return topicType;
    }

    /**
     * 设置主题类型
     *
     * @param topicType 主题类型
     */
    public void setTopicType(String topicType) {
        this.topicType = topicType;
    }

    /**
     * 获取评论内容
     *
     * @return cotent - 评论内容
     */
    public String getCotent() {
        return cotent;
    }

    /**
     * 设置评论内容
     *
     * @param cotent 评论内容
     */
    public void setCotent(String cotent) {
        this.cotent = cotent;
    }

    /**
     * 获取评论时间
     *
     * @return comment_date - 评论时间
     */
    public Date getCommentDate() {
        return commentDate;
    }

    /**
     * 设置评论时间
     *
     * @param commentDate 评论时间
     */
    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    /**
     * 获取主题
     *
     * @return topic_id - 主题
     */
    public String getTopicId() {
        return topicId;
    }

    /**
     * 设置主题
     *
     * @param topicId 主题
     */
    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }
}