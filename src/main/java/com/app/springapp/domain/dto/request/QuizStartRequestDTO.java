package com.app.springapp.domain.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@Schema(description = "퀴즈 시작 요청 DTO")
public class QuizStartRequestDTO {

    @Schema(description = "유저 번호", example = "1")
    private Long userId;
}
