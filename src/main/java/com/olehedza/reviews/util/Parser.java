package com.olehedza.reviews.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface Parser<T> {
    List<T> parse(String path) throws IOException;
}
