package com.bupt.qingzaoreading.service.serviceImpl;

import com.bupt.qingzaoreading.dao.VideoMapper;
import com.bupt.qingzaoreading.service.SearchService;
import com.bupt.qingzaoreading.vo.BookList;
import com.bupt.qingzaoreading.vo.LikeBookList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("SearchServiceImpl")
public class SearchServiceImpl implements SearchService {

    @Autowired
    private VideoMapper videoMapper;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());



    @Override
    public List<BookList> search(String video_name) {
        return videoMapper.search(video_name);
    }

    @Override
    public List<LikeBookList> likebooklist(String video_id) {
        return videoMapper.likebooklist(video_id);
    }
}
