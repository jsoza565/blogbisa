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
public class LoginController {
    @Autowired
    private UserBlogService userBlogService;

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("userBlog", new UserBlog());
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@ModelAttribute("userBlog") UserBlog usuario, Model model) {
        UserBlog usuarioAutenticado = userBlogService.autenticar(usuario.getEmail(), usuario.getPassword());
        if (usuarioAutenticado != null) {
            model.addAttribute("userBlog", usuarioAutenticado);
            return "bienvenido";
        } else {
            model.addAttribute("error", "Email o contraseña incorrectos");

            return "/login";
        }
    }

//    @GetMapping("/")
//    public String showWelcomePage() {
//        return "principal";
//    }
}
