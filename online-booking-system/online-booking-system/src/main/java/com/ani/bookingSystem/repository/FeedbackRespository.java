package com.ani.bookingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ani.bookingSystem.domain.Feedback;

public interface FeedbackRespository extends JpaRepository<Feedback, Long> {
    
}
