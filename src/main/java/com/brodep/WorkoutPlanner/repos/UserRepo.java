package com.brodep.WorkoutPlanner.repos;

import com.brodep.WorkoutPlanner.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {
    List<User> findAllByName(String name);
}
