package com.bupt.qingzaoreading.controller;

import com.bupt.qingzaoreading.oss.FilePath;
import com.bupt.qingzaoreading.po.Lecturer;
import com.bupt.qingzaoreading.service.LecturerService;
import com.bupt.qingzaoreading.vo.BookList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class LecturerController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LecturerService lecturerService;

    /**
     * 根据lecturer_id得到对应的讲师介绍
     */
    @RequestMapping("/getlecturerbyid")
    @CrossOrigin
    @ResponseBody
    public Lecturer getlecturerbyid(String lecturer_id) {
        logger.info("getlecturerbyid方法开始执行，参数lecturer_id"+lecturer_id);
        Lecturer lecturer = lecturerService.getlecturerbyid(lecturer_id);
        logger.info("getlecturerbyid方法结束执行，结果lecturer"+lecturer);
        lecturer.setLecturerHeadPortraitUrl(FilePath.getUrl(lecturer.getLecturerHeadPortraitUrl()));
        return lecturer;
    }

    /**
     * 根据lecturer_id得到此讲师讲的图书列表
     */
    @RequestMapping("/getbooklistbyid")
    @CrossOrigin
    @ResponseBody
    public List<BookList> getbooklistbyid(String lecturer_id) {
        logger.info("getbooklistbyid方法开始执行，参数lecturer_id"+lecturer_id);
        List<BookList> list = lecturerService.getbooklistbyid(lecturer_id);
        logger.info("getbooklistbyid方法结束执行，结果list"+list);

        for (int i = 0; i < list.size(); i++) {
            list.get(i).setVideo_cover_url(FilePath.getUrl(list.get(i).getVideo_cover_url()));
        }
        return list;

    }

    /**
     * 根据讲师列表
     */
    @RequestMapping("/getalllecturer")
    @ResponseBody
    public List<Lecturer> getalllecturer() {
        logger.info("getalllecturer方法开始执行");
        List<Lecturer> list = lecturerService.getalllecturer();
        logger.info("getalllecturer方法结束执行，结果list"+list);


        for (int i = 0; i < list.size(); i++) {
            list.get(i).setLecturerHeadPortraitUrl(FilePath.getUrl(list.get(i).getLecturerHeadPortraitUrl()));
        }
        return list;

    }

}
