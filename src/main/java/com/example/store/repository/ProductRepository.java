package com.example.store.repository;

import com.example.store.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

/**
 * @author rudolf.shakhgaldyan on 2/20/2021.
 */
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
	List<Product> findByCategory(Integer categoryId);

	Optional<Product> findByIdAndCategory(Long id, Integer categoryId);
}
