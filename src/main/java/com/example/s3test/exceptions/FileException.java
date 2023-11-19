package com.example.s3test.exceptions;

import lombok.Getter;

@Getter
public class FileException extends RuntimeException {
    private final String fileName;
    private final Long fileSize;
    private final String contentType;

    public FileException(Throwable error, String fileName, Long fileSize, String contentType) {
        super(error);
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.contentType = contentType;
    }
}
