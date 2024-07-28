package com.rishit.blog.controller;


import com.rishit.blog.entity.Blog;
import com.rishit.blog.entity.User;
import com.rishit.blog.service.BlogService;
import com.rishit.blog.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private UserService userService;


    @PostMapping("/create-blog")
    public ResponseEntity<?> createblogs(@RequestBody Blog blog) {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user=userService.findUserByUsername(username);
        if(user==null){
            return new ResponseEntity<>("There is no valid user", HttpStatus.NOT_FOUND);
        }
       blogService.saveblog(blog,username);

        return new ResponseEntity<>("Blog saved", HttpStatus.CREATED);
    }



}
