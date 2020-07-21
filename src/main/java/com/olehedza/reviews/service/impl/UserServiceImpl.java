package com.olehedza.reviews.service.impl;

import com.olehedza.reviews.model.Product;
import com.olehedza.reviews.model.Review;
import com.olehedza.reviews.model.User;
import com.olehedza.reviews.repository.UserRepository;
import com.olehedza.reviews.service.ProductService;
import com.olehedza.reviews.service.ReviewService;
import com.olehedza.reviews.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl  implements UserService {
    private static final int INDEX = 0;
    private final UserRepository repository;
    private final ProductService productService;
    private final ReviewService reviewService;

    @Override
    public User addUser(User user) {
        User toDb = new User();
        toDb.setProfileName(user.getProfileName());
        toDb.setUserId(user.getUserId());
        Review review = reviewService.addReview(user.getReviews().get(INDEX));
        Product product = user.getProducts().get(INDEX);
        if (!product.isFood()
                && productService.getByProductId(product.getProductId()) != null) {
            product.setFood(productService.getByProductId(product.getProductId()).isFood());
        }
        product.getReviews().add(review);
        product = productService.addProduct(product);
        toDb.getReviews().add(review);
        toDb.getProducts().add(product);
        return repository.save(toDb);
    }

    @Override
    public Page<String> getAll(Pageable pageable) {
        return repository.getAll(pageable);
    }
}
