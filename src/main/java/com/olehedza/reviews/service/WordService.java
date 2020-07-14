package com.olehedza.reviews.service;

import com.olehedza.reviews.model.Word;
import java.util.List;

public interface WordService {
    List<Word> findWordsWithLimit(int limit);

    void add(Word word);
}
