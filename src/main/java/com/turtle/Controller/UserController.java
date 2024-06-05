package com.turtle.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.turtle.Database.User.Users;
import com.turtle.Service.UserService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Mono<Users> register(Users user) {
        
        return userService.getUserByEmail(user.getEmail()).flatMap(_user -> {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User already exist");
        })
        .switchIfEmpty(userService.saveUser(user))
        .cast(Users.class);
    }
    
    @PostMapping("/login")
    public Mono<Users> login(Users user){
        return userService.getUserByEmail(user.getEmail()).flatMap(_user -> {
            if (!user.getPassword().equals(_user.getPassword()) ) {
                log.info(user.getPassword());
                log.info(_user.getPassword());
                return Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "Password error")) ;     
            }
            System.out.println(user);
            return Mono.just(user);
        }).switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found"))); 
    }

    @GetMapping("/fetch")
    public Mono<Users> fetch(Users user){
        log.info(user.getEmail());
        return userService.getUserByEmail(user.getEmail());
    }
    


}
