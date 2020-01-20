package com.jungs.blog.controller;

import com.jungs.blog.Dao.PostDao;
import com.jungs.blog.Entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostDao postDao;

    @RequestMapping("/write")
    public String write(Post post){
        post.setRegDate(new Date());
        return "redirect:/post/" + postDao.save(post).getId();
    }

    @RequestMapping("/list")
    public String list(Model model){
        List<Post> postList = postDao.findAll();
        model.addAttribute("postList", postList);
        return "blog";
    }

    @RequestMapping("/{id}")
    public String view(Model model, @PathVariable int id){
        Post post = postDao.findById(id).get();
        model.addAttribute("post", post);
        return "post" ;
    }
}