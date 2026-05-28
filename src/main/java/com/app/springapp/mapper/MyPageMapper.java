package com.app.springapp.mapper;

import com.app.springapp.domain.dto.request.MyPageEditRequestDTO;
import com.app.springapp.domain.dto.response.MyPageActivityResponseDTO;
import com.app.springapp.domain.dto.response.MyPageFollowResponseDTO;
import com.app.springapp.domain.dto.response.MyPagePostResponseDTO;
import com.app.springapp.domain.dto.response.MyPageProfileResponseDTO;
import com.app.springapp.domain.dto.response.MyPageStudyStatusResponseDTO;
import com.app.springapp.domain.vo.UserWithdrawVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface MyPageMapper {
    // 마이페이지 메인

    //    프로필 카드 조회
    MyPageProfileResponseDTO selectProfileByUserId(@Param("userId") Long userId);

    //    내 활동 개수 조회
    MyPageActivityResponseDTO selectActivityByUserId(Long userId);

    //    내가 작성한 게시글 목록 조회
    List<MyPagePostResponseDTO> selectMyPostListByUserId(Long userId);

    //    좋아요한 게시글 목록 조회
    List<MyPagePostResponseDTO> selectBookmarkListByUserId(Long userId);

    //    팔로잉 목록 조회
    List<MyPageFollowResponseDTO> selectFollowingListByUserId(Long userId);

    //    팔로워 목록 조회
    List<MyPageFollowResponseDTO> selectFollowerListByUserId(Long userId);

    //    출석 날짜 목록 조회
    List<LocalDate> selectAttendanceDateListByUserId(Long userId);

    //    학습 현황 조회
    List<MyPageStudyStatusResponseDTO> selectStudyStatusListByUserId(Long userId);

    // 정보수정

    //    정보수정 화면 회원 정보 조회
    MyPageProfileResponseDTO selectUserInfoById(@Param("userId") Long userId);

    //    소셜 로그인 회원 여부 조회
    int selectSocialUserCountByUserId(Long userId);

    //    닉네임 중복 검사
    int selectUserCountByUserNickname(@Param("userNickname") String userNickname, @Param("userId") Long userId);

    //    기본 프로필 수정
    void updateUserBasicInfo(@Param("requestDTO") MyPageEditRequestDTO requestDTO, @Param("userId") Long userId);

    //    계정 정보 수정
    void updateUserAccountInfo(@Param("requestDTO") MyPageEditRequestDTO requestDTO, @Param("userId") Long userId);

    //    프로필 사진 수정
    void updateUserProfile(@Param("userProfile") String userProfile, @Param("userId") Long userId);

    //    프로필 사진 기본 이미지로 변경
    void deleteUserProfile(@Param("userId") Long userId);

    //    일반 회원 비밀번호 조회
    String selectUserPasswordByUserId(Long userId);

    //    일반 회원 비밀번호 변경
    void updateUserPassword(@Param("newPassword") String newPassword, @Param("userId") Long userId);

    // 회원탈퇴

    //    회원탈퇴 사유 저장
    void insertUserWithdraw(UserWithdrawVO userWithdrawVO);

    //    회원이 작성했거나 회원 게시글에 달린 댓글 좋아요 삭제
    void deleteCommentLikeByWithdrawUserId(Long userId);

    //    회원이 신고했거나 회원 게시글/댓글에 연결된 댓글 신고 삭제
    void deleteCommentReportByWithdrawUserId(Long userId);

    //    회원 댓글 및 회원 게시글에 달린 댓글 삭제
    void deleteCommentByWithdrawUserId(Long userId);

    //    회원이 누른 좋아요 및 회원 게시글 좋아요 삭제
    void deletePostLikeByWithdrawUserId(Long userId);

    //    회원이 신고했거나 회원 게시글에 연결된 게시글 신고 삭제
    void deletePostReportByWithdrawUserId(Long userId);

    //    회원 게시글 첨부파일 삭제
    void deletePostFileByWithdrawUserId(Long userId);

    //    회원 게시글 삭제
    void deletePostByWithdrawUserId(Long userId);

    //    오늘의 단어 결과 삭제
    void deleteTodayWordResultByWithdrawUserId(Long userId);

    //    오늘의 단어 상세 삭제
    void deleteTodayWordDetailByWithdrawUserId(Long userId);

    //    오늘의 단어 삭제
    void deleteTodayWordByWithdrawUserId(Long userId);

    //    퀴즈 응시 상세 삭제
    void deleteQuizAttemptDetailByWithdrawUserId(Long userId);

    //    퀴즈 응시 기록 삭제
    void deleteQuizAttemptByWithdrawUserId(Long userId);

    //    단어 학습 기록 삭제
    void deleteWordStudyByWithdrawUserId(Long userId);

    //    학습 시작 기록 삭제
    void deleteEduStartByWithdrawUserId(Long userId);

    //    교육 수료증 기록 삭제
    void deleteEduCertByWithdrawUserId(Long userId);

    //    출석 기록 삭제
    void deleteUserAttendanceByWithdrawUserId(Long userId);

    //    자격증 갱신 기록 삭제
    void deleteCertRenewByWithdrawUserId(Long userId);

    //    시험 결과 삭제
    void deleteTestResultByWithdrawUserId(Long userId);

    //    시험 신청 기록 삭제
    void deleteTestApplyByWithdrawUserId(Long userId);

    //    회원 뱃지 삭제
    void deleteUserBadgeByWithdrawUserId(Long userId);

    //    팔로우/팔로워 기록 삭제
    void deleteFollowByWithdrawUserId(Long userId);

    //    차단 기록 삭제
    void deleteUserBlockByWithdrawUserId(Long userId);

    //    알림 기록 삭제
    void deleteNotificationByWithdrawUserId(Long userId);

    //    AI 챗봇 기록 삭제
    void deleteAiChatByWithdrawUserId(Long userId);

    //    문의 기록 삭제
    void deleteInquireByWithdrawUserId(Long userId);

    //    통합 신고 기록 삭제
    void deleteReportByWithdrawUserId(Long userId);

    //    채팅방 신고 기록 삭제
    void deleteChatRoomReportByWithdrawUserId(Long userId);

    //    채팅 메시지 삭제
    void deleteChatByWithdrawUserId(Long userId);

    //    채팅방 참여 기록 삭제
    void deleteChatUserByWithdrawUserId(Long userId);

    //    회원이 만든 채팅방 삭제
    void deleteChatRoomByWithdrawUserId(Long userId);

    //    회원 신고 기록 삭제
    void deleteUserReportByWithdrawUserId(Long userId);

    //    회원 설정 삭제
    void deleteSettingByWithdrawUserId(Long userId);

    //    소셜 로그인 연결 정보 삭제
    void deleteSocialUserByWithdrawUserId(Long userId);

    //    회원 기본 정보 삭제
    void deleteUserByWithdrawUserId(Long userId);
}