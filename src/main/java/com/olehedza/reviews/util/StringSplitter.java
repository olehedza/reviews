package com.olehedza.reviews.util;

import static com.google.common.base.Splitter.onPattern;

import org.springframework.stereotype.Component;

@Component
public class StringSplitter implements Splitter {
    private static final String PATTERN = "<[^>]*>|<br|br/>|\\W";

    @Override
    public Iterable<String> split(String input) {
        return onPattern(PATTERN)
                .omitEmptyStrings()
                .split(input);
    }
}
