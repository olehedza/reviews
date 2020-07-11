package com.olehedza.reviews.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reviews")
@Data
@NoArgsConstructor
@Builder
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer helpfulnessNumerator;
    private Integer helpfulnessDenominator;
    private Integer score;
    private LocalDate time;
    @Column(length=2000)
    private String summary;
    @Column(length=2000)
    private String text;
}
