package com.olehedza.reviews.service.impl;

import com.olehedza.reviews.model.Word;
import com.olehedza.reviews.repository.WordRepository;
import com.olehedza.reviews.service.WordService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WordServiceImpl implements WordService {
    private final WordRepository repository;

    @Override
    public List<Word> findWordsWithLimit(int limit) {
        return repository.findWordsWithLimit(limit);
    }

    @Override
    public void add(Word word) {
        repository.add(word);
    }
}
