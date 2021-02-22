package com.example.store.endpoint;

import com.example.store.dto.ReviewDto;
import com.example.store.exception.ResourceNotFoundException;
import com.example.store.service.CurrentUserProvider;
import com.example.store.service.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author rudolf.shakhgaldyan on 2/21/2021.
 */
@RestController
public class ReviewController extends BaseController {

	private final ReviewService reviewService;

	public ReviewController(CurrentUserProvider currentUserProvider, ReviewService reviewService) {
		super(currentUserProvider);
		this.reviewService = reviewService;
	}

	@PostMapping(value = "/products/{productId}/reviews")
	public ReviewDto createReview(@PathVariable("productId") Long productId, @RequestBody ReviewDto reviewDto) throws ResourceNotFoundException {
		if (reviewDto.rate < 1 || reviewDto.rate > 5) {
			throw new IllegalArgumentException("invalid rate");
		}
		Long currentUserId = currentUserProvider.getCurrentUserId();
		return reviewService.createReview(productId, reviewDto, currentUserId);
	}

	@GetMapping(value = "/products/{productId}/reviews")
	public Collection<ReviewDto> getReviews(@PathVariable("productId") Long productId) {
		return reviewService.findByProductId(productId);
	}
}
