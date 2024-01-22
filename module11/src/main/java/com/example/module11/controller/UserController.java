package com.example.module11.controller;

import com.example.module11.entity.SberUser;
import com.example.module11.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public SberUser createUser(@RequestBody SberUser sberUser){
        return userService.createUser(sberUser);
    }

    @GetMapping("/people")
    public List<SberUser> getPeople(){
        return userService.getUsers();
    }

    @PutMapping("/user/{id}")
    public SberUser updateUser(@RequestBody SberUser sberUser, @PathVariable Long id){
        return userService.updateUser(sberUser, id);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

}
