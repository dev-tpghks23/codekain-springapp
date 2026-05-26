package com.app.springapp.mapper;

import com.app.springapp.domain.dto.request.MyPageEditRequestDTO;
import com.app.springapp.domain.dto.response.MyPageActivityResponseDTO;
import com.app.springapp.domain.dto.response.MyPageFollowResponseDTO;
import com.app.springapp.domain.dto.response.MyPagePostResponseDTO;
import com.app.springapp.domain.dto.response.MyPageProfileResponseDTO;
import com.app.springapp.domain.dto.response.MyPageStudyStatusResponseDTO;
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

    //    현재 비밀번호 조회
    String selectUserPasswordByUserId(Long userId);

    //    비밀번호 변경
    void updateUserPassword(@Param("newPassword") String newPassword, @Param("userId") Long userId);
}