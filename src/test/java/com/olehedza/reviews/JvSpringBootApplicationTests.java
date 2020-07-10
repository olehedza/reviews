package com.olehedza.reviews;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.olehedza.reviews.util.FileReader;
import java.lang.reflect.UndeclaredThrowableException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JvSpringBootApplicationTests {
    private static final String FILE_PATH =
            "src/test/resources/readFileTest.csv";
    private static final String INVALID_FILE_PATH =
            "src/test/resources/readFileTst.csv";
    private static final int CSV_ROWS_NUMBER = 5;
    @Autowired
    private FileReader csvReader;

    @Test
    public void csvFileReaderTest() {
        assertEquals(CSV_ROWS_NUMBER, csvReader.readFile(FILE_PATH).size());
    }

    @Test
    public void csvFileReaderThrowsExceptionTest() {
        assertThrows(UndeclaredThrowableException.class,
                () -> csvReader.readFile(INVALID_FILE_PATH));
    }
}
