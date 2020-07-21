package com.olehedza.reviews.service;

import com.olehedza.reviews.model.Word;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface WordService {
    void addWord(Word word);

    Page<Word> getAll(Pageable pageable);
}
