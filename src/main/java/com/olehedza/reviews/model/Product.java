package com.olehedza.reviews.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "products")
@NoArgsConstructor
@Data
public class Product {
    @Id
    private String productId;
    @OneToMany
    @Cascade(value = CascadeType.SAVE_UPDATE)
    private List<Review> reviews = new ArrayList<>();
    private boolean isFood;
}
