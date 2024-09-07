package com.blog.bisa.jlss.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Builder
@AllArgsConstructor
public class UserBlog {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    String email;
    String password;
    String name;
    String n_paternal;
    String n_maternal;
    String birth;
    String country;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

   @OneToMany(mappedBy = "userBlog")
   List<Post> posts;


}
