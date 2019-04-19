package com.bupt.qingzaoreading.po;

import javax.persistence.*;

public class Lecturer {
    /**
     * 讲师id
     */
    @Id
    @Column(name = "lecturer_id")
    private Long lecturerId;

    /**
     * 讲师姓名
     */
    @Column(name = "lecturer_name")
    private String lecturerName;

    /**
     * 讲师头像url
     */
    @Column(name = "lecturer_head_portrait_url")
    private String lecturerHeadPortraitUrl;

    /**
     * 讲师介绍
     */
    @Column(name = "lecturer_introduction")
    private String lecturerIntroduction;

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
     * 获取讲师姓名
     *
     * @return lecturer_name - 讲师姓名
     */
    public String getLecturerName() {
        return lecturerName;
    }

    /**
     * 设置讲师姓名
     *
     * @param lecturerName 讲师姓名
     */
    public void setLecturerName(String lecturerName) {
        this.lecturerName = lecturerName;
    }

    /**
     * 获取讲师头像url
     *
     * @return lecturer_head_portrait_url - 讲师头像url
     */
    public String getLecturerHeadPortraitUrl() {
        return lecturerHeadPortraitUrl;
    }

    /**
     * 设置讲师头像url
     *
     * @param lecturerHeadPortraitUrl 讲师头像url
     */
    public void setLecturerHeadPortraitUrl(String lecturerHeadPortraitUrl) {
        this.lecturerHeadPortraitUrl = lecturerHeadPortraitUrl;
    }

    /**
     * 获取讲师介绍
     *
     * @return lecturer_introduction - 讲师介绍
     */
    public String getLecturerIntroduction() {
        return lecturerIntroduction;
    }

    /**
     * 设置讲师介绍
     *
     * @param lecturerIntroduction 讲师介绍
     */
    public void setLecturerIntroduction(String lecturerIntroduction) {
        this.lecturerIntroduction = lecturerIntroduction;
    }
}