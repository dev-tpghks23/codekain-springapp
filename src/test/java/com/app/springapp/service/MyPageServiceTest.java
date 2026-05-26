package com.app.springapp.service;

import com.app.springapp.domain.dto.request.MyPageEditRequestDTO;
import com.app.springapp.domain.dto.response.MyPageFollowResponseDTO;
import com.app.springapp.domain.dto.response.MyPagePostResponseDTO;
import com.app.springapp.domain.dto.response.MyPageStudyStatusResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mock.web.MockMultipartFile;

@SpringBootTest
@Slf4j
public class MyPageServiceTest {
    @Autowired
    private MyPageService myPageService;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    // 마이페이지 메인

    //    마이페이지 메인 조회 테스트
    @Test
    public void getMyPageMainTest() {
        Long userId = 1L;

        log.info(myPageService.getMyPageMain(userId).toString());
    }

    //    프로필 카드 조회 테스트
    @Test
    public void getProfileTest() {
        Long userId = 1L;

        log.info(myPageService.getProfile(userId).toString());
    }

    //    내 활동 개수 조회 테스트
    @Test
    public void getActivityTest() {
        Long userId = 1L;

        log.info(myPageService.getActivity(userId).toString());
    }

    //    내가 작성한 게시글 목록 조회 테스트
    @Test
    public void getMyPostListTest() {
        Long userId = 1L;

        myPageService.getMyPostList(userId)
                .stream()
                .forEach((post) -> log.info(post.toString()));
    }

    //    좋아요한 게시글 목록 조회 테스트
    @Test
    public void getBookmarkListTest() {
        Long userId = 1L;

        myPageService.getBookmarkList(userId)
                .stream()
                .forEach((post) -> log.info(post.toString()));
    }

    //    팔로잉 목록 조회 테스트
    @Test
    public void getFollowingListTest() {
        Long userId = 1L;

        myPageService.getFollowingList(userId)
                .stream()
                .forEach((follow) -> log.info(follow.toString()));
    }

    //    팔로워 목록 조회 테스트
    @Test
    public void getFollowerListTest() {
        Long userId = 1L;

        myPageService.getFollowerList(userId)
                .stream()
                .forEach((follow) -> log.info(follow.toString()));
    }

    //    출석 정보 조회 테스트
    @Test
    public void getAttendanceTest() {
        Long userId = 1L;

        log.info(myPageService.getAttendance(userId).toString());
    }

    //    학습 현황 조회 테스트
    @Test
    public void getStudyStatusListTest() {
        Long userId = 1L;

        myPageService.getStudyStatusList(userId)
                .stream()
                .forEach((studyStatus) -> log.info(studyStatus.toString()));
    }

    // 정보수정

    //    정보수정 화면 회원 정보 조회 테스트
    @Test
    public void getUserInfoTest() {
        Long userId = 1L;

        log.info(myPageService.getUserInfo(userId).toString());
    }

    //    소셜 로그인 회원 여부 조회 테스트
    @Test
    public void isSocialUserTest() {
        Long userId = 1L;

        log.info("소셜 로그인 회원 여부: {}", myPageService.isSocialUser(userId));
    }

    //    닉네임 중복 검사 테스트
    @Test
    public void isDuplicatedNicknameTest() {
        Long userId = 1L;
        String userNickname = "minjun_k";

        log.info("닉네임 중복 여부: {}", myPageService.isDuplicatedNickname(userNickname, userId));
    }

    //    기본 프로필 수정 테스트
    @Test
    public void updateUserBasicInfoTest() {
        Long userId = 1L;

        MyPageEditRequestDTO requestDTO = new MyPageEditRequestDTO();
        requestDTO.setUserName("김민준");
        requestDTO.setUserNickname("minjun_update");
        requestDTO.setUserIntro("정보수정 테스트입니다.");
        requestDTO.setUserJob("소프트웨어 개발자");
        requestDTO.setUserAddress("서울특별시 강남구");

        myPageService.updateUserBasicInfo(requestDTO, userId);

        log.info("기본 프로필 수정 성공");
    }

    //    계정 정보 수정 테스트
    @Test
    public void updateUserAccountInfoTest() {
        Long userId = 1L;

        MyPageEditRequestDTO requestDTO = new MyPageEditRequestDTO();
        requestDTO.setUserEmail("minjun.kim@email.com");
        requestDTO.setUserPhoneNum("010-1234-5678");

        myPageService.updateUserAccountInfo(requestDTO, userId);

        log.info("계정 정보 수정 성공");
    }

    //    프로필 사진 기본 이미지 변경 테스트
    @Test
    public void deleteUserProfileTest() {
        Long userId = 1L;

        myPageService.deleteUserProfile(userId);

        log.info("프로필 사진 기본 이미지 변경 성공");
    }

    //    프로필 사진 수정 테스트
//    @Test
//    public void updateUserProfileTest() {
//        Long userId = 1L;
//
//        MockMultipartFile uploadFile = new MockMultipartFile(
//                "uploadFile",
//                "profile-test.png",
//                "image/png",
//                "profile image test".getBytes()
//        );
//
//        myPageService.updateUserProfile(uploadFile, userId);
//
//        log.info("프로필 사진 수정 성공");
//    }

    //    비밀번호 변경 테스트
//    @Test
//    public void updateUserPasswordTest() {
//        Long userId = 1L;
//        String currentPassword = "1234";
//        String newPassword = "12345";
//
//        myPageService.updateUserPassword(currentPassword, newPassword, userId);
//
//        log.info("비밀번호 변경 성공");
//    }


}