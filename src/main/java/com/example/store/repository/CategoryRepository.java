package com.example.store.repository;

import com.example.store.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author rudolf.shakhgaldyan on 2/20/2021.
 */
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
