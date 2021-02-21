package com.example.store.service;

import com.example.store.domain.Product;
import com.example.store.dto.PageDataDto;
import com.example.store.dto.ProductDto;
import com.example.store.exception.ResourceNotFoundException;

import java.util.Collection;

/**
 * @author rudolf.shakhgaldyan on 2/20/2021.
 */
public interface ProductService {
	Product getProduct(Long id) throws ResourceNotFoundException;

	PageDataDto<ProductDto> getProducts(Integer page, Integer pageSize, String sortField, String sortOrder, String search);

	Collection<ProductDto> getCategoryProducts(Integer categoryId) throws ResourceNotFoundException;

	void createProducts(Collection<ProductDto> productDtos, Integer categoryId) throws ResourceNotFoundException;

	ProductDto updateProduct(ProductDto productDto, Long productId) throws ResourceNotFoundException;

	void deleteProduct(Long productId) throws ResourceNotFoundException;
}
