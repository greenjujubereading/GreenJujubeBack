package com.bupt.qingzaoreading.service;

import com.bupt.qingzaoreading.po.UserCollection;
import com.bupt.qingzaoreading.vo.BookList;

import java.util.List;

public interface BookShelfService {

    UserCollection  getUserCollectionByid(UserCollection uc);

    void collecte(UserCollection userCollection);

    void deleteCollecte(UserCollection userCollection);

    List<BookList> getcollection(String user_id);

    List<BookList> gethistory(String user_id);
}
