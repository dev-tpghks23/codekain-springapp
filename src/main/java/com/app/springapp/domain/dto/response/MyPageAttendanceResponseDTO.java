package com.app.springapp.domain.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Data
@Schema(description = "마이페이지 출석 응답 DTO")
public class MyPageAttendanceResponseDTO {
    @Schema(description = "현재 연속 출석일", example = "1003", required = true)
    private Long attendanceCount;
    @Schema(description = "연속 출석 시작일", example = "2025-02-07", required = false)
    private LocalDate attendanceStartDate;
    @Schema(description = "역대 최고 연속 출석일", example = "30", required = true)
    private Long maxAttendanceCount;
}