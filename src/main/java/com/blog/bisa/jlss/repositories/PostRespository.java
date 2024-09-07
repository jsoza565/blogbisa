package com.blog.bisa.jlss.repositories;

import com.blog.bisa.jlss.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRespository extends JpaRepository<Post, Long> {
}
