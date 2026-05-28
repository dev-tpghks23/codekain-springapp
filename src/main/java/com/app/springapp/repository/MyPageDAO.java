package com.app.springapp.repository;

import com.app.springapp.domain.dto.request.MyPageEditRequestDTO;
import com.app.springapp.domain.dto.response.MyPageActivityResponseDTO;
import com.app.springapp.domain.dto.response.MyPageFollowResponseDTO;
import com.app.springapp.domain.dto.response.MyPagePostResponseDTO;
import com.app.springapp.domain.dto.response.MyPageProfileResponseDTO;
import com.app.springapp.domain.dto.response.MyPageStudyStatusResponseDTO;
import com.app.springapp.domain.vo.UserWithdrawVO;
import com.app.springapp.mapper.MyPageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MyPageDAO {
    private final MyPageMapper myPageMapper;

    // 마이페이지 메인

    //    프로필 카드 조회
    public MyPageProfileResponseDTO findProfileByUserId(Long userId) {
        return myPageMapper.selectProfileByUserId(userId);
    }

    //    내 활동 개수 조회
    public MyPageActivityResponseDTO findActivityByUserId(Long userId) {
        return myPageMapper.selectActivityByUserId(userId);
    }

    //    내가 작성한 게시글 목록 조회
    public List<MyPagePostResponseDTO> findMyPostListByUserId(Long userId) {
        return myPageMapper.selectMyPostListByUserId(userId);
    }

    //    좋아요한 게시글 목록 조회
    public List<MyPagePostResponseDTO> findBookmarkListByUserId(Long userId) {
        return myPageMapper.selectBookmarkListByUserId(userId);
    }

    //    팔로잉 목록 조회
    public List<MyPageFollowResponseDTO> findFollowingListByUserId(Long userId) {
        return myPageMapper.selectFollowingListByUserId(userId);
    }

    //    팔로워 목록 조회
    public List<MyPageFollowResponseDTO> findFollowerListByUserId(Long userId) {
        return myPageMapper.selectFollowerListByUserId(userId);
    }

    //    출석 날짜 목록 조회
    public List<LocalDate> findAttendanceDateListByUserId(Long userId) {
        return myPageMapper.selectAttendanceDateListByUserId(userId);
    }

    //    학습 현황 조회
    public List<MyPageStudyStatusResponseDTO> findStudyStatusListByUserId(Long userId) {
        return myPageMapper.selectStudyStatusListByUserId(userId);
    }

    // 정보수정

    //    정보수정 화면 회원 정보 조회
    public MyPageProfileResponseDTO findUserInfoById(Long userId) {
        return myPageMapper.selectUserInfoById(userId);
    }

    //    소셜 로그인 회원 여부 조회
    public int findSocialUserCountByUserId(Long userId) {
        return myPageMapper.selectSocialUserCountByUserId(userId);
    }

    //    닉네임 중복 검사
    public int findUserCountByUserNickname(String userNickname, Long userId) {
        return myPageMapper.selectUserCountByUserNickname(userNickname, userId);
    }

    //    기본 프로필 수정
    public void updateUserBasicInfo(MyPageEditRequestDTO requestDTO, Long userId) {
        myPageMapper.updateUserBasicInfo(requestDTO, userId);
    }

    //    계정 정보 수정
    public void updateUserAccountInfo(MyPageEditRequestDTO requestDTO, Long userId) {
        myPageMapper.updateUserAccountInfo(requestDTO, userId);
    }

    //    프로필 사진 수정
    public void updateUserProfile(String userProfile, Long userId) {
        myPageMapper.updateUserProfile(userProfile, userId);
    }

    //    프로필 사진 기본 이미지로 변경
    public void deleteUserProfile(Long userId) {
        myPageMapper.deleteUserProfile(userId);
    }

    //    현재 비밀번호 조회
    public String findUserPasswordByUserId(Long userId) {
        return myPageMapper.selectUserPasswordByUserId(userId);
    }

    //    비밀번호 변경
    public void updateUserPassword(String newPassword, Long userId) {
        myPageMapper.updateUserPassword(newPassword, userId);
    }

    // 회원탈퇴

    //    회원탈퇴 사유 저장
    public void saveUserWithdraw(UserWithdrawVO userWithdrawVO) {
        myPageMapper.insertUserWithdraw(userWithdrawVO);
    }

    //    회원이 작성했거나 회원 게시글에 달린 댓글 좋아요 삭제
    public void deleteCommentLikeByWithdrawUserId(Long userId) {
        myPageMapper.deleteCommentLikeByWithdrawUserId(userId);
    }

    //    회원이 신고했거나 회원 게시글/댓글에 연결된 댓글 신고 삭제
    public void deleteCommentReportByWithdrawUserId(Long userId) {
        myPageMapper.deleteCommentReportByWithdrawUserId(userId);
    }

    //    회원 댓글 및 회원 게시글에 달린 댓글 삭제
    public void deleteCommentByWithdrawUserId(Long userId) {
        myPageMapper.deleteCommentByWithdrawUserId(userId);
    }

    //    회원이 누른 좋아요 및 회원 게시글 좋아요 삭제
    public void deletePostLikeByWithdrawUserId(Long userId) {
        myPageMapper.deletePostLikeByWithdrawUserId(userId);
    }

    //    회원이 신고했거나 회원 게시글에 연결된 게시글 신고 삭제
    public void deletePostReportByWithdrawUserId(Long userId) {
        myPageMapper.deletePostReportByWithdrawUserId(userId);
    }

    //    회원 게시글 첨부파일 삭제
    public void deletePostFileByWithdrawUserId(Long userId) {
        myPageMapper.deletePostFileByWithdrawUserId(userId);
    }

    //    회원 게시글 삭제
    public void deletePostByWithdrawUserId(Long userId) {
        myPageMapper.deletePostByWithdrawUserId(userId);
    }

    //    오늘의 단어 결과 삭제
    public void deleteTodayWordResultByWithdrawUserId(Long userId) {
        myPageMapper.deleteTodayWordResultByWithdrawUserId(userId);
    }

    //    오늘의 단어 상세 삭제
    public void deleteTodayWordDetailByWithdrawUserId(Long userId) {
        myPageMapper.deleteTodayWordDetailByWithdrawUserId(userId);
    }

    //    오늘의 단어 삭제
    public void deleteTodayWordByWithdrawUserId(Long userId) {
        myPageMapper.deleteTodayWordByWithdrawUserId(userId);
    }

    //    퀴즈 응시 상세 삭제
    public void deleteQuizAttemptDetailByWithdrawUserId(Long userId) {
        myPageMapper.deleteQuizAttemptDetailByWithdrawUserId(userId);
    }

    //    퀴즈 응시 기록 삭제
    public void deleteQuizAttemptByWithdrawUserId(Long userId) {
        myPageMapper.deleteQuizAttemptByWithdrawUserId(userId);
    }

    //    단어 학습 기록 삭제
    public void deleteWordStudyByWithdrawUserId(Long userId) {
        myPageMapper.deleteWordStudyByWithdrawUserId(userId);
    }

    //    학습 시작 기록 삭제
    public void deleteEduStartByWithdrawUserId(Long userId) {
        myPageMapper.deleteEduStartByWithdrawUserId(userId);
    }

    //    교육 수료증 기록 삭제
    public void deleteEduCertByWithdrawUserId(Long userId) {
        myPageMapper.deleteEduCertByWithdrawUserId(userId);
    }

    //    출석 기록 삭제
    public void deleteUserAttendanceByWithdrawUserId(Long userId) {
        myPageMapper.deleteUserAttendanceByWithdrawUserId(userId);
    }

    //    자격증 갱신 기록 삭제
    public void deleteCertRenewByWithdrawUserId(Long userId) {
        myPageMapper.deleteCertRenewByWithdrawUserId(userId);
    }

    //    시험 결과 삭제
    public void deleteTestResultByWithdrawUserId(Long userId) {
        myPageMapper.deleteTestResultByWithdrawUserId(userId);
    }

    //    시험 신청 기록 삭제
    public void deleteTestApplyByWithdrawUserId(Long userId) {
        myPageMapper.deleteTestApplyByWithdrawUserId(userId);
    }

    //    회원 뱃지 삭제
    public void deleteUserBadgeByWithdrawUserId(Long userId) {
        myPageMapper.deleteUserBadgeByWithdrawUserId(userId);
    }

    //    팔로우/팔로워 기록 삭제
    public void deleteFollowByWithdrawUserId(Long userId) {
        myPageMapper.deleteFollowByWithdrawUserId(userId);
    }

    //    차단 기록 삭제
    public void deleteUserBlockByWithdrawUserId(Long userId) {
        myPageMapper.deleteUserBlockByWithdrawUserId(userId);
    }

    //    알림 기록 삭제
    public void deleteNotificationByWithdrawUserId(Long userId) {
        myPageMapper.deleteNotificationByWithdrawUserId(userId);
    }

    //    AI 챗봇 기록 삭제
    public void deleteAiChatByWithdrawUserId(Long userId) {
        myPageMapper.deleteAiChatByWithdrawUserId(userId);
    }

    //    문의 기록 삭제
    public void deleteInquireByWithdrawUserId(Long userId) {
        myPageMapper.deleteInquireByWithdrawUserId(userId);
    }

    //    통합 신고 기록 삭제
    public void deleteReportByWithdrawUserId(Long userId) {
        myPageMapper.deleteReportByWithdrawUserId(userId);
    }

    //    채팅방 신고 기록 삭제
    public void deleteChatRoomReportByWithdrawUserId(Long userId) {
        myPageMapper.deleteChatRoomReportByWithdrawUserId(userId);
    }

    //    채팅 메시지 삭제
    public void deleteChatByWithdrawUserId(Long userId) {
        myPageMapper.deleteChatByWithdrawUserId(userId);
    }

    //    채팅방 참여 기록 삭제
    public void deleteChatUserByWithdrawUserId(Long userId) {
        myPageMapper.deleteChatUserByWithdrawUserId(userId);
    }

    //    회원이 만든 채팅방 삭제
    public void deleteChatRoomByWithdrawUserId(Long userId) {
        myPageMapper.deleteChatRoomByWithdrawUserId(userId);
    }

    //    회원 신고 기록 삭제
    public void deleteUserReportByWithdrawUserId(Long userId) {
        myPageMapper.deleteUserReportByWithdrawUserId(userId);
    }

    //    회원 설정 삭제
    public void deleteSettingByWithdrawUserId(Long userId) {
        myPageMapper.deleteSettingByWithdrawUserId(userId);
    }

    //    소셜 로그인 연결 정보 삭제
    public void deleteSocialUserByWithdrawUserId(Long userId) {
        myPageMapper.deleteSocialUserByWithdrawUserId(userId);
    }

    //    회원 기본 정보 삭제
    public void deleteUserByWithdrawUserId(Long userId) {
        myPageMapper.deleteUserByWithdrawUserId(userId);
    }
}