package com.example.lab1.service;

import com.example.lab1.domain.dto.PostDto;

import java.util.List;

public interface PostService {

    public List<PostDto> getAll();
    public PostDto getById(int id);
    public void save(PostDto postDto);
    public void delete(int id);
    public void update(int id, PostDto postDto);
    public List<PostDto> getPostByAuthor(String author);
}
