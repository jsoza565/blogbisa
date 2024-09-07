package com.blog.bisa.jlss.services;

import com.blog.bisa.jlss.models.UserBlog;
import com.blog.bisa.jlss.repositories.UserBlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserBlogService {
    @Autowired
    private UserBlogRepository userBlogRepository;

    public UserBlog save(UserBlog userBlog){
        if (userBlog.getId() == null) {
            userBlog.setCreatedAt(LocalDateTime.now());
        }
        return userBlogRepository.save(userBlog);
    }
}
