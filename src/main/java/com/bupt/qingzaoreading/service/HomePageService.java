package com.bupt.qingzaoreading.service;

import com.bupt.qingzaoreading.po.Playing;
import com.bupt.qingzaoreading.vo.BookList;
import com.bupt.qingzaoreading.vo.BookRecommend;

import java.util.List;

public interface HomePageService {
    List<Playing> getCarousel();

    List<BookList> getBooklist();

    List<BookRecommend> getBookrecommend();

    List<BookList> getRecommendBooklist();

    List<BookList> getRecentBooklist();
}
