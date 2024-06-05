package com.turtle.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turtle.Database.Comment.Comment;
import com.turtle.Database.Comment.CommentRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CommentService {
    @Autowired
    private  CommentRepository commentRepository;

    public  Mono<Comment> createComment(Comment comment){
        return commentRepository.save(comment);
    }

    public Flux<Comment> getByArticle(String articleID){
        return commentRepository.findCommentByArticleID(articleID);
    }


    
}
