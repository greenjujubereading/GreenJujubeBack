package com.bupt.qingzaoreading.controller;

import com.bupt.qingzaoreading.oss.FilePath;
import com.bupt.qingzaoreading.po.Comment;
import com.bupt.qingzaoreading.po.UserCollection;
import com.bupt.qingzaoreading.po.UserHistory;
import com.bupt.qingzaoreading.po.Video;
import com.bupt.qingzaoreading.service.BookContentService;
import com.bupt.qingzaoreading.vo.CommentCustom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BookContentController {


    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookContentService bookContentService;


    /**
     * 返回对应id图书的详细列表
     * 参数video_id,user_id
     *
     * @return
     */
    @RequestMapping(value = {"/bookbyid"}, method = {RequestMethod.POST, RequestMethod.GET})
    @CrossOrigin
    @ResponseBody
    public Video getBookById(String video_id, String user_id) {
        System.out.println("video_id" + video_id);
        UserHistory userhistory = new UserHistory();

        userhistory.setUserId(Long.parseLong(user_id));
        userhistory.setVideoId(Long.parseLong(video_id));

        logger.info("getUserHistoryByvideoiduserid()开始执行，参数：usee_id:"+user_id+"，video_id:"+video_id);

        UserHistory us = bookContentService.getUserHistoryByvideoiduserid(userhistory);
        logger.info("getUserHistoryByvideoiduserid()执行结束，结果：userhistory:"+userhistory);
        if (us == null) {
            bookContentService.addUserHistory(userhistory);
        } else {
            bookContentService.updataUserHistory(userhistory);
        }


        UserCollection usercollection = new UserCollection();
        usercollection.setUserId(Long.parseLong(user_id));
        usercollection.setVideoId(Long.parseLong(video_id));
        logger.info("getUserCollectionByvideoiduserid()开始执行，参数：user_id"+user_id+"，video_id:"+video_id);
        UserCollection uc = bookContentService.getUserCollectionByvideoiduserid(usercollection);
        logger.info("getUserCollectionByvideoiduserid()执行结束，结果：uc："+uc);

        if (uc == null) {

        } else {
            bookContentService.updataUserCollection(usercollection);
        }
        logger.info("getBookById开始执行：参数：video_id："+video_id);
        Video video = bookContentService.getBookById(video_id);
        logger.info("getBookById执行结束：结果：video："+video);
        video.setSoundUrl(FilePath.getUrl(video.getSoundUrl()));
        video.setVideoCoverUrl(FilePath.getUrl(video.getVideoCoverUrl()));
	    video.setVideoUrl(FilePath.getUrl(video.getVideoUrl()));
        return video;
    }

    /**
     * 根据video_id得到对应的评论
     */
    @RequestMapping(value = {"/getcommentbyid"}, method = {RequestMethod.POST, RequestMethod.GET})
    @CrossOrigin
    @ResponseBody
    public List<CommentCustom> getcommentbyid(String video_id) {
        logger.info("getcommentbyid方法开始执行（）参数：video_id"+video_id);

        List<CommentCustom> list = bookContentService.getcommentbyid(video_id);
        logger.info("getcommentbyid方法执行结束，结果：list"+list);
//		System.out.println(video_id);
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setUser_head_portrait_url(FilePath.getUrl(list.get(i).getUser_head_portrait_url()));
        }
        return list;
    }

    /**
     * 发表评论
     *
     * @param
     * @return
     */
    @RequestMapping(value = {"/commenttovideo"}, method = {RequestMethod.POST, RequestMethod.GET})
    @CrossOrigin
    @ResponseBody
    public Map<String, Object> commentToVideo(Comment comment) {
        System.out.println(comment);
        System.out.println("video id: " + comment.getVideoId());
        System.out.println("from user id: " + comment.getFromUserId());
        System.out.println("cotent: " + comment.getCotent());
        comment.setCommentDate( new Date());
        logger.info("addANewComment方法开始执行：video id"+comment.getVideoId()+"from user id"+comment.getFromUserId()+"cotent"+comment.getCotent());
        boolean result = true;
        try {
            bookContentService.addANewComment(comment);
        } catch (Exception e) {
            result = false;
        }
        logger.info("addANewComment方法结束执行，result"+result);
        Map map = new HashMap<String, Object>();
        map.put("result", result);

        return map;
    }


    /**
     * 根据video_id得到对应的家长导读
     */
    @RequestMapping("/getparentguidancebyid")
    @CrossOrigin
    @ResponseBody
    public Map<String, Object> getparentguidancebyid(String video_id) {
        Map map = new HashMap<String, Object>();
        logger.info("getparentguidancebyid方法开始执行，参数video_id"+video_id);
        String result = bookContentService.getparentguidancebyid(video_id);
        logger.info("\"getparentguidancebyid方法结束执行，结果result"+result);
        map.put("parent_guidance", result);
        return map;
    }
}
