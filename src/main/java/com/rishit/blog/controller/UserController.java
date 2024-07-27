package com.rishit.blog.controller;

import com.rishit.blog.entity.User;
import com.rishit.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;



    @GetMapping("/get-details")
    public ResponseEntity<?> getDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username=authentication.getName();
        User user=userService.findUserByUsername(username);
        if(user==null){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(user);
    }



    @PutMapping("/changedetails")
    public ResponseEntity<?> updateDetails(@RequestBody User user) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username=authentication.getName();
        User user1=userService.findUserByUsername(username);
        if(user1==null){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        user1.setUsername(user.getUsername());
        user1.setPassword(user.getPassword());
        user1.setEmail(user.getEmail());
        user1.setName(user.getName());
        return new ResponseEntity<>(userService.createUser(user1),HttpStatus.OK);
    }

    @GetMapping("/getblogs")
    public ResponseEntity<?> getBlogs() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username=authentication.getName();
        User user=userService.findUserByUsername(username);
        if(user==null){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(user.getBlogs());
    }




}
