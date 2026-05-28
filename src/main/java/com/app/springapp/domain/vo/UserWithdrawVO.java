package com.app.springapp.domain.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
@Schema(description = "회원탈퇴 사유 VO")
public class UserWithdrawVO {

    @Schema(description = "회원탈퇴 사유 번호", example = "1")
    private Long id;

    @Schema(description = "삭제 전 회원 번호", example = "1")
    private Long userId;

    @Schema(description = "탈퇴 사유", example = "자주 사용하지 않아요")
    private String userWithdrawReason;

    @Schema(description = "기타 선택 시 입력한 상세 사유", example = "원하는 기능이 부족했습니다.")
    private String userWithdrawDetail;

    @Schema(description = "탈퇴 사유 저장 일시", example = "2026-05-28T14:30:00")
    private LocalDateTime userWithdrawCreateAt;
}