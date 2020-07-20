package com.olehedza.reviews.service;

import com.olehedza.reviews.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    Product addProduct(Product product);

    Product getByProductId(String id);

    Page<String> getAll(Pageable pageable);
}
