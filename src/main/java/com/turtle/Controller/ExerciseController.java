package com.turtle.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.turtle.Database.Exercise.Exercise;
import com.turtle.Service.ExerciseService;

import reactor.core.publisher.Mono;
@RestController
@RequestMapping("/exercise")
public class ExerciseController {
    @Autowired
    private ExerciseService exerciseService;

    @PostMapping("/create")
    public Mono<Exercise>create(Exercise exercise){
        return exerciseService.saveExercise(exercise);
    }

    @GetMapping("/getByName")
    public Mono<Exercise>getByName(Exercise exercise){
        return exerciseService.getExercise(exercise.getName()).switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "No data")));
    }
}
