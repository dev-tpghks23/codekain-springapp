package com.app.springapp.mapper;

import com.app.springapp.domain.vo.UserExpHistoryVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserExpMapper {

    //    회원 현재 경험치 조회
    Long selectUserExpByUserId(Long userId);

    //    회원 경험치 증가
    void updateUserExp(@Param("userId") Long userId, @Param("amount") Long amount);

    //    경험치 지급 이력 저장
    void insertUserExpHistory(UserExpHistoryVO userExpHistoryVO);

    //    오늘 게시글/댓글 경험치 지급 횟수 조회
    int selectTodayCommunityExpCount(Long userId);

    //    오늘 출석 경험치 지급 여부 조회
    int selectTodayAttendanceExpCount(Long userId);

    //    특정 대상 경험치 지급 여부 조회
    int selectTargetExpHistoryCount(
            @Param("userId") Long userId,
            @Param("userExpHistoryType") String userExpHistoryType,
            @Param("userExpHistoryTargetId") Long userExpHistoryTargetId
    );

    //    회원탈퇴 시 경험치 이력 삭제
    void deleteUserExpHistoryByUserId(Long userId);
}