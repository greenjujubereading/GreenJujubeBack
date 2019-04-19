package com.bupt.qingzaoreading.dao;

import com.bupt.qingzaoreading.po.Lecturer;
import com.bupt.qingzaoreading.util.MyMapper;

public interface LecturerMapper extends MyMapper<Lecturer> {
    Lecturer getlecturerbyid(String lecturer_id);


}