package com.turtle.Database.Goal;


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
public class Goal {
    @Id
    private String goalID;

    private String type;

    private int quantity;

    private Date startTime;

    private int expectDays;

    private String userID;

    
}
