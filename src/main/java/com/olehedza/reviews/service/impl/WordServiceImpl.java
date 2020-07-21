package com.olehedza.reviews.service.impl;

import com.olehedza.reviews.model.Word;
import com.olehedza.reviews.repository.WordRepository;
import com.olehedza.reviews.service.WordService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WordServiceImpl  implements WordService {
    private final WordRepository repository;

    @Override
    public void addWord(Word word) {
        repository.save(word);
    }

    @Override
    public Page<Word> getAll(Pageable pageable) {
        return repository.getAll(pageable);
    }
}
