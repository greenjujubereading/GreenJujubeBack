package com.bupt.qingzaoreading.service;

import com.bupt.qingzaoreading.po.Lecturer;
import com.bupt.qingzaoreading.vo.BookList;

import java.util.List;

public interface LecturerService {
    Lecturer getlecturerbyid(String lecturer_id);

    List<BookList> getbooklistbyid(String lecturer_id);

    List<Lecturer> getalllecturer();
}
