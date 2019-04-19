package com.bupt.qingzaoreading.service.serviceImpl;

import com.bupt.qingzaoreading.dao.PlayingMapper;
import com.bupt.qingzaoreading.dao.VideoMapper;
import com.bupt.qingzaoreading.po.Playing;
import com.bupt.qingzaoreading.service.HomePageService;
import com.bupt.qingzaoreading.vo.BookList;
import com.bupt.qingzaoreading.vo.BookRecommend;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("HomePageServiceImpl")
public class HomePageServiceImpl implements HomePageService {

    @Autowired
    private PlayingMapper playingMapper;

    @Autowired
    private VideoMapper videoMapper;


    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public List<Playing> getCarousel() {
        return playingMapper.getCarousel();
    }

    @Override
    public List<BookList> getBooklist() {

        return videoMapper.getBooklist();
    }

    @Override
    public List<BookRecommend> getBookrecommend() {
        return videoMapper.getBookrecommend();
    }

    @Override
    public List<BookList> getRecommendBooklist() {
        return videoMapper.getRecommendBooklist();
    }

    @Override
    public List<BookList> getRecentBooklist() {
        return videoMapper.getRecentBooklist();
    }
}
