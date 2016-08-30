package com.systemnews.controller;

import com.systemnews.model.News;
import com.systemnews.service.CommentService;
import com.systemnews.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by RADEK on 2016-08-30.
 */
@RestController
@RequestMapping("/api/news")
public class AppRESTController {

        private final CommentService commentService;
        private final NewsService newsService;

    @Autowired
    public AppRESTController(CommentService commentService, NewsService newsService) {
        this.commentService = commentService;
        this.newsService = newsService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getNews")
    public @ResponseBody List<News> findAll() {
        return newsService.getObj();
    }
}
