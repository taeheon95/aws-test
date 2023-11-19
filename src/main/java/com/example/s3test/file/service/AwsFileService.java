package com.example.s3test.file.service;

import com.example.s3test.file.model.FileEntity;
import com.example.s3test.file.model.FileRequestDTO;
import com.example.s3test.file.model.FileResponseDTO;
import com.example.s3test.file.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;

import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class AwsFileService implements FileService {

    private final S3Client s3Client;
    private final FileRepository fileRepository;

    @Value("${aws.s3.bucketName}")
    private String bucketName;

    @Override
    public FileResponseDTO uploadFile(FileRequestDTO.Post fileDTO, MultipartFile multipartFile) {
        FileEntity fileEntity = FileEntity.create(multipartFile, fileDTO.getDomain());
        try {
            uploadFileToAws(multipartFile, fileEntity);
            fileRepository.save(fileEntity);
            return FileResponseDTO.create(fileEntity);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void uploadFileToAws(MultipartFile multipartFile, FileEntity fileEntity) throws IOException {
        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .key(fileEntity.getKey())
                .bucket(bucketName)
                .contentType(fileEntity.getContentType())
                .contentLength(fileEntity.getSize())
                .build();
        s3Client.putObject(putObjectRequest, RequestBody.fromBytes(multipartFile.getBytes()));
    }

    @Override
    public void deleteFile() {
        DeleteObjectRequest deleteObjectRequest = DeleteObjectRequest.builder()
                .bucket(bucketName)
                .key("test/프로그래밍.jpg")
                .build();
        s3Client.deleteObject(deleteObjectRequest);
    }
}
