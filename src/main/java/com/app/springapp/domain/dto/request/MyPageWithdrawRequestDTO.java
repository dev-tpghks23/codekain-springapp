package com.app.springapp.domain.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@Schema(description = "마이페이지 회원탈퇴 요청 DTO")
public class MyPageWithdrawRequestDTO {

    @Schema(description = "탈퇴 사유", example = "자주 사용하지 않아요", required = true)
    private String withdrawReason;

    @Schema(description = "기타 선택 시 입력하는 상세 사유", example = "원하는 기능이 부족했습니다.", required = false)
    private String withdrawDetail;

    @Schema(description = "일반 회원 탈퇴 확인용 비밀번호", example = "test123!@#", required = false)
    private String userPassword;

    @Schema(description = "소셜 로그인 회원 이메일 인증번호", example = "123456", required = false)
    private String emailCode;

    @Schema(description = "탈퇴 유의사항 확인 동의 여부", example = "true", required = true)
    private boolean withdrawAgree;
}