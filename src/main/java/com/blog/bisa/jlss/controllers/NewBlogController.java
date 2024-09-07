package com.blog.bisa.jlss.controllers;

import com.blog.bisa.jlss.models.Post;
import com.blog.bisa.jlss.models.UserBlog;
import com.blog.bisa.jlss.services.PostService;
import com.blog.bisa.jlss.services.UserBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String createNewPost(@RequestParam("email") String email, Model model) {

        // Busca al usuario usando el correo proporcionado
        Optional<UserBlog> optionalUserBlog = userBlogService.findByEmail(email);

        if (optionalUserBlog.isPresent()) {
            Post post = new Post();
            // Asigna el UserBlog al Post
            post.setUserBlog(optionalUserBlog.get());
            model.addAttribute("post", post);
            System.out.println("Entrooooooo");
            return "blog_new";
        } else {
            return "error404";
        }
    }

    @GetMapping("/posts/verificar")
    public String verifcationUSer() {

        return "/verificar";
    }

    @PostMapping("/posts/new")
    public String saveNewPost(@ModelAttribute Post post){
        postService.save(post);
        return "redirect:/posts/" + post.getId();
    }
}
