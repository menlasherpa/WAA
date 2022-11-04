package com.example.lab1.service.impl;

import com.example.lab1.domain.Post;
import com.example.lab1.domain.User;
import com.example.lab1.repo.UserRepo;
import com.example.lab1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;


    @Override
    public List<User> findAll() {
        return (List<User>) userRepo.findAll();
    }


    @Override
    public User getById(long id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public void save(User u) {
        userRepo.save(u);
    }

    @Override
    public List<Post> findPosts(long id) {
        User user = userRepo.findById(id).orElse(null);
        return user.getPosts();
    }
}
