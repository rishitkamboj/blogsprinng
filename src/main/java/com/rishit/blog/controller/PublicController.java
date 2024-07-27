package com.rishit.blog.controller;


import com.rishit.blog.entity.Blog;
import com.rishit.blog.entity.User;
import com.rishit.blog.service.BlogService;
import com.rishit.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public")
@Component
public class PublicController {

    @Autowired
    BlogService blogService;

    @Autowired
    UserService userService;


    @GetMapping("/checkbackendup")
    public String checkBackendUp() {
        return "Backend Up";
    }


    @PostMapping("/create-user")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        User a=userService.findUserByUsername(user.getUsername());
        if(a!=null){
            return new ResponseEntity<>("User already exits!!",HttpStatus.BAD_REQUEST);
        }
        User u=userService.createUser(user);
        return new ResponseEntity<>(u, HttpStatus.CREATED);
    }
}
