package com.olehedza.reviews;

import static org.junit.jupiter.api.Assertions.*;

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
    private static final String INVALID_CSV_PATH =
            "csvParserTest.csv";
    private static final int CSV_ROWS_NUMBER = 5;
    private static final int DTO_NUMBER = 4;
    @Autowired
    private FileReader csvReader;
    @Autowired
    private Parser<CsvDto> csvParser;

    @Test
    public void csvFileReaderTest() {
        try {
            assertEquals(CSV_ROWS_NUMBER, csvReader.readFile(FILE_PATH).size());
        } catch (URISyntaxException e) {
            throw new UndeclaredThrowableException(e);
        }
    }

    @Test
    public void csvFileReaderThrowsExceptionTest() {
        assertThrows(UndeclaredThrowableException.class,
                () -> csvReader.readFile(INVALID_FILE_PATH));
    }

    @Test
    public void csvParserDtoNumberTest() {
        try {
            assertEquals(DTO_NUMBER, csvParser.parse(FILE_PATH).size());
        } catch (IOException e) {
            throw new UndeclaredThrowableException(e, "Csv parser dto invalid size");
        }
    }

    @Test
    public void parserInvalidCsvThrowsExceptionTest() {
        assertThrows(IllegalArgumentException.class,
                () -> csvParser.parse(INVALID_CSV_PATH));
    }
}
