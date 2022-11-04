package com.example.lab1.repo;

import com.example.lab1.domain.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepo extends CrudRepository<Post, Long> {

}
