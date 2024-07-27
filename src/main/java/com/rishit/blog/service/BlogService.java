package com.rishit.blog.service;

import com.rishit.blog.entity.Blog;
import com.rishit.blog.entity.User;
import com.rishit.blog.repository.BlogRepo;
import com.rishit.blog.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;


@Component
public class BlogService {

    @Autowired
    BlogRepo blogrepo;

    @Autowired
    UserRepo userrepo;



    public List<Blog> findAll() {
        return blogrepo.findAll();
    }


    public void saveblog(Blog blog,String username) {
        try{
        LocalDateTime d=LocalDateTime.now();
        blog.setDate(d);
        blog.setDone(false);
        User u=userrepo.findByUsername(username);
            blogrepo.save(blog);
        u.getBlogs().add(blog);
        userrepo.save(u);
       }
        catch(Exception e){
            e.printStackTrace();
        }
    }


}
