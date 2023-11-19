package com.example.s3test.file;

import com.example.s3test.common.ApiResponse;
import com.example.s3test.file.model.FileRequestDTO;
import com.example.s3test.file.model.FileResponseDTO;
import com.example.s3test.file.service.FileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/file")
public class FileController {
    private final FileService fileService;


    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<FileResponseDTO> postFile(@RequestPart @Valid FileRequestDTO.Post fileDTO, @RequestPart MultipartFile file) {
        FileResponseDTO fileResponseDTO = fileService.uploadFile(fileDTO, file);
        ApiResponse<FileResponseDTO> apiResponse = new ApiResponse<>();
        apiResponse.setCode("success");
        apiResponse.setData(fileResponseDTO);
        return apiResponse;
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteFile() {
        fileService.deleteFile();
        return "success";
    }
}
