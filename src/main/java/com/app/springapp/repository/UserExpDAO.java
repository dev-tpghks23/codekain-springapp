package com.app.springapp.repository;

import com.app.springapp.domain.vo.UserExpHistoryVO;
import com.app.springapp.mapper.UserExpMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserExpDAO {
    private final UserExpMapper userExpMapper;

    //    회원 현재 경험치 조회
    public Long findUserExpByUserId(Long userId) {
        return userExpMapper.selectUserExpByUserId(userId);
    }

    //    회원 경험치 증가
    public void updateUserExp(Long userId, Long amount) {
        userExpMapper.updateUserExp(userId, amount);
    }

    //    경험치 지급 이력 저장
    public void saveUserExpHistory(UserExpHistoryVO userExpHistoryVO) {
        userExpMapper.insertUserExpHistory(userExpHistoryVO);
    }

    //    오늘 게시글/댓글 경험치 지급 횟수 조회
    public int findTodayCommunityExpCount(Long userId) {
        return userExpMapper.selectTodayCommunityExpCount(userId);
    }

    //    오늘 출석 경험치 지급 여부 조회
    public int findTodayAttendanceExpCount(Long userId) {
        return userExpMapper.selectTodayAttendanceExpCount(userId);
    }

    //    특정 대상 경험치 지급 여부 조회
    public int findTargetExpHistoryCount(Long userId, String userExpHistoryType, Long userExpHistoryTargetId) {
        return userExpMapper.selectTargetExpHistoryCount(userId, userExpHistoryType, userExpHistoryTargetId);
    }

    //    회원탈퇴 시 경험치 이력 삭제
    public void deleteUserExpHistoryByUserId(Long userId) {
        userExpMapper.deleteUserExpHistoryByUserId(userId);
    }
}