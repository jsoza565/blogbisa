package com.blog.bisa.jlss.controllers;

import com.blog.bisa.jlss.models.UserBlog;
import com.blog.bisa.jlss.services.UserBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrarController {

    @Autowired
    private UserBlogService userBlogService;
    @GetMapping("/registrar")
    public String RegistrarPage(Model model){
        UserBlog userBlog = new UserBlog();
        model.addAttribute("userBlog", userBlog);
        return "registrar";
    }

    @PostMapping("/registrar")
    public String RegistrarUser(@ModelAttribute UserBlog userBlog){
        userBlogService.save(userBlog);

        return "redirect:/";
    }
}
