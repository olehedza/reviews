package com.olehedza.reviews.controller;

import com.olehedza.reviews.dto.parser.CsvDto;
import com.olehedza.reviews.mapper.CsvMapper;
import com.olehedza.reviews.model.Product;
import com.olehedza.reviews.model.Review;
import com.olehedza.reviews.model.User;
import com.olehedza.reviews.service.ProductService;
import com.olehedza.reviews.service.ReviewService;
import com.olehedza.reviews.service.UserService;
import com.olehedza.reviews.util.Parser;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/inject")
@RestController
@AllArgsConstructor
public class InjectCsvToDbController {
    private final UserService userService;
    private final ReviewService reviewService;
    private final ProductService productService;
    private final CsvMapper mapper;
    private final Parser<CsvDto> parser;
    private static final String PATH = "Reviews.csv";

    @GetMapping
    @SneakyThrows
    public HttpStatus injectCsvData(@RequestParam(defaultValue = PATH) String path) {
        List<CsvDto> parse = parser.parse(path);
        for (CsvDto dto: parse) {
            Product product = productService.addProduct(mapper.getProductFromDto(dto));
            Review review = reviewService.addReview(mapper.getReviewFromDto(dto));
            User user = mapper.getUserFromDto(dto);
            user.getProducts().add(product);
            user.getReviews().add(review);
            userService.addUser(user);
        }
        return HttpStatus.OK;
    }
}
