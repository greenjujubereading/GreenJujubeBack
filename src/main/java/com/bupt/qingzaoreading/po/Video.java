package com.bupt.qingzaoreading.po;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class Video {
    /**
     * 视频id
     */
    @Id
    @Column(name = "video_id")
    private Long videoId;

    /**
     * 视频名字
     */
    private String name;

    /**
     * 视频短介绍
     */
    @Column(name = "short_introduction")
    private String shortIntroduction;

    /**
     * 视频介绍
     */
    private String introduction;

    /**
     * 讲师id
     */
    @Column(name = "lecturer_id")
    private Long lecturerId;

    /**
     * 视频类型；0标识亲近文学；1标识益智科普
     */
    @Column(name = "video_type")
    private String videoType;

    /**
     * 视频分类的年级
     */
    @Column(name = "video_year")
    private String videoYear;

    /**
     * 阅读人数
     */
    @Column(name = "number_of_readers")
    private Long numberOfReaders;

    /**
     * 上架时间
     */
    private Date time;
    /**
     * 生效时间
     */
    @Column(name = "publish_time")
    private Date publishTime;

    /**
     * 是否推荐
     */
    private String recommend;

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    /**
     * 视频url
     */



    @Column(name = "video_url")
    private String videoUrl;

    /**
     * 视频封面url
     */
    @Column(name = "video_cover_url")
    private String videoCoverUrl;

    /**
     * 音频url
     */
    @Column(name = "sound_url")
    private String soundUrl;

    /**
     * 家长导读
     */
    @Column(name = "parental_guidance")
    private String parentalGuidance;

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
     * 获取视频名字
     *
     * @return name - 视频名字
     */
    public String getName() {
        return name;
    }

    /**
     * 设置视频名字
     *
     * @param name 视频名字
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取视频短介绍
     *
     * @return short_introduction - 视频短介绍
     */
    public String getShortIntroduction() {
        return shortIntroduction;
    }

    /**
     * 设置视频短介绍
     *
     * @param shortIntroduction 视频短介绍
     */
    public void setShortIntroduction(String shortIntroduction) {
        this.shortIntroduction = shortIntroduction;
    }

    /**
     * 获取视频介绍
     *
     * @return introduction - 视频介绍
     */
    public String getIntroduction() {
        return introduction;
    }

    /**
     * 设置视频介绍
     *
     * @param introduction 视频介绍
     */
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    /**
     * 获取讲师id
     *
     * @return lecturer_id - 讲师id
     */
    public Long getLecturerId() {
        return lecturerId;
    }

    /**
     * 设置讲师id
     *
     * @param lecturerId 讲师id
     */
    public void setLecturerId(Long lecturerId) {
        this.lecturerId = lecturerId;
    }

    /**
     * 获取视频类型；0标识亲近文学；1标识益智科普
     *
     * @return video_type - 视频类型；0标识亲近文学；1标识益智科普
     */
    public String getVideoType() {
        return videoType;
    }

    /**
     * 设置视频类型；0标识亲近文学；1标识益智科普
     *
     * @param videoType 视频类型；0标识亲近文学；1标识益智科普
     */
    public void setVideoType(String videoType) {
        this.videoType = videoType;
    }

    /**
     * 获取视频分类的年级
     *
     * @return video_year - 视频分类的年级
     */
    public String getVideoYear() {
        return videoYear;
    }

    /**
     * 设置视频分类的年级
     *
     * @param videoYear 视频分类的年级
     */
    public void setVideoYear(String videoYear) {
        this.videoYear = videoYear;
    }

    /**
     * 获取阅读人数
     *
     * @return number_of_readers - 阅读人数
     */
    public Long getNumberOfReaders() {
        return numberOfReaders;
    }

    /**
     * 设置阅读人数
     *
     * @param numberOfReaders 阅读人数
     */
    public void setNumberOfReaders(Long numberOfReaders) {
        this.numberOfReaders = numberOfReaders;
    }

    /**
     * 获取上架时间
     *
     * @return time - 上架时间
     */
    public Date getTime() {
        return time;
    }

    /**
     * 设置上架时间
     *
     * @param time 上架时间
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * 获取视频url
     *
     * @return video_url - 视频url
     */
    public String getVideoUrl() {
        return videoUrl;
    }

    /**
     * 设置视频url
     *
     * @param videoUrl 视频url
     */
    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    /**
     * 获取视频封面url
     *
     * @return video_cover_url - 视频封面url
     */
    public String getVideoCoverUrl() {
        return videoCoverUrl;
    }

    /**
     * 设置视频封面url
     *
     * @param videoCoverUrl 视频封面url
     */
    public void setVideoCoverUrl(String videoCoverUrl) {
        this.videoCoverUrl = videoCoverUrl;
    }

    /**
     * 获取音频url
     *
     * @return sound_url - 音频url
     */
    public String getSoundUrl() {
        return soundUrl;
    }

    /**
     * 设置音频url
     *
     * @param soundUrl 音频url
     */
    public void setSoundUrl(String soundUrl) {
        this.soundUrl = soundUrl;
    }

    /**
     * 获取家长导读
     *
     * @return parental_guidance - 家长导读
     */
    public String getParentalGuidance() {
        return parentalGuidance;
    }

    /**
     * 设置家长导读
     *
     * @param parentalGuidance 家长导读
     */
    public void setParentalGuidance(String parentalGuidance) {
        this.parentalGuidance = parentalGuidance;
    }
}