package com.example.lab1.repo.impl;

import com.example.lab1.domain.Post;
import com.example.lab1.repo.PostRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepoImpl implements PostRepo {
    private static List<Post> posts;
    private static int postId =  1;

    static {
        posts = new ArrayList<>();
        Post p1 = new Post(111, "Post1", "This is post 1", "Lakpa Sherpa");
        Post p2 = new Post(112, "Post2", "This is post 2", "Menla Sherpa");
        posts.add(p1);
        posts.add(p2);
    }

    @Override
    public List<Post> getAll() {
        return posts;
    }

    @Override
    public Post getById(int id) {
        return posts
                .stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(Post post) {
        post.setId(postId++);
        posts.add(post);
    }

    @Override
    public void delete(int id) {
        var post = posts
                .stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .get();
        posts.remove(post);
    }

    @Override
    public void update(int id, Post post) {
        Post update = getById(id);
        update.setTitle(post.getTitle());
        update.setAuthor(post.getAuthor());
        update.setAuthor(post.getAuthor());
    }

    @Override
    public List<Post> getPostByAuthor(String author) {
        return posts
                .stream()
                .filter(a -> a.getAuthor() == author)
                .collect(Collectors.toList());
    }
}
