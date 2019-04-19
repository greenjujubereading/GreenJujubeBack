package com.bupt.qingzaoreading.controller;

import com.bupt.qingzaoreading.oss.FilePath;
import com.bupt.qingzaoreading.service.SearchService;
import com.bupt.qingzaoreading.vo.BookList;
import com.bupt.qingzaoreading.vo.LikeBookList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SearchController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SearchService searchService;

    /**
     * 搜索对应的图书列表
     * 返回图书名字、讲师名字包含关键字的图书列表
     * 参数video_name
     *
     * @return
     */
    @RequestMapping(value = {"/search"}, method = {RequestMethod.POST, RequestMethod.GET})
    @CrossOrigin
    @ResponseBody
    public List<BookList> search(String video_name) {
        logger.info("search方法开始执行，参数video_name"+video_name);
        List<BookList> list = searchService.search(video_name);
        logger.info("search方法结束执行，结果list"+list);
        logger.info("");
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setVideo_cover_url(FilePath.getUrl(list.get(i).getVideo_cover_url()));
        }
        return list;

    }

    /**
     * 根据video_id得到类似的viedo
     */
    @RequestMapping("/likebooklist")
    @CrossOrigin
    @ResponseBody
    public List<LikeBookList> likebooklist(String video_id) {
        logger.info("likebooklist方法开始执行，参数video_id"+video_id);
        List<LikeBookList> list = searchService.likebooklist(video_id);
        logger.info("likebooklist方法结束执行，结果list"+list);

        for (int i = 0; i < list.size(); i++) {
            list.get(i).setVideo_cover_url(FilePath.getUrl(list.get(i).getVideo_cover_url()));
        }
        return list;
    }
}
