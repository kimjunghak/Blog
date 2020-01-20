package com.jungs.blog.controller;

import com.jungs.blog.Dao.PostDao;
import com.jungs.blog.Entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostDao postDao;

    @RequestMapping("/write")
    public Post write(Post post){
        post.setRegDate(LocalDateTime.now());
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
    public Post view(Model model, @PathVariable int id){
        Post post = postDao.findById(id).get();
//        model.addAttribute("post", post);
        return post;
    }

    @RequestMapping("/{id}/delete")
    public List<Post> delete(@PathVariable int id){
        postDao.deleteById(id);
        return postDao.findAll();
    }

    @GetMapping("/{id}/edit")
    public Post edit(Model model, @PathVariable int id){
        Post post = postDao.findById(id).get();
//        model.addAttribute("post", post);
        return post;
    }

    @PostMapping("/{id}/edit")
    public List<Post> edit(@Valid Post post){
        postDao.save(post);
        return postDao.findAll();
    }
}
