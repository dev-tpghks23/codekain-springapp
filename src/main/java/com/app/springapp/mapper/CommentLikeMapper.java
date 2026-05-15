package com.app.springapp.mapper;

import com.app.springapp.domain.vo.CommentLikeVO;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentLikeMapper {
//    댓글에 좋아요 하기
    public void insert(CommentLikeVO commentLikeVO);

}
