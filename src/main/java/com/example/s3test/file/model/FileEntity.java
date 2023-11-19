package com.example.s3test.file.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "t_file")
@Getter
public class FileEntity {
    @Id
    private UUID id;
    private String domain;
    private Long size;
    private String contentType;
    private String fileName;
    @CreationTimestamp
    private LocalDateTime createAt;

    public static FileEntity create(MultipartFile multipartFile, String domain) {
        FileEntity fileEntity = new FileEntity();
        fileEntity.id = UUID.randomUUID();
        fileEntity.fileName = multipartFile.getOriginalFilename();
        fileEntity.contentType = multipartFile.getContentType();
        fileEntity.size = multipartFile.getSize();
        fileEntity.domain = domain;
        fileEntity.createAt = LocalDateTime.now();
        return fileEntity;
    }

    public String getKey() {
        return String.format("%s/%s", domain, id.toString());
    }
}
