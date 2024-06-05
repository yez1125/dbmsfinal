package com.turtle.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turtle.Database.Article.Article;
import com.turtle.Service.ArticleService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @PostMapping("/create")
    public Mono<Article> create(Article article){
        return articleService.saveArticle(article);
    }

    @GetMapping("/get")
    public Flux<Article>get(){
        return articleService.getArticles();
    }
}
