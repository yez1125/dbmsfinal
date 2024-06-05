package com.turtle.Turtle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication(scanBasePackages = "com.turtle")
@EnableReactiveMongoRepositories(basePackages = "com.turtle")
@EnableCaching
@Slf4j
public class TurtleApplication {
  
	public static void main(String[] args) {
		SpringApplication.run(TurtleApplication.class, args);
    log.info(
      "\n----------------------------------------------------------------------\n\t" + 
      "Application '{}' is running!\n" + 
      "----------------------------------------------------------------------",
      TurtleApplication.class.getSimpleName()
    );
	}
}
