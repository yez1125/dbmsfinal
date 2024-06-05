package com.turtle.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turtle.Database.Article.Article;
import com.turtle.Database.Article.ArticleRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public Flux<Article> getArticles(){
        return articleRepository.findAll();
    }

    public Mono<Article> saveArticle(Article article) {
        return articleRepository.save(article);
    }

}
