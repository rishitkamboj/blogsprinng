package com.rishit.blog.service;

import com.rishit.blog.entity.Blog;
import com.rishit.blog.entity.User;
import com.rishit.blog.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
public class UserService {


    @Autowired
    UserRepo userrepo;

    private final BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();


    public User createUser(User user) {
        user.setPassword(bcrypt.encode(user.getPassword()));
        user.setRoles(List.of("USER"));
        user.setBlogs(new ArrayList<>());
        return userrepo.save(user);
    }

    public User saveUser(User user) {
              return userrepo.save(user);
    }

    public User findUserByUsername(String username) {
        return userrepo.findByUsername(username);
    }

    public List<User> findAllUsers() {
        return userrepo.findAll();
    }
    public User saveAdmin(User user){
        User u=findUserByUsername(user.getUsername());
        if(u==null){
        user.setPassword(bcrypt.encode(user.getPassword()));
        user.setRoles(List.of("ADMIN","USER"));
        return userrepo.save(user);}
        u.setRoles(List.of("ADMIN","USER"));
        userrepo.save(u);
        return u;
    }






}
