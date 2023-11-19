package com.example.s3test.file.model;

import lombok.Getter;

import java.util.UUID;

@Getter
public class FileResponseDTO {
    private UUID id;
    private String domain;
    private Long size;
    private String fileName;

    public static FileResponseDTO create(FileEntity entity) {
        FileResponseDTO fileResponseDTO = new FileResponseDTO();
        fileResponseDTO.id = entity.getId();
        fileResponseDTO.domain = entity.getDomain();
        fileResponseDTO.size = entity.getSize();
        fileResponseDTO.fileName = entity.getFileName();
        return fileResponseDTO;
    }
}
