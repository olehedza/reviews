package com.olehedza.reviews;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.olehedza.reviews.dto.parser.CsvDto;
import com.olehedza.reviews.util.FileReader;
import com.olehedza.reviews.util.Parser;
import java.io.IOException;
import java.lang.reflect.UndeclaredThrowableException;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JvSpringBootApplicationTests {
    private static final String FILE_PATH =
            "readFileTest.csv";
    private static final String INVALID_FILE_PATH =
            "readFileTst.csv";
    private static final int CSV_ROWS_NUMBER = 5;
    private static final int DTO_NUMBER = 4;
    @Autowired
    private FileReader csvReader;
    @Autowired
    private Parser<CsvDto> csvParser;

    @Test
    public void csvFileReaderTest() {
        assertEquals(CSV_ROWS_NUMBER, csvReader.readFile(FILE_PATH).size());
    }

    @Test
    public void csvFileReaderThrowsExceptionTest() {
        assertThrows(UndeclaredThrowableException.class,
                () -> csvReader.readFile(INVALID_FILE_PATH));
    }

    @Test
    public void csvParserTest() throws IOException {
        assertEquals(DTO_NUMBER, csvParser.parse(FILE_PATH).size());
    }
}
