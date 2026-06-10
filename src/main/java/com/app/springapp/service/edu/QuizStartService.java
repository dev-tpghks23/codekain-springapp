package com.app.springapp.service.edu;

public interface QuizStartService {

    // 퀴즈 시작 기록 등록
    public void startQuiz(Long userId, Long quizId);
}
