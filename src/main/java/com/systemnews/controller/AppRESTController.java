package com.systemnews.controller;

import com.systemnews.model.Comment;
import com.systemnews.model.News;
import com.systemnews.service.CommentService;
import com.systemnews.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping(method = RequestMethod.GET, value = "/getComments")
    public @ResponseBody List<Comment> findAllComment(){
        return commentService.getObj();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/saveNews")
    public @ResponseBody  Map<String, Object> create(@Valid @RequestBody News newsEntity, BindingResult bindingResult) {

        Map<String, Object> response = new LinkedHashMap<>();

        if(bindingResult.hasErrors())
        {
            List<FieldError> errors = bindingResult.getFieldErrors();
            response.put("message", "Error");

            for(FieldError error: errors)
            {
                response.put(error.getField(), error.getDefaultMessage());
            }

        }
        else
        {
            newsService.create(newsEntity);
            response.put("message", "News created successfully");
        }

        return response;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/saveComment")
    public @ResponseBody Comment create (@RequestBody Comment commentEntity) {
        return commentService.create(commentEntity);
    }


}
