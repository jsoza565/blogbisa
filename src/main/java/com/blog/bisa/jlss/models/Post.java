package com.blog.bisa.jlss.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Builder
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    String title;
    String issue;
    String periodicity;
    Boolean state_comment;
    @Column(columnDefinition = "TEXT")
    String body;

    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    //@NotNull
    @ManyToOne
    @JoinColumn(name = "userBlog_id", referencedColumnName = "id", nullable = false)
    UserBlog userBlog;
}
