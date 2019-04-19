package com.bupt.qingzaoreading.dao;

import com.bupt.qingzaoreading.po.Comment;
import com.bupt.qingzaoreading.util.MyMapper;
import com.bupt.qingzaoreading.vo.CommentCustom;

import java.util.List;

public interface CommentMapper extends MyMapper<Comment> {
    
    List<CommentCustom> getcommentbyid(String video_id);

    void addANewComment(Comment comment);
}