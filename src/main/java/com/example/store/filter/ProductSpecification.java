package com.example.store.filter;

import com.example.store.domain.Product;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Objects;

public class ProductSpecification implements Specification<Product> {

	private SearchCriteria criteria;

	public ProductSpecification(SearchCriteria criteria) {
		this.criteria = criteria;
	}

	@Override
	public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

		switch (Objects.requireNonNull(SearchOperator.getSimpleOperation(criteria.getOperation()))) {
			case GREATER_THAN:
				return builder.greaterThan(root.get(criteria.getKey()), criteria.getValue().toString());
			case LESS_THAN:
				return builder.lessThan(root.get(criteria.getKey()), criteria.getValue().toString());
			case EQUALITY:
			default:
				return builder.equal(root.get(criteria.getKey()), criteria.getValue());
		}
	}
}
