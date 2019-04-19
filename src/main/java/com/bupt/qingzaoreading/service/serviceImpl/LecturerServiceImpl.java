package com.bupt.qingzaoreading.service.serviceImpl;


import com.bupt.qingzaoreading.dao.LecturerMapper;
import com.bupt.qingzaoreading.dao.VideoMapper;
import com.bupt.qingzaoreading.po.Lecturer;
import com.bupt.qingzaoreading.service.LecturerService;
import com.bupt.qingzaoreading.vo.BookList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("LecturerServiceImpl")
public class LecturerServiceImpl implements LecturerService {

    @Autowired
    private LecturerMapper lecturerMapper;

    @Autowired
    private VideoMapper videoMapper;


    @Override
    public Lecturer getlecturerbyid(String lecturer_id) {
        return lecturerMapper.getlecturerbyid(lecturer_id);
    }

    @Override
    public List<BookList> getbooklistbyid(String lecturer_id) {
        return videoMapper.getbooklistbyid(lecturer_id) ;
    }

    @Override
    public List<Lecturer> getalllecturer() {
        return lecturerMapper.selectAll();
    }
}
