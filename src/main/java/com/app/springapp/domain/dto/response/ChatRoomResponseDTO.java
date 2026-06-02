package com.app.springapp.domain.dto.response;

import com.app.springapp.domain.vo.ChatRoomVO;
import io.swagger.v3.oas.annotations.media.Schema;
import com.app.springapp.domain.dto.ChatRoomDTO;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
@Data
@Schema(description = "채팅방 응답 DTO")
public class ChatRoomResponseDTO {
    @Schema(description = "채팅방 번호", example = "1")
    private Long id;
    @Schema(description = "채팅방 이름", example = "수어 학습 모임")
    private String chatRoomName;
    @Schema(description = "채팅방 타입", example = "그룹")
    private String chatRoomType;
    @Schema(description = "채팅방 생성일시", example = "2024-01-01T00:00:00")
    private LocalDateTime chatRoomCreateAt;
    @Schema(description = "채팅방 프로필 이미지", example = "default.jpg")
    private String chatRoomProfile;
//    @Schema(description = "채팅방 개설자 유저 번호", example = "1")
//    private Long userId;
    @Schema(description = "채팅방 상세 소개", example = "수어 관련 학습을 공유하는 채팅방 입니다")
    private String chatRoomDetail;
    @Schema(description = "채팅방 채팅 가능 정원", example = "100")
    private int ChatRoomLimit;
    @Schema(description = "채팅방 현재 채팅중인 인원", example = "50")
    private int ChatRoomUsers;
    @Schema(description = "채팅방 방장 여부", example = "True")
    private Boolean isOwner;

    public static ChatRoomResponseDTO from(ChatRoomDTO dto) {
        ChatRoomResponseDTO res = new ChatRoomResponseDTO();
        res.setId(dto.getId());
        res.setChatRoomName(dto.getChatRoomName());
        res.setChatRoomType(dto.getChatRoomType());
        res.setChatRoomCreateAt(dto.getChatRoomCreateAt());
        res.setChatRoomProfile(dto.getChatRoomProfile());
//        res.setUserId(dto.getUserId());
        res.setChatRoomDetail(dto.getChatRoomDetail());
        res.setChatRoomLimit(dto.getChatRoomLimit());
        res.setChatRoomUsers(dto.getChatRoomUsers());
        res.setIsOwner(dto.getIsOwner());
        return res;
    }

    public static ChatRoomResponseDTO from(ChatRoomVO chatRoomVO) {
        ChatRoomResponseDTO res = new ChatRoomResponseDTO();
        res.setId(chatRoomVO.getId());
        res.setChatRoomName(chatRoomVO.getChatRoomName());
        res.setChatRoomType(chatRoomVO.getChatRoomType());
        res.setChatRoomCreateAt(chatRoomVO.getChatRoomCreateAt());
        res.setChatRoomProfile(chatRoomVO.getChatRoomProfile());
//        res.setUserId(chatRoomVO.getUserId());
        res.setChatRoomLimit(chatRoomVO.getChatRoomLimit());
        res.setChatRoomDetail(chatRoomVO.getChatRoomDetail());
        return res;
    }
}
