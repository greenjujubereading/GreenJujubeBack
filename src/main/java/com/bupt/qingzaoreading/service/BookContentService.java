package com.bupt.qingzaoreading.service;

import com.bupt.qingzaoreading.po.Comment;
import com.bupt.qingzaoreading.po.UserCollection;
import com.bupt.qingzaoreading.po.UserHistory;
import com.bupt.qingzaoreading.po.Video;
import com.bupt.qingzaoreading.vo.CommentCustom;

import java.util.List;

public interface BookContentService {

    UserHistory getUserHistoryByvideoiduserid(UserHistory userhistory);

    void addUserHistory(UserHistory userhistory);

    void updataUserHistory(UserHistory userhistory);

    UserCollection getUserCollectionByvideoiduserid(UserCollection usercollection);

    void updataUserCollection(UserCollection usercollection);

    Video getBookById(String video_id);

    List<CommentCustom> getcommentbyid(String video_id);

    void addANewComment(Comment comment);

    String getparentguidancebyid(String video_id);
}
