package com.blog.bisa.jlss.repositories;

import com.blog.bisa.jlss.models.UserBlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserBlogRepository extends JpaRepository<UserBlog, Long> {
}
