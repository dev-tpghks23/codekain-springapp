package com.app.springapp.repository;

import com.app.springapp.domain.vo.CommentLikeVO;
import com.app.springapp.mapper.CommentLikeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CommentLikeDAO {
    private final CommentLikeMapper commentLikeMapper;

//    댓글 좋아요 남기기
    public void save(CommentLikeVO commentLikeVO){
        commentLikeMapper.insert(commentLikeVO);
    }
}
