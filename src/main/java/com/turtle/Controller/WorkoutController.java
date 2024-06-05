package com.turtle.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.turtle.Database.User.Users;
import com.turtle.Database.Workout.Workout;
import com.turtle.Service.WorkoutService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/workout")
public class WorkoutController {
    @Autowired
    private WorkoutService workoutService;

    @PostMapping("/create")
    public Mono<Workout> create(Workout workout){
        return workoutService.createWorkout(workout);
    }

    @GetMapping("/fetch")
    public Flux<Workout>fetch(Users user){
        return workoutService.getWorkout(user.getUserID());
    }

}
