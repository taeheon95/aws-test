package com.example.s3test.file.model;

import jakarta.validation.Valid;
import lombok.Getter;


public class FileRequestDTO {

    @Getter
    public static class Post {
        @Valid
        private String domain;
    }
}
