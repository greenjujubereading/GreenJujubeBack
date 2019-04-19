package com.bupt.qingzaoreading.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "answer_record")
public class AnswerRecord {
    /**
     * id
     */
    @Id
    @Column(name = "answer_record_id")
    private Long answerRecordId;

    /**
     * 题目id
     */
    @Column(name = "question_id")
    private Long questionId;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 答题时间
     */
    private Date time;

    /**
     * 用户的选择
     */
    private String result;

    /**
     * 获取id
     *
     * @return answer_record_id - id
     */
    public Long getAnswerRecordId() {
        return answerRecordId;
    }

    /**
     * 设置id
     *
     * @param answerRecordId id
     */
    public void setAnswerRecordId(Long answerRecordId) {
        this.answerRecordId = answerRecordId;
    }

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
     * 获取答题时间
     *
     * @return time - 答题时间
     */
    public Date getTime() {
        return time;
    }

    /**
     * 设置答题时间
     *
     * @param time 答题时间
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * 获取用户的选择
     *
     * @return result - 用户的选择
     */
    public String getResult() {
        return result;
    }

    /**
     * 设置用户的选择
     *
     * @param result 用户的选择
     */
    public void setResult(String result) {
        this.result = result;
    }
}