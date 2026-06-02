package com.app.springapp.service;

import com.app.springapp.domain.dto.UserDTO;
import com.app.springapp.domain.dto.response.UserResponseDTO;

public interface CommunityProfileService {
//    유저 정보 불러오기
    public UserResponseDTO getUserInfo(Long id);
}
