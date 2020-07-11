package com.olehedza.reviews.service.impl;

import com.olehedza.reviews.model.Review;
import com.olehedza.reviews.repository.ReviewRepository;
import com.olehedza.reviews.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository repository;

    @Override
    public Review addReview(Review review) {
        return repository.save(review);
    }
}
