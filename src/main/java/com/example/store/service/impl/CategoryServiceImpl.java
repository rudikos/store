package com.example.store.service.impl;

import com.example.store.domain.Category;
import com.example.store.exception.ResourceNotFoundException;
import com.example.store.repository.CategoryRepository;
import com.example.store.service.CategoryService;
import org.springframework.stereotype.Service;

/**
 * @author rudolf.shakhgaldyan on 2/21/2021.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

	private final CategoryRepository categoryRepository;

	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public Category loadCategory(Integer categoryId) throws ResourceNotFoundException {
		return categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException(String.format("category with %s id not found", categoryId)));
	}
}
