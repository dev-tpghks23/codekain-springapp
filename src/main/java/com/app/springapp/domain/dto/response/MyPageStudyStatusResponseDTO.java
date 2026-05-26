package com.app.springapp.domain.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@Schema(description = "마이페이지 학습 현황 응답 DTO")
public class MyPageStudyStatusResponseDTO {
    @Schema(description = "학습 번호", example = "1", required = true)
    private Long id;
    @Schema(description = "학습 제목", example = "수어 기초", required = true)
    private String eduTitle;
    @Schema(description = "학습 진행률", example = "100", required = true)
    private Long progress;
}