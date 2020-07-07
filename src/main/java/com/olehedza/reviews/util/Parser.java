package com.olehedza.reviews.util;

import java.util.List;

public interface Parser<T> {
    List<T> parse(String path);
}
