package com.blog.bisa.jlss.controllers;

import com.blog.bisa.jlss.models.Post;
import com.blog.bisa.jlss.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class NewBlogController {
    @Autowired
    private PostService postService;

    @GetMapping("/posts/{id}") public String getPost(@PathVariable Long id, Model model) {

        // find post by id
        Optional<Post> optionalPost = this.postService.getById(id);

        // if post exists put it in model
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            model.addAttribute("post", post);
            return "newblog";
        } else {
            return "error404";
        }
    }
}
