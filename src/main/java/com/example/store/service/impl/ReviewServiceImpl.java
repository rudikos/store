package com.example.store.service.impl;

import com.example.store.domain.Product;
import com.example.store.domain.Review;
import com.example.store.domain.User;
import com.example.store.dto.ReviewDto;
import com.example.store.exception.ResourceNotFoundException;
import com.example.store.repository.ReviewRepository;
import com.example.store.service.ProductService;
import com.example.store.service.ReviewService;
import com.example.store.service.UserService;
import org.springframework.stereotype.Service;

import java.time.ZoneId;

/**
 * @author rudolf.shakhgaldyan on 2/21/2021.
 */
@Service
public class ReviewServiceImpl implements ReviewService {

	private final ReviewRepository reviewRepository;
	private final ProductService productService;
	private final UserService userService;

	public ReviewServiceImpl(ReviewRepository reviewRepository, ProductService productService, UserService userService) {
		this.reviewRepository = reviewRepository;
		this.productService = productService;
		this.userService = userService;
	}

	@Override
	public ReviewDto createReview(Long productId, ReviewDto reviewDto, Long userId) throws ResourceNotFoundException {
		Product product = productService.getProduct(productId);
		User user = userService.getUser(userId);
		Review review = new Review(reviewDto.rate, reviewDto.comment, user, product);
		Review savedReview = reviewRepository.save(review);
		long modifiedDate = savedReview.getLastModifiedDate().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
		return new ReviewDto(savedReview.getRate(), savedReview.getComment(), savedReview.getLastModifiedBy(), modifiedDate);
	}

}
