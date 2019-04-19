package com.bupt.qingzaoreading.dao;

import com.bupt.qingzaoreading.po.UserCollection;
import com.bupt.qingzaoreading.util.MyMapper;
import com.bupt.qingzaoreading.vo.BookList;

import java.util.List;

public interface UserCollectionMapper extends MyMapper<UserCollection> {

    UserCollection getUserCollectionByvideoiduserid(UserCollection usercollection);

    void updataUserCollection(UserCollection usercollection);

    UserCollection getUserCollectionByid(UserCollection uc);

    void addCollection(UserCollection uc);

    void deleteByUserAndVideo(UserCollection uc);


    List<BookList> getcollection(String user_id);
}