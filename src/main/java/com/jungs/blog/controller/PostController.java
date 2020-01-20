package com.jungs.blog.controller;

import com.jungs.blog.Dao.PostDao;
import com.jungs.blog.Entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostDao postDao;

    @RequestMapping("/write")
    public Post write(Post post){
        post.setRegDate(new Date());
        Post postData = postDao.save(post);
        return postData;
    }

    @RequestMapping("/list")
    public List<Post> list(Model model){
        List<Post> postList = postDao.findAll();
//        model.addAttribute("postList", postList);
        return postList;
    }

    @RequestMapping("/{id}")
    public int view(Model model, @PathVariable int id){
        Post post = postDao.findById(id).get();
//        model.addAttribute("post", post);
        return post.getId();
    }
}
