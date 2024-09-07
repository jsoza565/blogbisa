package com.blog.bisa.jlss.config;

import com.blog.bisa.jlss.models.Post;
import com.blog.bisa.jlss.models.UserBlog;
import com.blog.bisa.jlss.services.PostService;
import com.blog.bisa.jlss.services.UserBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class SeedData implements CommandLineRunner {
    @Autowired
            private PostService postService;
    @Autowired
    private UserBlogService userBlogService;

    @Override
    public void run(String... args) throws Exception {
        List<Post> posts = postService.getAll();
        if (posts.size() == 0) {

            UserBlog userBlog1 = new UserBlog();
            userBlog1.setEmail("juan@gmail.com");
            userBlog1.setPassword("user");
            userBlog1.setName("Juan");
            userBlog1.setN_paternal("Vargas");
            userBlog1.setN_maternal("Memdez");
            userBlog1.setBirth("01/01/1980");
            userBlog1.setCountry("Bolivia");
            userBlogService.save(userBlog1);

            Post post1 = new Post();
            post1.setTitle("Overwatch game");
            post1.setBody("Nuevo juego en ps4");
            post1.setIssue("PS4");
            post1.setPeriodicity("semanal");
            post1.setState_comment(true);
            post1.setUserBlog(userBlog1);
            Post post2 = new Post();
            post2.setTitle("Tiempo de juego");
            post2.setBody("cual es el tiempo recomendado para jugar");
            post2.setIssue("General");
            post2.setPeriodicity("mensual");
            post2.setState_comment(false);
            post2.setUserBlog(userBlog1);
            postService.save(post1);
            postService.save(post2);
        }
    }
}
