package com.rishit.blog.service;


import com.rishit.blog.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminService {

     @Autowired
    UserService userService;



     @GetMapping("/all-users")
    public ResponseEntity<?> getAllUsers() {
         return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.ACCEPTED);
     }

     @PostMapping("/make-admin/")
    public ResponseEntity<?> makeAdmin(@RequestBody User user) {
       return new ResponseEntity<>(userService.saveAdmin(user), HttpStatus.CREATED);
     }








}
