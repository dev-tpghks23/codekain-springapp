package com.app.springapp.domain.dto.response;

import com.app.springapp.domain.dto.QuizAttemptDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
@Data
@Schema(description = "퀴즈 풀이 회차 응답 DTO")
public class QuizAttemptResponseDTO {
    @Schema(description = "풀이 회차 번호", example = "1")
    private Long id;
    @Schema(description = "풀이 일시", example = "2024-01-01T00:00:00")
    private LocalDateTime quizAttemptCreateAt;
    @Schema(description = "획득 점수", example = "8")
    private int quizAttemptScore;
    @Schema(description = "총 문제 수", example = "10")
    private int quizAttemptTotalCount;
    @Schema(description = "퀴즈 풀이 소요시간: 초 단위", example = "120")
    private int quizAttemptTime;
    @Schema(description = "유저 번호", example = "1")
    private Long userId;
    @Schema(description = "퀴즈 번호", example = "1")
    private Long quizId;

    public static QuizAttemptResponseDTO from(QuizAttemptDTO dto) {
        QuizAttemptResponseDTO res = new QuizAttemptResponseDTO();
        res.setId(dto.getId());
        res.setQuizAttemptCreateAt(dto.getQuizAttemptCreateAt());
        res.setQuizAttemptScore(dto.getQuizAttemptScore());
        res.setQuizAttemptTotalCount(dto.getQuizAttemptTotalCount());
        res.setQuizAttemptTime(dto.getQuizAttemptTime());
        res.setUserId(dto.getUserId());
        res.setQuizId(dto.getQuizId());
        return res;
    }
}
