package com.turtle.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.turtle.Database.Goal.Goal;
import com.turtle.Database.User.Users;
import com.turtle.Service.GoalService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/goal")
public class GoalController {
    @Autowired
    private GoalService goalService;

    @PostMapping("/create")
    public Mono<Goal> set(Goal goal){
        return goalService.saveGoal(goal);
    }

    @GetMapping("/get")
    public Mono<Goal> get(Users user){
        return goalService.getGoal(user.getUserID());
    }

    @PostMapping("/update")
    public Mono<Goal>update(Goal goal){
        return goalService.getGoalByUser(goal.getUserID()).flatMap(_goal -> {
            goalService.delete(_goal.getGoalID());
            goalService.saveGoal(goal);
            return Mono.just(goal);
        }).switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "goal not exist")))
        .cast(Goal.class);
    }
}
