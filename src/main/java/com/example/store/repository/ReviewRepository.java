package com.example.store.repository;

import com.example.store.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

/**
 * @author rudolf.shakhgaldyan on 2/20/2021.
 */
public interface ReviewRepository extends JpaRepository<Review, Long> {
	Collection<Review> findByProductId(Long productId);
}
