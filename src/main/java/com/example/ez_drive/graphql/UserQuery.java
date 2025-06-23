package com.example.ez_drive.graphql;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.example.ez_drive.dto.entities.User;
import com.example.ez_drive.dto.repositories.UserRepository;

@Controller
public class UserQuery {

    private final UserRepository userRepository;

    public UserQuery(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @QueryMapping()
    public List<User> users() {
        System.out.println(userRepository.findAll());
        return userRepository.findAll();
    }

    @QueryMapping()
    public User userById(@Argument Long id) {
        return userRepository.findById(id).orElse(null);
    }

}
