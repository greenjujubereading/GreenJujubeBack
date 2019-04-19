package com.bupt.qingzaoreading.service.serviceImpl;


import com.bupt.qingzaoreading.dao.UserCollectionMapper;
import com.bupt.qingzaoreading.dao.UserHistoryMapper;
import com.bupt.qingzaoreading.po.UserCollection;
import com.bupt.qingzaoreading.service.BookShelfService;
import com.bupt.qingzaoreading.vo.BookList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("BookShelfServiceImpl")
public class BookShelfServiceImpl implements BookShelfService {

    @Autowired
    private UserCollectionMapper userCollectionMapper;

    @Autowired
    private UserHistoryMapper userHistoryMapper;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Override
    public UserCollection getUserCollectionByid(UserCollection uc) {
        return userCollectionMapper.getUserCollectionByid(uc);
    }

    @Override
    public void collecte(UserCollection userCollection) {
        userCollectionMapper.addCollection(userCollection);
    }

    @Override
    public void deleteCollecte(UserCollection userCollection) {
        userCollectionMapper.deleteByUserAndVideo(userCollection);
    }

    @Override
    public List<BookList> getcollection(String user_id) {
        return userCollectionMapper.getcollection(user_id);
    }

    @Override
    public List<BookList> gethistory(String user_id) {
        return userHistoryMapper.gethistory(user_id);
    }
}
