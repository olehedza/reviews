package com.olehedza.reviews.mapper;

import com.olehedza.reviews.dto.parser.CsvDto;
import com.olehedza.reviews.model.Product;
import com.olehedza.reviews.model.Review;
import com.olehedza.reviews.model.User;
import java.time.Instant;
import java.time.LocalDate;
import java.util.TimeZone;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CsvMapper implements Mapper {
    private static final String KEYWORD = "food";

    @Override
    public Review toReview(@NotNull CsvDto dto) {
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

    @Override
    public Product toProduct(@NotNull CsvDto dto, Review review) {
        Product product = new Product();
        product.setProductId(dto.getProductId());
        product.setFood(review.getText().toLowerCase().contains(KEYWORD)
                || review.getSummary().toLowerCase().contains(KEYWORD));
        return product;
    }

    @Override
    public User toUser(@NotNull CsvDto dto, Review review, Product product) {
        User user = new User();
        user.setUserId(dto.getUserId());
        user.setProfileName(dto.getProfileName());
        user.getReviews().add(review);
        user.getProducts().add(product);
        return user;
    }
}
