package com.example.lab1.domain.version;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostV2 {
    long id;
    String title;
    String content;
    String author;
}
