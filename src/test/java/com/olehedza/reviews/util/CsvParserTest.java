package com.olehedza.reviews.util;

import static org.junit.jupiter.api.Assertions.*;
import com.olehedza.reviews.dto.parser.CsvDto;
import java.io.IOException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CsvParserTest {
    private static final String FILE_PATH =
            "/home/olehedza/Documents/SpringBootProject/Reviews.csv";
    private static final String FILE_INVALID_PATH =
            "/home/olehedza/Documents/SpringBootProject/Revews.csv";
    private static final int ROWS = 568454;
    private Parser<CsvDto> parser;

    @BeforeEach
    void setUp() {
        parser = new CsvParser();
    }

    @Test
    void exceptionDoesNotThrowTest() {
        assertDoesNotThrow(() -> parser.parse(FILE_PATH),
                "There should not be an error: IOException");
    }

    @Test
    void exceptionThrowTest() {
        assertThrows(IOException.class,
                () -> parser.parse(FILE_INVALID_PATH),
                "There should be an error: FileNotFoundException");

    }

    @Test
    void readAllRowsTest() throws IOException {
        int actual = parser.parse(FILE_PATH).size();
        assertEquals(ROWS, actual);
    }
}
