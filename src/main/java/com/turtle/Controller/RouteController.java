package com.turtle.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.result.view.Rendering;

import reactor.core.publisher.Mono;

@Controller
public class RouteController {
    @GetMapping("/login")
    public Mono<Rendering> login() {
        return Mono.just(Rendering.view("login").build());
    }

    @GetMapping("/home")
    public Mono<Rendering> home() {
        return Mono.just(Rendering.view("database").build());
    }

    @GetMapping("/community")
    public Mono<Rendering> community() {
        return Mono.just(Rendering.view("community").build());
    }

    @GetMapping("/register")
    public Mono<Rendering> register() {
        return Mono.just(Rendering.view("register").build());
    }


    @GetMapping("/input")
    public Mono<Rendering> input() {
        return Mono.just(Rendering.view("food_exercise").build());
    }

    @GetMapping("/profile")
    public Mono<Rendering> profile() {
        return Mono.just(Rendering.view("profile").build());
    }

    @GetMapping("/rank")
    public Mono<Rendering> rank() {
        return Mono.just(Rendering.view("rank").build());
    }

    @GetMapping("/post")
    public Mono<Rendering> post() {
        return Mono.just(Rendering.view("post").build());
    }

    @GetMapping("/forgot-password")
    public Mono<Rendering> forgotpassword() {
        return Mono.just(Rendering.view("forgot-password").build());
    }
} 
    

