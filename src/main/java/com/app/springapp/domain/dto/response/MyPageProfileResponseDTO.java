package com.app.springapp.domain.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
@Schema(description = "마이페이지 프로필 응답 DTO")
public class MyPageProfileResponseDTO {
    @Schema(description = "회원 번호", example = "1", required = true)
    private Long id;
    @Schema(description = "회원 이름", example = "홍길동", required = true)
    private String userName;
    @Schema(description = "회원 닉네임", example = "홍길동", required = false)
    private String userNickname;
    @Schema(description = "회원 소개", example = "수어를 배우는 중입니다", required = false)
    private String userIntro;
    @Schema(description = "회원 직업", example = "학생", required = false)
    private String userJob;
    @Schema(description = "회원 지역", example = "서울 · 수도권", required = false)
    private String userAddress;
    @Schema(description = "회원 이메일", example = "user123@gmail.com", required = true)
    private String userEmail;
    @Schema(description = "회원 전화번호", example = "010-1234-5678", required = false)
    private String userPhoneNum;
    @Schema(description = "회원 경험치", example = "40", required = true)
    private Long userExp;
    @Schema(description = "회원 프로필 이미지", example = "default.jpg", required = true)
    private String userProfile;
    @Schema(description = "회원 가입일", example = "2025-01-15T00:00:00", required = true)
    private LocalDateTime userCreateAt;
}