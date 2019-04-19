package com.bupt.qingzaoreading.service;

import com.bupt.qingzaoreading.vo.BookList;
import com.bupt.qingzaoreading.vo.YearLongForSearch;

import java.util.List;

public interface BookTypeService {

    List<BookList> getBookListByType(String video_type);

    List<BookList> getBookListByYear(YearLongForSearch yearLongForSearch);
}
