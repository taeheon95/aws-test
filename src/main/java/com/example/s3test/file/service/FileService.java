package com.example.s3test.file.service;

import com.example.s3test.file.model.FileRequestDTO;
import com.example.s3test.file.model.FileResponseDTO;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    FileResponseDTO uploadFile(FileRequestDTO.Post fileDTO, MultipartFile multipartFile);
    void deleteFile();
}
