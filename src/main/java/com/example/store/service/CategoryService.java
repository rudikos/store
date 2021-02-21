package com.example.store.service;

import com.example.store.domain.Category;
import com.example.store.exception.ResourceNotFoundException;

/**
 * @author rudolf.shakhgaldyan on 2/21/2021.
 */
public interface CategoryService {
	Category loadCategory(Integer categoryId) throws ResourceNotFoundException;
}
