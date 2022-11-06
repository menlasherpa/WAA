package com.example.lab1.service;

import com.example.lab1.domain.Comment;
import com.example.lab1.domain.Post;

import java.util.List;

public interface CommentService {

    public List<Comment> getComments();
    public List<Post> save(Comment c);

}
