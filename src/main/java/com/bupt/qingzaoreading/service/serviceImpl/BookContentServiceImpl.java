package com.bupt.qingzaoreading.service.serviceImpl;

import com.bupt.qingzaoreading.dao.CommentMapper;
import com.bupt.qingzaoreading.dao.UserCollectionMapper;
import com.bupt.qingzaoreading.dao.UserHistoryMapper;
import com.bupt.qingzaoreading.dao.VideoMapper;
import com.bupt.qingzaoreading.po.Comment;
import com.bupt.qingzaoreading.po.UserCollection;
import com.bupt.qingzaoreading.po.UserHistory;
import com.bupt.qingzaoreading.po.Video;
import com.bupt.qingzaoreading.service.BookContentService;
import com.bupt.qingzaoreading.vo.CommentCustom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("BookContentServiceImpl")
public class BookContentServiceImpl implements BookContentService {

    @Autowired
    private UserHistoryMapper userHistoryMapper;

    @Autowired
    private UserCollectionMapper userCollectionMapper;


    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private CommentMapper commentMapper;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Override
    public UserHistory getUserHistoryByvideoiduserid(UserHistory userhistory) {
        return userHistoryMapper.getUserHistoryByvideoiduserid( userhistory);
    }

    @Override
    public void addUserHistory(UserHistory userhistory) {

        userHistoryMapper.addUserHistory( userhistory);
    }



    @Override
    public void updataUserHistory(UserHistory userhistory) {

        userHistoryMapper.updataUserHistory(userhistory);
    }

    @Override
    public UserCollection getUserCollectionByvideoiduserid(UserCollection usercollection) {
        return userCollectionMapper.getUserCollectionByvideoiduserid(usercollection);
    }

    @Override
    public void updataUserCollection(UserCollection usercollection) {
        userCollectionMapper.updataUserCollection(usercollection);
    }

    @Override
    public Video getBookById(String video_id) {
        return videoMapper.getBookById(video_id);
    }

    @Override
    public List<CommentCustom> getcommentbyid(String video_id) {
        return commentMapper.getcommentbyid(video_id);
    }

    @Override
    public void addANewComment(Comment comment) {
        commentMapper.addANewComment(comment);
    }

    @Override
    public String getparentguidancebyid(String video_id) {
        return videoMapper.getparentguidancebyid(video_id);
    }


}
