package com.olehedza.reviews.model;

import java.util.List;
import javax.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "products")
@NoArgsConstructor
@Data
public class Product {
    @Id
    private String productId;
    @ManyToMany
    @JoinTable(
            name = "users_products",
            joinColumns = @JoinColumn(name = "productId"),
            inverseJoinColumns = @JoinColumn(name = "userId"))
    private List<User> users;
    @OneToMany
    @Cascade(value = org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<Review> reviews;
}
