package com.example.store.service;

import com.example.store.dto.ReviewDto;
import com.example.store.exception.ResourceNotFoundException;

import java.util.Collection;

/**
 * @author rudolf.shakhgaldyan on 2/21/2021.
 */
public interface ReviewService {
	ReviewDto createReview(Long productId, ReviewDto reviewDto, Long userId) throws ResourceNotFoundException;

	Collection<ReviewDto> findByProductId(Long productId);
}
