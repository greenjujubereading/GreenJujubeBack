package com.bupt.qingzaoreading.controller;

import com.bupt.qingzaoreading.oss.FilePath;
import com.bupt.qingzaoreading.po.UserCollection;
import com.bupt.qingzaoreading.service.BookShelfService;
import com.bupt.qingzaoreading.vo.BookList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BookShelfController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookShelfService bookShelfService;

    /**
     * 收藏
     */
    @RequestMapping(value = {"/collecte"}, method = {RequestMethod.POST, RequestMethod.GET})
    @CrossOrigin
    @ResponseBody
    public Map<String, Object> collecte(UserCollection uc) {
        System.out.println(uc);
        //检查是否已经收藏，用于检验是收藏还是取消收藏
        logger.info("getUserCollectionByid方法执行，参数uc"+uc);
        UserCollection usercollection = bookShelfService.getUserCollectionByid(uc);
        logger.info("getUserCollectionByid方法执行结束，结果uc"+usercollection);
        Map map = new HashMap<String, Object>();
        if (usercollection == null) {
            bookShelfService.collecte(uc);
            map.put("result", true);
        } else {
            bookShelfService.deleteCollecte(uc);
            map.put("result", false);
        }

        return map;
    }


    /**
     * 得到收藏列表
     */
    @RequestMapping(value = {"/getcollection"}, method = {RequestMethod.POST, RequestMethod.GET})
    @CrossOrigin
    @ResponseBody
    public List<BookList> getcollection(String user_id) {
        logger.info("getcollection方法开始执行，参数：user_id"+user_id);
        List<BookList> booklists  = bookShelfService.getcollection(user_id);
        logger.info("getcollection方法开始执行，结果："+booklists);
        for (int i = 0; i < booklists.size(); i++) {

            booklists.get(i).setVideo_cover_url(FilePath.getUrl(booklists.get(i).getVideo_cover_url()));

        }

        return booklists;
    }

    /**
     * 得到历史列表
     */
    @RequestMapping(value = {"/gethistory"}, method = {RequestMethod.POST, RequestMethod.GET})
    @CrossOrigin
    @ResponseBody
    public List<BookList> gethistory(String user_id) {
        logger.info("gethistory方法开始执行，参数user_id"+user_id);
        List<BookList> booklists= bookShelfService.gethistory(user_id);
        logger.info("gethistory方法执行结束，结果booklists"+booklists);
        for (int i = 0; i < booklists.size(); i++) {

            booklists.get(i).setVideo_cover_url(FilePath.getUrl(booklists.get(i).getVideo_cover_url()));

        }

        return booklists;
    }
}
