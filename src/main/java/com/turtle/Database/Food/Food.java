package com.turtle.Database.Food;


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

public class Food {
    @Id
    private String ID;
    private String name;
    private Long caloried;
    private Long protein;
    private Long fat;
    private Long carbohydrate;


}
