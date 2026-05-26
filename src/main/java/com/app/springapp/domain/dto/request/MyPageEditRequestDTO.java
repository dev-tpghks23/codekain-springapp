package com.app.springapp.domain.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@Schema(description = "마이페이지 정보수정 요청 DTO")
public class MyPageEditRequestDTO {

    @Schema(description = "회원 이름", example = "홍길동", required = false)
    private String userName;

    @Schema(description = "회원 닉네임", example = "수어왕홍길동", required = false)
    private String userNickname;

    @Schema(description = "회원 소개", example = "수어를 배우고 있습니다.", required = false)
    private String userIntro;

    @Schema(description = "회원 직업", example = "학생", required = false)
    private String userJob;

    @Schema(description = "회원 지역", example = "서울 · 수도권", required = false)
    private String userAddress;

    @Schema(description = "회원 이메일", example = "test@gmail.com", required = false)
    private String userEmail;

    @Schema(description = "이메일 인증번호", example = "123456", required = false)
    private String emailCode;

    @Schema(description = "회원 전화번호", example = "010-1234-5678", required = false)
    private String userPhoneNum;

    @Schema(description = "휴대폰 인증번호", example = "654321", required = false)
    private String phoneCode;
}