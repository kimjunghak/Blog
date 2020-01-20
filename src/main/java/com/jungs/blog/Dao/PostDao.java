package com.jungs.blog.Dao;

import com.jungs.blog.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostDao extends JpaRepository<Post, Integer> {
}
