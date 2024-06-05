package com.turtle.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turtle.Database.Goal.Goal;
import com.turtle.Database.Goal.GoalRepository;

import reactor.core.publisher.Mono;
@Service
public class GoalService {
    @Autowired
    private GoalRepository goalRepository;

    public Mono<Goal> saveGoal(Goal goal){
        return goalRepository.save(goal);
    }

    public Mono<Goal> getGoal(String ID){
        return goalRepository.findById(ID);
    }

    public Mono<Goal>getGoalByUser(String user){
        return goalRepository.findGoalByUserID(user);
    }

    public void delete(String goal){
        goalRepository.deleteById(goal);
    }


}
