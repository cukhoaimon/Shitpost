package com.cukhoaimon.blog.controller;

import com.cukhoaimon.blog.data.Post;
import com.cukhoaimon.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/posts")
    public String about(
            Model model,
            @RequestParam(value="limit", required = false) Integer limit
    ) {
        List<Post> posts = postService.findAll();

        model.addAttribute("posts", limit != null ? posts.subList(0, limit) : posts );
        return "posts";
    }

    @GetMapping("/posting")
    public String posting(Model model) {
        model.addAttribute("post", new Post());
        return "posting";
    }

    @PostMapping("/posting")
    public String posting(@ModelAttribute Post post) {
        postService.save(post);

        return "posting";
    }

    @GetMapping("/delete/{id}")
    public String deletePost(@PathVariable(name="id") String postid, Model model) {
        Post post = postService.findById(postid);

        if (null == post) {
            throw new RuntimeException("DDD");
        }

        postService.deleteById(postid);
        return "deleet";
    }
}
