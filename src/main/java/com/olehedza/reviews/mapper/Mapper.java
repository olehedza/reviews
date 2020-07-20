package com.olehedza.reviews.mapper;

import com.olehedza.reviews.dto.parser.CsvDto;
import com.olehedza.reviews.model.Product;
import com.olehedza.reviews.model.Review;
import com.olehedza.reviews.model.User;

public interface Mapper {
    Review toReview(CsvDto dto);

    Product toProduct(CsvDto dto, Review review);

    User toUser(CsvDto dto, Review review, Product product);
}
