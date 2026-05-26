package com.app.springapp.domain.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@Schema(description = "마이페이지 내 활동 응답 DTO")
public class MyPageActivityResponseDTO {
    @Schema(description = "작성 게시글 수", example = "42", required = true)
    private Long postCount;
    @Schema(description = "작성 댓글 수", example = "87", required = true)
    private Long commentCount;
    @Schema(description = "받은 좋아요 수", example = "128", required = true)
    private Long likeCount;
    @Schema(description = "즐겨찾기 수", example = "63", required = true)
    private Long bookmarkCount;
    @Schema(description = "팔로잉 수", example = "12", required = true)
    private Long followingCount;
    @Schema(description = "팔로워 수", example = "12", required = true)
    private Long followerCount;
}