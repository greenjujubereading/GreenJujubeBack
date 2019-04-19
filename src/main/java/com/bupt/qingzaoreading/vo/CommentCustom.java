package com.bupt.qingzaoreading.vo;

import java.util.Date;

public class CommentCustom {

	private Long comment_id;

    private Long video_id;

    private Long from_user_id;

    private Long to_user_id;

    private String topic_type;

    private String cotent;

    private Date comment_date;

    private String topic_id;
    
    private String user_name;
    
    private String  user_grade;

    private String user_head_portrait_url;

	public Long getComment_id() {
		return comment_id;
	}

	public void setComment_id(Long comment_id) {
		this.comment_id = comment_id;
	}

	public Long getVideo_id() {
		return video_id;
	}

	public void setVideo_id(Long video_id) {
		this.video_id = video_id;
	}

	public Long getFrom_user_id() {
		return from_user_id;
	}

	public void setFrom_user_id(Long from_user_id) {
		this.from_user_id = from_user_id;
	}

	public Long getTo_user_id() {
		return to_user_id;
	}

	public void setTo_user_id(Long to_user_id) {
		this.to_user_id = to_user_id;
	}

	public String getTopic_type() {
		return topic_type;
	}

	public void setTopic_type(String topic_type) {
		this.topic_type = topic_type;
	}

	public String getCotent() {
		return cotent;
	}

	public void setCotent(String cotent) {
		this.cotent = cotent;
	}

	public Date getComment_date() {
		return comment_date;
	}

	public void setComment_date(Date comment_date) {
		this.comment_date = comment_date;
	}

	public String getTopic_id() {
		return topic_id;
	}

	public void setTopic_id(String topic_id) {
		this.topic_id = topic_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_grade() {
		return user_grade;
	}

	public void setUser_grade(String user_grade) {
		this.user_grade = user_grade;
	}

	public String getUser_head_portrait_url() {
		return user_head_portrait_url;
	}

	public void setUser_head_portrait_url(String user_head_portrait_url) {
		this.user_head_portrait_url = user_head_portrait_url;
	}
	  
	  
    
    
}
