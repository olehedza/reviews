package com.olehedza.reviews.service.impl;

import com.olehedza.reviews.model.Product;
import com.olehedza.reviews.repository.ProductRepository;
import com.olehedza.reviews.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;

    @Override
    public Product addProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public Product getByProductId(String id) {
        return repository.getByProductId(id);
    }

    @Override
    public Page<String> getAll(Pageable pageable) {
        return repository.getAll(pageable);
    }
}
