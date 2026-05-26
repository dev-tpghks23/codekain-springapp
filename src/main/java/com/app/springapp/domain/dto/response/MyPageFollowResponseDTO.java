package com.app.springapp.domain.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@Schema(description = "마이페이지 팔로우 응답 DTO")
public class MyPageFollowResponseDTO {
    @Schema(description = "회원 번호", example = "1", required = true)
    private Long id;
    @Schema(description = "회원 닉네임", example = "수어친구", required = false)
    private String userNickname;
    @Schema(description = "회원 프로필 이미지", example = "default.jpg", required = true)
    private String userProfile;
}