package com.example.store.repository;

import com.example.store.domain.ProductReview;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author rudolf.shakhgaldyan on 2/20/2021.
 */
public interface ProductReviewRepository extends JpaRepository<ProductReview, Long> {
}
