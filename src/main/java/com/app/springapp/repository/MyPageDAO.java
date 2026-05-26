package com.app.springapp.repository;

import com.app.springapp.domain.dto.request.MyPageEditRequestDTO;
import com.app.springapp.domain.dto.response.MyPageActivityResponseDTO;
import com.app.springapp.domain.dto.response.MyPageFollowResponseDTO;
import com.app.springapp.domain.dto.response.MyPagePostResponseDTO;
import com.app.springapp.domain.dto.response.MyPageProfileResponseDTO;
import com.app.springapp.domain.dto.response.MyPageStudyStatusResponseDTO;
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
}