package com.app.springapp.api;

import com.app.springapp.domain.dto.UserDTO;
import com.app.springapp.domain.dto.request.MyPageEditRequestDTO;
import com.app.springapp.domain.dto.response.ApiResponseDTO;
import com.app.springapp.service.MyPageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/private/api/mypage")
public class MyPageApi {
    private final MyPageService myPageService;

    //    마이페이지 메인 조회
    @GetMapping("")
    @Operation(summary = "마이페이지 메인 조회", description = "로그인한 회원의 마이페이지 메인 정보를 조회합니다.")
    @ApiResponse(responseCode = "200", description = "마이페이지 메인 조회 성공")
    public ResponseEntity<ApiResponseDTO> getMyPageMain(Authentication authentication) {
        UserDTO userDTO = (UserDTO) authentication.getPrincipal();

        return ResponseEntity.ok(
                ApiResponseDTO.of(true, "마이페이지 메인 조회 성공", myPageService.getMyPageMain(userDTO.getId()))
        );
    }

    //    정보수정 화면 회원 정보 조회
    @GetMapping("/edit")
    @Operation(summary = "정보수정 화면 조회", description = "정보수정 화면에서 사용할 회원 정보를 조회합니다.")
    @ApiResponse(responseCode = "200", description = "정보수정 회원 정보 조회 성공")
    public ResponseEntity<ApiResponseDTO> getUserInfo(Authentication authentication) {
        UserDTO userDTO = (UserDTO) authentication.getPrincipal();

        return ResponseEntity.ok(
                ApiResponseDTO.of(true, "정보수정 회원 정보 조회 성공", myPageService.getUserInfo(userDTO.getId()))
        );
    }

    //    닉네임 중복 검사
    @GetMapping("/edit/nickname-check")
    @Operation(summary = "닉네임 중복 검사", description = "정보수정에서 입력한 닉네임의 중복 여부를 확인합니다.")
    @ApiResponse(responseCode = "200", description = "닉네임 중복 검사 성공")
    public ResponseEntity<ApiResponseDTO> checkNickname(
            @RequestParam String userNickname,
            Authentication authentication
    ) {
        UserDTO userDTO = (UserDTO) authentication.getPrincipal();
        boolean duplicated = myPageService.isDuplicatedNickname(userNickname, userDTO.getId());

        return ResponseEntity.ok(
                ApiResponseDTO.of(true, "닉네임 중복 검사 성공", duplicated)
        );
    }

    //    기본 프로필 수정
    @PatchMapping("/edit/basic")
    @Operation(summary = "기본 프로필 수정", description = "회원 이름, 닉네임, 소개, 직업, 지역 정보를 수정합니다.")
    @ApiResponse(responseCode = "200", description = "기본 프로필 수정 성공")
    public ResponseEntity<ApiResponseDTO> updateUserBasicInfo(
            @RequestBody MyPageEditRequestDTO requestDTO,
            Authentication authentication
    ) {
        UserDTO userDTO = (UserDTO) authentication.getPrincipal();

        myPageService.updateUserBasicInfo(requestDTO, userDTO.getId());

        return ResponseEntity.ok(
                ApiResponseDTO.of(true, "기본 프로필 수정 성공")
        );
    }

    //    계정 정보 수정
    @PatchMapping("/edit/account")
    @Operation(summary = "계정 정보 수정", description = "전화번호 등 계정 정보를 수정합니다.")
    @ApiResponse(responseCode = "200", description = "계정 정보 수정 성공")
    public ResponseEntity<ApiResponseDTO> updateUserAccountInfo(
            @RequestBody MyPageEditRequestDTO requestDTO,
            Authentication authentication
    ) {
        UserDTO userDTO = (UserDTO) authentication.getPrincipal();

        myPageService.updateUserAccountInfo(requestDTO, userDTO.getId());

        return ResponseEntity.ok(
                ApiResponseDTO.of(true, "계정 정보 수정 성공")
        );
    }

    //    프로필 사진 수정
    @PatchMapping("/edit/profile")
    @Operation(summary = "프로필 사진 수정", description = "프로필 사진을 업로드하고 회원 프로필 이미지를 수정합니다.")
    @ApiResponse(responseCode = "200", description = "프로필 사진 수정 성공")
    public ResponseEntity<ApiResponseDTO> updateUserProfile(
            @RequestPart("uploadFile") MultipartFile uploadFile,
            Authentication authentication
    ) {
        UserDTO userDTO = (UserDTO) authentication.getPrincipal();

        myPageService.updateUserProfile(uploadFile, userDTO.getId());

        return ResponseEntity.ok(
                ApiResponseDTO.of(true, "프로필 사진 수정 성공")
        );
    }

    //    프로필 사진 기본 이미지로 변경
    @DeleteMapping("/edit/profile")
    @Operation(summary = "프로필 사진 기본 이미지 변경", description = "회원 프로필 이미지를 기본 이미지로 변경합니다.")
    @ApiResponse(responseCode = "200", description = "프로필 사진 기본 이미지 변경 성공")
    public ResponseEntity<ApiResponseDTO> deleteUserProfile(Authentication authentication) {
        UserDTO userDTO = (UserDTO) authentication.getPrincipal();

        myPageService.deleteUserProfile(userDTO.getId());

        return ResponseEntity.ok(
                ApiResponseDTO.of(true, "프로필 사진 기본 이미지 변경 성공")
        );
    }

    //    비밀번호 변경
    @PatchMapping("/edit/password")
    @Operation(summary = "비밀번호 변경", description = "일반 회원의 현재 비밀번호 확인 후 새 비밀번호로 변경합니다.")
    @ApiResponse(responseCode = "200", description = "비밀번호 변경 성공")
    public ResponseEntity<ApiResponseDTO> updateUserPassword(
            @RequestParam String currentPassword,
            @RequestParam String newPassword,
            Authentication authentication
    ) {
        UserDTO userDTO = (UserDTO) authentication.getPrincipal();

        myPageService.updateUserPassword(currentPassword, newPassword, userDTO.getId());

        return ResponseEntity.ok(
                ApiResponseDTO.of(true, "비밀번호 변경 성공")
        );
    }
}