package com.example.s3test.file.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;


public class FileRequestDTO {

    @Getter
    public static class Post {
        @NotBlank
        private String domain;
    }
}
