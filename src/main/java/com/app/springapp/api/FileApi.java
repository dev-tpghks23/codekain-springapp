package com.app.springapp.api;

import com.app.springapp.domain.dto.response.ApiResponseDTO;
import com.app.springapp.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.ResponseBytes;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/private/api/file")
@RequiredArgsConstructor
public class FileApi {

    private final FileService fileService;

    // 파일 1개 업로드
    @PostMapping("/upload-file")
    public ResponseEntity<ApiResponseDTO> upload(
            @RequestParam("uploadFile") MultipartFile uploadFile
    ) {
        return ResponseEntity.ok(fileService.uploadFile(uploadFile));
    }

    // 파일 여러 개 업로드
    @PostMapping("/upload-files")
    public ResponseEntity<ApiResponseDTO> uploads(
            @RequestParam("uploadFiles") List<MultipartFile> uploadFiles
    ) {
        return ResponseEntity.ok(fileService.uploadFiles(uploadFiles));
    }

    // 업로드 파일 조회
    @GetMapping("/display")
    public ResponseEntity<byte[]> display(
            @RequestParam String fileName
    ) {

        ResponseBytes<GetObjectResponse> responseBytes =
                fileService.getDisplayPath(fileName);

        String contentType =
                responseBytes.response().contentType();

        if (contentType == null || contentType.isBlank()) {
            contentType = MediaType.APPLICATION_OCTET_STREAM_VALUE;
        }

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, contentType)
                .body(responseBytes.asByteArray());
    }
}