package com.example.lab1.controller;

import com.example.lab1.domain.Post;
import com.example.lab1.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@CrossOrigin("https://localhost:3000")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping
    public List<Post> getPosts() {
        return postService.findAll();
    }


    @GetMapping("/{id}")
    public Post getPostsById(@PathVariable("id") int id) {
        return postService.getById(id);
    }

    @PostMapping
    public void save(@RequestBody Post p) {

        postService.save(p);
    }

}
