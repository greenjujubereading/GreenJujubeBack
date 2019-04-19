package com.bupt.qingzaoreading.service;

import com.bupt.qingzaoreading.vo.BookList;
import com.bupt.qingzaoreading.vo.LikeBookList;

import java.util.List;

public interface SearchService {
    List<BookList> search(String video_name);

    List<LikeBookList> likebooklist(String video_id);
}
