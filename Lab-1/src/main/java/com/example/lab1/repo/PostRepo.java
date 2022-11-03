package com.example.lab1.repo;

import com.example.lab1.domain.Post;

import java.util.List;

public interface PostRepo {
    public List<Post> getAll();
    public Post getById(int id);
    public void save(Post post);
    public void delete(int id);
    public void update(int id, Post post);

    List<Post> getPostByAuthor(String author);
}
