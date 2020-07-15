package com.olehedza.reviews.mapper;

import com.olehedza.reviews.dto.parser.CsvDto;
import com.olehedza.reviews.model.Product;
import com.olehedza.reviews.model.Review;
import com.olehedza.reviews.model.User;
import java.time.Instant;
import java.time.LocalDate;
import java.util.TimeZone;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CsvMapper {

    public Review getReviewFromDto(CsvDto dto) {
        return Review.builder()
                .score(dto.getScore())
                .helpfulnessDenominator(dto.getHelpfulnessDenominator())
                                .helpfulnessNumerator(dto.getHelpfulnessNumerator())
                .time(LocalDate.ofInstant(Instant.ofEpochSecond(dto.getTime()),
                        TimeZone.getTimeZone("UTC").toZoneId()))
                .summary(dto.getSummary())
                .text(dto.getText())
                .build();
    }

    public User getUserFromDto(CsvDto dto) {
        User user = new User();
        user.setUserId(dto.getUserId());
        user.setProfileName(dto.getProfileName());
        user.getReviews().add(getReviewFromDto(dto));
        user.getProducts().add(getProductFromDto(dto));
        return user;
    }

    public Product getProductFromDto(CsvDto dto) {
        Product product = new Product();
        product.setProductId(dto.getProductId());
        product.getReviews().add(getReviewFromDto(dto));
        return product;
    }
}
