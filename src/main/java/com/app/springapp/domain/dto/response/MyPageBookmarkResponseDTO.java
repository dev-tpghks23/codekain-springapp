package com.app.springapp.domain.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
@Schema(description = "마이페이지 즐겨찾기 응답 DTO")
public class MyPageBookmarkResponseDTO {
    @Schema(description = "게시글 번호", example = "1", required = true)
    private Long id;
    @Schema(description = "게시글 제목", example = "수어 학습 자료 공유", required = true)
    private String postTitle;
    @Schema(description = "게시글 태그", example = "정보공유", required = true)
    private String postTag;
    @Schema(description = "게시글 조회수", example = "210", required = true)
    private Long postReadCount;
    @Schema(description = "게시글 작성일", example = "2025-03-08T14:21:00", required = true)
    private LocalDateTime postCreateAt;
    @Schema(description = "댓글 수", example = "4", required = true)
    private Long commentCount;
    @Schema(description = "좋아요 수", example = "12", required = true)
    private Long likeCount;
}