package com.olehedza.reviews.util;

import com.olehedza.reviews.dto.parser.CsvDto;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

@Component
@Getter
@Slf4j
public class CsvParser implements Parser<CsvDto> {
    private final List<CsvDto> csvDtoList;

    public CsvParser() {
        this.csvDtoList = new ArrayList<>();
    }

    @Override
    public List<CsvDto> parse(String path) throws IOException {
        try (Reader in = new FileReader(path)) {
            Iterable<CSVRecord> records = CSVFormat.DEFAULT
                    .withFirstRecordAsHeader()
                    .parse(in);
            for (CSVRecord record : records) {
                if (record.size() == CsvHeaders.values().length) {
                    CsvDto dto = CsvDto.builder()
                            .productId(record.get(CsvHeaders.ProductId))
                            .userId(record.get(CsvHeaders.UserId))
                            .profileName(record.get(CsvHeaders.ProfileName))
                            .helpfulnessNumerator(Integer.parseInt(record
                                    .get(CsvHeaders.HelpfulnessNumerator)))
                            .helpfulnessDenominator(Integer.parseInt(record
                                    .get(CsvHeaders.HelpfulnessDenominator)))
                            .score(Integer.parseInt(record.get(CsvHeaders.Score)))
                            .time(Long.parseLong(record.get(CsvHeaders.Time)))
                            .summary(record.get(CsvHeaders.Summary))
                            .text(record.get(CsvHeaders.Text))
                            .build();
                    csvDtoList.add(dto);
                }
            }
        } catch (FileNotFoundException e) {
            log.error("File not found ", e);
            throw new FileNotFoundException("File not found ");
        } catch (IOException e) {
            log.error("Can't read the file ", e);
            throw new IOException("Can't read the file ");
        }
        return csvDtoList;
    }

    enum CsvHeaders {
        Id, ProductId, UserId,
        ProfileName, HelpfulnessNumerator,
        HelpfulnessDenominator, Score,
        Time, Summary, Text
    }
}
