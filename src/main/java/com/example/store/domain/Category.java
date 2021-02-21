package com.example.store.domain;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author rudolf.shakhgaldyan on 2/20/2021.
 */
@Entity
@Table(name = "categories")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "parent_category")
	private Integer parentCategoryId;

	@Column(name = "name", nullable = false)
	private String name;

	@OnDelete(action = OnDeleteAction.CASCADE)
	@OneToMany(mappedBy = "category")
	@OrderBy("name")
	private List<Product> products = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public Integer getParentCategoryId() {
		return parentCategoryId;
	}

	public String getName() {
		return name;
	}

	public List<Product> getProducts() {
		return products;
	}
}
