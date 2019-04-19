package com.bupt.qingzaoreading.dao;

import com.bupt.qingzaoreading.po.UserHistory;
import com.bupt.qingzaoreading.util.MyMapper;
import com.bupt.qingzaoreading.vo.BookList;

import java.util.List;

public interface UserHistoryMapper extends MyMapper<UserHistory> {

    UserHistory getUserHistoryByvideoiduserid(UserHistory userhistory);

    void  addUserHistory(UserHistory userhistory);

    void updataUserHistory(UserHistory userhistory);

    List<BookList> gethistory(String user_id);
}