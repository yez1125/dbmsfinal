package com.turtle.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turtle.Database.User.UsersRepository;
import com.turtle.Database.User.Users;

import reactor.core.publisher.Mono;

@Service
public class UserService {

  @Autowired
  private UsersRepository userRepository;


  /*
   * Get user by id, empty if not found
   */
  public Mono<Users> getUserById(String userId) {
    return userRepository.findById(userId);
  }

  /*
   * Get user by email, empty if not found
   */
  public Mono<Users> getUserByEmail(String email) {
    return userRepository.findByEmail(email);
  }


  public Mono<Users> saveUser(Users user) {
    return userRepository.save(user);
  }

  
}
