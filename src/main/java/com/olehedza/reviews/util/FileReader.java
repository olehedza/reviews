package com.olehedza.reviews.util;

import java.net.URISyntaxException;
import java.util.List;

public interface FileReader {
    List<String> readFile(String path);
}
