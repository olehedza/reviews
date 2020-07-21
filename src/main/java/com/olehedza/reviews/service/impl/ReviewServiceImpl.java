package com.olehedza.reviews.service.impl;

import com.olehedza.reviews.model.Review;
import com.olehedza.reviews.model.Word;
import com.olehedza.reviews.repository.ReviewRepository;
import com.olehedza.reviews.service.ReviewService;
import com.olehedza.reviews.service.WordService;
import com.olehedza.reviews.util.Splitter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository repository;
    private final WordService wordService;
    private final Splitter splitter;

    @Override
    public Review addReview(Review review) {
        for (String word : splitter.split(review.getText())) {
            wordService.addWord(new Word(word));
        }
        return repository.save(review);
    }
}
