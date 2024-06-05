package com.turtle.Database.Workout;


import java.util.Date;

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
public class Workout {
    @Id
    private String ID;
    private String exerciseID;
    private String userID;
    private int time;
    private int cal;
    private Date date;
    
   
}
