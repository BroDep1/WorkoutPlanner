package com.brodep.WorkoutPlanner.controllers;

import com.brodep.WorkoutPlanner.dtos.HomePageDTO;
import com.brodep.WorkoutPlanner.dtos.LoginDTO;
import com.brodep.WorkoutPlanner.entities.User;
import com.brodep.WorkoutPlanner.repos.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class AuthController {
    UserRepo userRepo;

    @PostMapping("/register")
    HomePageDTO register(@RequestBody User user){
        user.setPassword(String.valueOf(user.getPassword().hashCode()));
        userRepo.save(user);
        return new HomePageDTO(user);
    }

    @PostMapping("/login")
    HomePageDTO login(@RequestBody LoginDTO loginDTO){
        for (User user : userRepo.findAllByName(loginDTO.getName())) {
            if (String.valueOf(loginDTO.getPassword().hashCode()).equals(user.getPassword()))
                return new HomePageDTO(user);
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "User with such password not found"
        );
    }
}
