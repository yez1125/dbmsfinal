package com.turtle.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turtle.Database.Exercise.Exercise;
import com.turtle.Database.Exercise.ExerciseRepository;

import reactor.core.publisher.Mono;

@Service
public class ExerciseService {
    @Autowired
    private ExerciseRepository exerciseRepository;

    public Mono<Exercise> getExercise(String name) {
        return exerciseRepository.findByName(name);
    }

    public Mono<Exercise> saveExercise(Exercise exercise){
        return exerciseRepository.save(exercise);
    }

}
