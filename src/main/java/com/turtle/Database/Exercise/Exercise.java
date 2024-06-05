package com.turtle.Database.Exercise;


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

public class Exercise {
    @Id
    private String exerciseID;
    private String name;
    private String type;
    private int cal;
}

