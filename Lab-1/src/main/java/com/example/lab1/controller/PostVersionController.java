package com.example.lab1.controller;


import com.example.lab1.domain.version.PostV2;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostVersionController {

    @GetMapping(value = "/post/header", headers = "X-API-VERSION=2")
    public PostV2 headerV2() {
        return new PostV2(115, "Post v2", "This is Post Version 2", "Dawa Sherpa");
    }
}
