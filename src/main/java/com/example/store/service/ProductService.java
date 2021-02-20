package com.example.store.service;

import com.example.store.domain.Product;
import com.example.store.dto.ProductDto;
import com.example.store.exception.ResourceNotFoundException;

import java.util.List;

/**
 * @author rudolf.shakhgaldyan on 2/20/2021.
 */
public interface ProductService {
	List<Product> getProductsByCategory(Integer categoryId);
	void createProduct(ProductDto productDto, Integer categoryId) throws ResourceNotFoundException;
	void updateProduct(ProductDto productDto, Integer categoryId) throws ResourceNotFoundException;
	void deleteProduct(Long productId, Integer categoryId);
}
