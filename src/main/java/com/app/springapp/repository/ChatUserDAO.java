package com.app.springapp.repository;

import com.app.springapp.domain.dto.ChatUserDTO;
import com.app.springapp.domain.vo.ChatUserVO;
import com.app.springapp.mapper.ChatUserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ChatUserDAO {
    private final ChatUserMapper chatMemberMapper;

//    유저의 채팅방 참여 현황 추가 (id 채팅방에 userId 유저 참여 기록 추가)
    public void save(ChatUserVO chatMemberVO){
        chatMemberMapper.insert(chatMemberVO);
    }

//    채팅방 내 참여중 유저 불러오기
    public List<ChatUserDTO> findByChatRoomId(Long chatRoomId){
        return chatMemberMapper.selectByChatRoomId(chatRoomId);
    }
}
