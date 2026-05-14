package com.app.springapp.service;

import com.app.springapp.domain.dto.request.CommentRequestDTO;
import com.app.springapp.domain.dto.response.CommentResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class CommentServiceTest {
    @Autowired
    private CommentService commentService;

//    게시글에 달린 모든 댓글 조회 서비스 테스트
    @Test
    public void getAllPostCommentsTest(){
        Long postId = 1L;
        List<CommentResponseDTO> comments = commentService.getAllPostComments(postId);
        comments.forEach(comment -> {
            log.info(comment.toString());
        });
    }

//    게시글에 댓글 달기 테스트
    @Test
    public void writePostCommentTest(){
        CommentRequestDTO commentRequestDTO = new CommentRequestDTO();
        commentRequestDTO.setCommentContent("댓글 달기 단위테스트");
        Long postId = 1L;
        commentService.writePostComment(postId, commentRequestDTO);
    }

//    대댓글 달기 테스트
    @Test
    public void writePostReplyTest(){
        CommentRequestDTO commentRequestDTO = new CommentRequestDTO();
        commentRequestDTO.setCommentContent("대댓글 테스트 입니다.");
//        Long postId = 1L;
        Long postId = 4L;
        Long commentId = 1L;

        commentService.writePostReply(postId, commentId, commentRequestDTO);
    }
}
