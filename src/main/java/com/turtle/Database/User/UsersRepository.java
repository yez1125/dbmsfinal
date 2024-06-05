package com.turtle.Database.User;


import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Mono;

@Repository
public interface UsersRepository extends ReactiveMongoRepository<Users, String> {
    Mono<Users> findByEmail(String email);
}
