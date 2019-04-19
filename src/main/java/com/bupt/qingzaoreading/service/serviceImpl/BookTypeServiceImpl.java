package com.bupt.qingzaoreading.service.serviceImpl;

import com.bupt.qingzaoreading.dao.VideoMapper;
import com.bupt.qingzaoreading.service.BookTypeService;
import com.bupt.qingzaoreading.vo.BookList;
import com.bupt.qingzaoreading.vo.YearLongForSearch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("BookTypeServiceImpl")
public class BookTypeServiceImpl implements BookTypeService {


    @Autowired
    private VideoMapper videoMapper;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());



    @Override
    public List<BookList> getBookListByType(String video_type) {
        return videoMapper.getBookListByType(video_type);
    }

    @Override
    public List<BookList> getBookListByYear(YearLongForSearch yearLongForSearch) {
        return videoMapper.getBookListByYear(yearLongForSearch);
    }
}
