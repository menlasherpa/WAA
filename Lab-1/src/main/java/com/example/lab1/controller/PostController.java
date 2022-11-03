package com.example.lab1.controller;

import com.example.lab1.domain.dto.PostDto;
import com.example.lab1.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@CrossOrigin("https://localhost:3000")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<PostDto> getAll() {
        return postService.getAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<PostDto> getById(@PathVariable int id) {
        var post = postService.getById(id);
        return ResponseEntity.ok(post);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody PostDto postDto) {
        postService.save(postDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        postService.delete(id);
    }

    @PutMapping("{id}")
    public void update(@PathVariable("id") int id, @RequestBody PostDto postDto) {
        postService.update(id, postDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/by-author")
    public List<PostDto> getAll(@RequestParam(value = "filter", required = false) String author) {
        return author == null ?
                postService.getAll() : postService.getPostByAuthor(author);
    }

}
