package com.bupt.qingzaoreading.controller;

import com.bupt.qingzaoreading.oss.FilePath;
import com.bupt.qingzaoreading.po.Playing;
import com.bupt.qingzaoreading.service.HomePageService;
import com.bupt.qingzaoreading.vo.BookList;
import com.bupt.qingzaoreading.vo.BookRecommend;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HomePageController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private HomePageService homePageService;

    /**
     * 返回首页的轮播图
     *
     * @return playing
     */
    @RequestMapping("/carousel")
    @ResponseBody
    public List<Playing> getCarousel() {
        logger.info("getCarousel开始执行");
        List<Playing> list = homePageService.getCarousel();
        logger.info("getCarousel结束执行，结果：list"+list);
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setPictureUrl(FilePath.getUrl(list.get(i).getPictureUrl()));
        }
        return list;
    }


    /**
     * 返回首页的图书列表
     *
     * @return
     */
    @RequestMapping("/booklist")
    @CrossOrigin
    @ResponseBody
    public List<BookList> getBooklist() {
        logger.info("getBooklist开始执行");
        List<BookList> list = homePageService.getBooklist();
        logger.info("getBooklist结束执行，结果：list"+list);

        for (int i = 0; i < list.size(); i++) {
            list.get(i).setVideo_cover_url(FilePath.getUrl(list.get(i).getVideo_cover_url()));
        }
        return list;

    }

    /**
     * 返回首页的图书推荐列表 只返回4个
     *
     * @return
     */
    @RequestMapping("/bookrecommend")
    @CrossOrigin
    @ResponseBody
    public List<BookRecommend> getBookrecommend() {
        logger.info("getBookrecommend开始执行");
        List<BookRecommend> list = homePageService.getBookrecommend();
        logger.info("getBookrecommend结束执行，结果：list"+list);

        for (int i = 0; i < list.size(); i++) {
            list.get(i).setVideo_cover_url(FilePath.getUrl(list.get(i).getVideo_cover_url()));
        }
        return list;

    }

    /**
     * 返回首页更多的图书推荐列表 默认返回全部推荐的书籍
     *
     * @return
     */
    @RequestMapping("/bookrecommendmore")
    @CrossOrigin
    @ResponseBody
    public List<BookList> getMoreBookRecommend() {
        logger.info("getMoreBookRecommend开始执行");
        List<BookList> list = homePageService.getRecommendBooklist();
        logger.info("getMoreBookRecommend结束执行，结果：list"+list);


        for (int i = 0; i < list.size(); i++) {
            list.get(i).setVideo_cover_url(FilePath.getUrl(list.get(i).getVideo_cover_url()));
        }
        return list;

    }

    /**
     * 返回首页更多的最新图书 默认返回全部推荐的书籍
     *
     * @return
     */
    @RequestMapping("/bookrecentmore")
    @CrossOrigin
    @ResponseBody
    public List<BookList> getMoreBookRecent() {
        logger.info("getMoreBookRecent开始执行");
        List<BookList> list = homePageService.getRecentBooklist();
        logger.info("getMoreBookRecent(结束执行，结果：list"+list);


        for (int i = 0; i < list.size(); i++) {
            list.get(i).setVideo_cover_url(FilePath.getUrl(list.get(i).getVideo_cover_url()));
        }
        return list;

    }
}
