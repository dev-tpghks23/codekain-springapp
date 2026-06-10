package com.app.springapp.mapper;

import com.app.springapp.domain.vo.QuizStartVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QuizStartMapper {

    // 퀴즈 시작 기록 조회
    public QuizStartVO selectByUserIdAndQuizId(Long userId, Long quizId);

    // 퀴즈 시작 기록 등록
    public void insert(QuizStartVO quizStartVO);

    // 퀴즈 시작 시간 갱신
    public void updateStartAt(Long userId, Long quizId);


}
