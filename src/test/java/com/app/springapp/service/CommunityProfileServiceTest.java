package com.app.springapp.service;

import com.app.springapp.domain.dto.response.UserResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class CommunityProfileServiceTest {
    @Autowired
    private CommunityProfileService communityProfileService;

    @Test
    public void getUserInfoTest() {
        Long userId = 1L;
        UserResponseDTO userResponseDTO = communityProfileService.getUserInfo(userId);
        log.info("userResponseDTO={}", userResponseDTO);
    }
}
