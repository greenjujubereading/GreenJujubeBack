package com.bupt.qingzaoreading.controller;

import com.bupt.qingzaoreading.oss.FilePath;
import com.bupt.qingzaoreading.service.BookTypeService;
import com.bupt.qingzaoreading.vo.BookList;
import com.bupt.qingzaoreading.vo.YearLongForSearch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BookTypeController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookTypeService bookTypeService;

    /**
     * 返回对应图书类型的列表
     * 参数video_type
     * 0标识亲近文学；1益智科普
     *
     * @return
     */
    @RequestMapping("/booklistbytype")
    @CrossOrigin
    @ResponseBody
    public List<BookList> getBookListByType(String video_type) {
        logger.info("getBookListByType方法开始执行，参数video_type"+video_type);
        List<BookList> list = bookTypeService.getBookListByType(video_type);
        logger.info("getBookListByType方法结束执行，结果list"+list);
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setVideo_cover_url(FilePath.getUrl(list.get(i).getVideo_cover_url()));
        }
        return list;

    }


    /**
     * 返回对应学生年级的列表
     * 参数String video_year
     * 0-3
     *
     * @return
     */
    @RequestMapping("/booklistbyyear")
    @CrossOrigin
    @ResponseBody
    public List<BookList> getBookListByYear(String video_year) {
        String[] videoYearArray = video_year.split("-");
        logger.info("getBookListByYear方法开始执行，参数video_year"+video_year);
        YearLongForSearch yearLongForSearch=new YearLongForSearch();

        if(Integer.parseInt(videoYearArray[0])<Integer.parseInt(videoYearArray[1])){
            yearLongForSearch.setMin(videoYearArray[0]);
            yearLongForSearch.setMax(videoYearArray[1]);
        }
        else{
            yearLongForSearch.setMin(videoYearArray[1]);
            yearLongForSearch.setMax(videoYearArray[0]);
        }
        List<BookList> booklist = bookTypeService.getBookListByYear(yearLongForSearch);
        logger.info("getBookListByYear方法结束执行，结果booklist"+booklist);
//        List<BookList> list = homePageService.getBookListByYear(video_type);
        for (int i = 0; i < booklist.size(); i++) {
            booklist.get(i).setVideo_cover_url(FilePath.getUrl(booklist.get(i).getVideo_cover_url()));
        }
        return booklist;

    }

}
