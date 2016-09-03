package com.systemnews;

import com.systemnews.model.Comment;
import com.systemnews.model.News;
import com.systemnews.service.CommentService;
import com.systemnews.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan
public class SystemNewsApplication implements CommandLineRunner {

	@Autowired
	public NewsService newsService;

	@Autowired
	public CommentService commentService;

	public static void main(String[] args) {
		SpringApplication.run(SystemNewsApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {

		News obj = new News("13.23.2016",  "Tytul", "tresc", "aaaaa");

		newsService.create(obj);

		Comment commObj = new Comment("23", "Tresc", "Autor", "12.44.2019");
		commentService.create(commObj);

	}
}
