package com.app.springapp.service;

import com.app.springapp.domain.dto.request.CommentRequestDTO;
import com.app.springapp.domain.dto.response.CommentResponseDTO;
import com.app.springapp.domain.vo.CommentVO;
import com.app.springapp.exception.CommentException;
import com.app.springapp.repository.CommentDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackFor = {Exception.class})
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentDAO commentDAO;
    private final CommunityAuthService communityAuthService;

    @Override
    public List<CommentResponseDTO> getAllPostComments(Long postId) {
        return commentDAO.findAllByPostId(postId)
                .stream()
                .map(CommentResponseDTO::from)
                .collect(Collectors.toList());
    }

    @Override
    public void writePostComment(Long postId, CommentRequestDTO commentRequestDTO) {
        Long userId = communityAuthService.getUserId();
        communityAuthService.checkUserValidity(userId);

        CommentVO commentVO = CommentVO.from(commentRequestDTO);
        commentVO.setPostId(postId);
        commentVO.setUserId(userId);

        try {
            commentDAO.save(commentVO);
        } catch (Exception e) {
            throw new CommentException(HttpStatus.BAD_REQUEST, "댓글 작성 실패");
        }
    }

    @Override
    public void writePostReply(Long postId, Long commentId, CommentRequestDTO commentRequestDTO) {
        Long userId = communityAuthService.getUserId();
        communityAuthService.checkUserValidity(userId);

        CommentVO commentVO = CommentVO.from(commentRequestDTO);
        commentVO.setPostId(postId);
        commentVO.setUserId(userId);
        commentVO.setCommentId(commentId);

        try {
            commentDAO.save(commentVO);
        } catch (Exception e) {
            throw new CommentException(HttpStatus.BAD_REQUEST, "대댓글 작성 실패");
        }
    }

    @Override
    public void updateComment(Long commentId, CommentRequestDTO commentRequestDTO) {
        Long userId = communityAuthService.getUserId();

        CommentVO commentVO = new CommentVO();
        commentVO.setId(commentId);
        commentVO.setUserId(userId);

        if (commentDAO.existByIdAndUserId(commentVO) == 0) {
            throw new CommentException(HttpStatus.BAD_REQUEST, "해당 댓글 수정 권한 없습니다.");
        }

        commentVO.setCommentContent(commentRequestDTO.getCommentContent());
        commentDAO.update(commentVO);
    }

    @Override
    public void deleteComment(Long commentId) {
        Long userId = communityAuthService.getUserId();

        CommentVO commentVO = new CommentVO();
        commentVO.setId(commentId);
        commentVO.setUserId(userId);

        if (commentDAO.existByIdAndUserId(commentVO) == 0) {
            throw new CommentException(HttpStatus.BAD_REQUEST, "해당 댓글 삭제 권한 없습니다.");
        }

        commentDAO.updateRepliesIsDeleted(commentId);
        commentDAO.updateIsDeleted(commentVO);
    }

    @Override
    public void deleteReply(Long replyId) {
        Long userId = communityAuthService.getUserId();

        CommentVO commentVO = new CommentVO();
        commentVO.setId(replyId);
        commentVO.setUserId(userId);

        if (commentDAO.existByIdAndUserId(commentVO) == 0) {
            throw new CommentException(HttpStatus.BAD_REQUEST, "해당 대댓글 삭제 권한 없습니다.");
        }

        commentDAO.updateIsDeleted(commentVO);
    }
}
