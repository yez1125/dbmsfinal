package com.turtle.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turtle.Database.Food.Food;
import com.turtle.Database.Food.FoodRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class FoodService {
    @Autowired
    private FoodRepository foodRepository;

    public Flux<Food> getFood() {
        return foodRepository.findAll();
    }

    public Flux<Food> getFoodByName(String name) {
        return foodRepository.findByName(name);
    }

    public Mono<Food> saveFood(Food food) {
        return foodRepository.save(food);
    }

}
