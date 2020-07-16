package com.olehedza.reviews.controller;

import com.olehedza.reviews.model.Word;
import com.olehedza.reviews.service.WordService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/words")
@AllArgsConstructor
public class WordController {
    private final WordService service;

    @GetMapping
    public Page<Word> getPage(@PageableDefault(size = 1000) Pageable pageable) {
        return service.getAll(pageable);
    }
}
