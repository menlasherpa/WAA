package com.example.lab1.service.impl;

import com.example.lab1.domain.Post;
import com.example.lab1.domain.dto.PostDto;
import com.example.lab1.helper.ListMapper;
import com.example.lab1.repo.PostRepo;
import com.example.lab1.service.PostService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepo postRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper<Post, PostDto> listMapperPostDto;

    @Override
    public List<PostDto> getAll() {
        return (List<PostDto>) listMapperPostDto.mapList(postRepo.getAll(), new PostDto());
    }

    @Override
    public PostDto getById(int id) {
        return modelMapper.map(postRepo.getById(id), PostDto.class);
    }

    @Override
    public void save(PostDto postDto) {
        postRepo.save(modelMapper.map(postDto, Post.class));
    }

    @Override
    public void delete(int id) {
        postRepo.delete(id);
    }

    @Override
    public void update(int id, PostDto postDto) {
        postRepo.update(id, modelMapper.map(postDto, Post.class));
    }

    @Override
    public List<PostDto> getPostByAuthor(String author) {
        return (List<PostDto>) listMapperPostDto.mapList(postRepo.getPostByAuthor(author), new PostDto());
    }
}
