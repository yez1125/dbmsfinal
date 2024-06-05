package com.turtle.Database.User;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Users {
  @Id 
  private String userID;
  private String email;
  private float height;
  private float weight;
  private String name;
  private String password;
  private String birthday;
  private String gender;

}
