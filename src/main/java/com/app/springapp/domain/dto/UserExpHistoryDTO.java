package com.app.springapp.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
@Schema(description = "유저 경험치 지급 이력 DTO")
public class UserExpHistoryDTO {

    @Schema(description = "경험치 지급 이력 번호", example = "1")
    private Long id;

    @Schema(description = "경험치 지급 타입", example = "STUDY")
    private String userExpHistoryType;

    @Schema(description = "지급 경험치", example = "20")
    private Long userExpHistoryAmount;

    @Schema(description = "경험치 지급 대상 번호", example = "3")
    private Long userExpHistoryTargetId;

    @Schema(description = "경험치 지급 일시", example = "2026-06-02T10:30:00")
    private LocalDateTime userExpHistoryCreateAt;

    @Schema(description = "회원 번호", example = "1")
    private Long userId;
}