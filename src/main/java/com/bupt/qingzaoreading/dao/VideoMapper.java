package com.bupt.qingzaoreading.dao;

import com.bupt.qingzaoreading.po.Video;
import com.bupt.qingzaoreading.util.MyMapper;
import com.bupt.qingzaoreading.vo.BookList;
import com.bupt.qingzaoreading.vo.BookRecommend;
import com.bupt.qingzaoreading.vo.LikeBookList;
import com.bupt.qingzaoreading.vo.YearLongForSearch;

import java.util.List;

public interface VideoMapper extends MyMapper<Video> {

    List<BookList> getBooklist();

    List<BookRecommend> getBookrecommend();

    List<BookList> getRecommendBooklist();

    List<BookList> getRecentBooklist();

    Video getBookById(String video_id);

    String getparentguidancebyid(String video_id);

    List<BookList> getBookListByType(String video_type);

    List<BookList> getBookListByYear(YearLongForSearch yearLongForSearch);

    List<BookList> getbooklistbyid(String lecturer_id);

    List<BookList> search(String video_name);

    List<LikeBookList> likebooklist(String video_id);
}