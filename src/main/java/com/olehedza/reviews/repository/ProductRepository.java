package com.olehedza.reviews.repository;

import com.olehedza.reviews.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    Product getByProductId(String id);

    @Query("select p.productId from Product p where p.isFood = true order by p.reviews.size desc")
    Page<String> getAll(Pageable pageable);
}
