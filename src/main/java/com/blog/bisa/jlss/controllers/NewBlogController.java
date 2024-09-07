package com.blog.bisa.jlss.controllers;

import com.blog.bisa.jlss.models.Post;
import com.blog.bisa.jlss.models.UserBlog;
import com.blog.bisa.jlss.services.PostService;
import com.blog.bisa.jlss.services.UserBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class NewBlogController {
    @Autowired
    private PostService postService;

    @Autowired
    private UserBlogService userBlogService;

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

    @GetMapping("/posts/new")
    public String createNewPost(Model model) {

       Optional<UserBlog> optionalUserBlog = userBlogService.findByEmail("juan@gmail.com");
        if (optionalUserBlog.isPresent()) {
            Post post = new Post();
           post.setUserBlog(optionalUserBlog.get());
           model.addAttribute("post", post);
            return "blog_new";
        } else {
            return "error404";
        }
    }

    @PostMapping("/posts/new")
    public String saveNewPost(@ModelAttribute Post post){
        postService.save(post);
        return "redirect:/posts/" + post.getId();
    }
}
