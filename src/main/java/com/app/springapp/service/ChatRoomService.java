package com.app.springapp.service;

import com.app.springapp.domain.dto.request.ChatRoomRequestDTO;
import com.app.springapp.domain.dto.response.ChatRoomResponseDTO;
import com.app.springapp.domain.dto.response.ChatUserResponseDTO;

import java.util.List;

public interface ChatRoomService {
//    순수하게 채팅방을 생성 하는것
    public void createChatRoom(ChatRoomRequestDTO chatRoomRequestDTO);

//    유저의 채팅방 참여 목록 추가
    public void joinChatRoom(Long chatRoomId);

//    채팅방의 정보 불러오기
    public ChatRoomResponseDTO getChatRoomInfo(Long id);

//    채팅방 내 참여중인 유저 목록 불러오기
    public List<ChatUserResponseDTO> getChatRoomUsers(Long chatRoomId);

//    채팅방 정보 수정

//    채팅방 방장 위임

//    채팅방 삭제 (soft 삭제)

//    채팅방 검색
}
