package com.blog.bisa.jlss.repositories;

import com.blog.bisa.jlss.models.UserBlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserBlogRepository extends JpaRepository<UserBlog, Long> {
    Optional<UserBlog> findOneByEmail(String email);
    UserBlog findByEmail(String email);
}
