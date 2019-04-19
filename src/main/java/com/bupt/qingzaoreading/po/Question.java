package com.bupt.qingzaoreading.po;

import javax.persistence.*;

public class Question {
    /**
     * 题目id
     */
    @Id
    @Column(name = "question_id")
    private Long questionId;

    /**
     * 视频id
     */
    @Column(name = "video_id")
    private Long videoId;

    /**
     * 题干
     */
    @Column(name = "`question _content`")
    private String questionContent;

    /**
     * 选项a
     */
    @Column(name = "option_a")
    private String optionA;

    /**
     * 选项b
     */
    @Column(name = "option_b")
    private String optionB;

    /**
     * 选项c
     */
    @Column(name = "option_c")
    private String optionC;

    /**
     * 选项d
     */
    @Column(name = "option_d")
    private String optionD;

    /**
     * 答案
     */
    private String answer;

    /**
     * 答案解析
     */
    @Column(name = "answer_analysis")
    private String answerAnalysis;

    /**
     * 获取题目id
     *
     * @return question_id - 题目id
     */
    public Long getQuestionId() {
        return questionId;
    }

    /**
     * 设置题目id
     *
     * @param questionId 题目id
     */
    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
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
     * 获取题干
     *
     * @return question _content - 题干
     */
    public String getQuestionContent() {
        return questionContent;
    }

    /**
     * 设置题干
     *
     * @param questionContent 题干
     */
    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    /**
     * 获取选项a
     *
     * @return option_a - 选项a
     */
    public String getOptionA() {
        return optionA;
    }

    /**
     * 设置选项a
     *
     * @param optionA 选项a
     */
    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    /**
     * 获取选项b
     *
     * @return option_b - 选项b
     */
    public String getOptionB() {
        return optionB;
    }

    /**
     * 设置选项b
     *
     * @param optionB 选项b
     */
    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    /**
     * 获取选项c
     *
     * @return option_c - 选项c
     */
    public String getOptionC() {
        return optionC;
    }

    /**
     * 设置选项c
     *
     * @param optionC 选项c
     */
    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    /**
     * 获取选项d
     *
     * @return option_d - 选项d
     */
    public String getOptionD() {
        return optionD;
    }

    /**
     * 设置选项d
     *
     * @param optionD 选项d
     */
    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    /**
     * 获取答案
     *
     * @return answer - 答案
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * 设置答案
     *
     * @param answer 答案
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * 获取答案解析
     *
     * @return answer_analysis - 答案解析
     */
    public String getAnswerAnalysis() {
        return answerAnalysis;
    }

    /**
     * 设置答案解析
     *
     * @param answerAnalysis 答案解析
     */
    public void setAnswerAnalysis(String answerAnalysis) {
        this.answerAnalysis = answerAnalysis;
    }
}