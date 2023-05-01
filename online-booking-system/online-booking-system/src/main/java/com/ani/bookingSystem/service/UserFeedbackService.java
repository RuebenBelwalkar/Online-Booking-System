package com.ani.bookingSystem.service;

import java.util.List;

import com.ani.bookingSystem.dto.FeedbackDto;
import com.ani.bookingSystem.dto.UsersFeedbackDto;

public interface UserFeedbackService {
    Integer createFeedback(FeedbackDto feedback);
    
    List<UsersFeedbackDto> allFeedbacks();
}
