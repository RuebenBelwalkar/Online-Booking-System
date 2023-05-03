package com.ani.bookingSystem.util;

import org.springframework.stereotype.Component;

import com.ani.bookingSystem.domain.Feedback;
import com.ani.bookingSystem.dto.FeedbackDto;

@Component
public class FeedbackMapper {
    public Feedback toDomain(FeedbackDto dto) {

        return Feedback.builder()
                        .id(dto.getId())
                        .comment(dto.getComment())
                        .rating(dto.getRating())
                        .build();
    }

    public FeedbackDto toDto(Feedback domain) {
        return new FeedbackDto(domain.getId(),
                                 domain.getComment(),
                                 domain.getRating());
                                
    }
}
