package com.example.store.service.impl;

import com.example.store.domain.Category;
import com.example.store.domain.Product;
import com.example.store.dto.ProductDto;
import com.example.store.exception.ResourceNotFoundException;
import com.example.store.repository.CategoryRepository;
import com.example.store.repository.ProductRepository;
import com.example.store.service.ProductService;
import com.google.common.base.Preconditions;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author rudolf.shakhgaldyan on 2/20/2021.
 */
@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;

	public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}

	@Override
	public List<Product> getProductsByCategory(Integer categoryId) {
		return productRepository.findByCategory(categoryId);
	}

	@Override
	public void createProduct(ProductDto productDto, Integer categoryId) throws ResourceNotFoundException {
		categoryRepository.findById(categoryId).map(category -> {
			Product product = new Product(category, productDto.name, productDto.description, productDto.price, productDto.fields);
			return productRepository.save(product);
		}).orElseThrow(() -> new ResourceNotFoundException(String.format("category with %s id not found", categoryId)));
	}

	@Override
	public void updateProduct(ProductDto productDto, Integer categoryId) throws ResourceNotFoundException {
		Preconditions.checkNotNull(productDto.id, "product id should be provided");

		Category category = categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException((String.format("category with %s id not found", categoryId))));

		Product product = productRepository.findById(productDto.id)
				.orElseThrow(() -> new ResourceNotFoundException((String.format("product with %s id not found", categoryId))));
		product.setCategory(category);
		product.setName(productDto.name);
		product.setDescription(productDto.description);
		product.setPrice(productDto.price);
		product.setFields(productDto.fields);
		productRepository.save(product);

	}

	@Override
	public void deleteProduct(Long productId, Integer categoryId) {
		productRepository.findByIdAndCategory(productId, categoryId).ifPresent(productRepository::delete);
	}

}
