package com.app.springapp.service;

import com.app.springapp.domain.dto.request.MyPageEditRequestDTO;
import com.app.springapp.domain.dto.request.MyPageWithdrawRequestDTO;
import com.app.springapp.domain.dto.response.MyPageActivityResponseDTO;
import com.app.springapp.domain.dto.response.MyPageAttendanceResponseDTO;
import com.app.springapp.domain.dto.response.MyPageFollowResponseDTO;
import com.app.springapp.domain.dto.response.MyPageMainResponseDTO;
import com.app.springapp.domain.dto.response.MyPagePostResponseDTO;
import com.app.springapp.domain.dto.response.MyPageProfileResponseDTO;
import com.app.springapp.domain.dto.response.MyPageStudyStatusResponseDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MyPageService {
    // 마이페이지 메인

    //    마이페이지 메인 조회
    MyPageMainResponseDTO getMyPageMain(Long userId);

    //    프로필 카드 조회
    MyPageProfileResponseDTO getProfile(Long userId);

    //    내 활동 개수 조회
    MyPageActivityResponseDTO getActivity(Long userId);

    //    내가 작성한 게시글 목록 조회
    List<MyPagePostResponseDTO> getMyPostList(Long userId);

    //    좋아요한 게시글 목록 조회
    List<MyPagePostResponseDTO> getBookmarkList(Long userId);

    //    팔로잉 목록 조회
    List<MyPageFollowResponseDTO> getFollowingList(Long userId);

    //    팔로워 목록 조회
    List<MyPageFollowResponseDTO> getFollowerList(Long userId);

    //    출석 정보 조회
    MyPageAttendanceResponseDTO getAttendance(Long userId);

    //    학습 현황 조회
    List<MyPageStudyStatusResponseDTO> getStudyStatusList(Long userId);

    // 정보수정

    //    정보수정 화면 회원 정보 조회
    MyPageProfileResponseDTO getUserInfo(Long userId);

    //    소셜 로그인 회원 여부 조회
    boolean isSocialUser(Long userId);

    //    닉네임 중복 검사
    boolean isDuplicatedNickname(String userNickname, Long userId);

    //    기본 프로필 수정
    void updateUserBasicInfo(MyPageEditRequestDTO requestDTO, Long userId);

    //    계정 정보 수정
    void updateUserAccountInfo(MyPageEditRequestDTO requestDTO, Long userId);

    //    프로필 사진 수정
    void updateUserProfile(MultipartFile uploadFile, Long userId);

    //    프로필 사진 기본 이미지로 변경
    void deleteUserProfile(Long userId);

    //    비밀번호 변경
    void updateUserPassword(String currentPassword, String newPassword, Long userId);

    // 회원탈퇴

    //    회원탈퇴 처리
    void withdrawUser(MyPageWithdrawRequestDTO requestDTO, Long userId);
}