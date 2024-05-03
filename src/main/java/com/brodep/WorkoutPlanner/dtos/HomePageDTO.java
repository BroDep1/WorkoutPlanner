package com.brodep.WorkoutPlanner.dtos;

import com.brodep.WorkoutPlanner.entities.User;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@JsonSerialize
@Getter
@Setter
public class HomePageDTO {
    private Long id;

    private String name;

    private int height;

    private int weight;

    private int age;

    public HomePageDTO(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.height = user.getHeight();
        this.weight = user.getWeight();
        this.age = user.getAge();
    }
}
