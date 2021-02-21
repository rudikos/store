package com.example.store.service;

import com.example.store.dto.ReviewDto;
import com.example.store.exception.ResourceNotFoundException;

/**
 * @author rudolf.shakhgaldyan on 2/21/2021.
 */
public interface ReviewService {
	ReviewDto createReview(Long productId, ReviewDto reviewDto, Long userId) throws ResourceNotFoundException;
}
