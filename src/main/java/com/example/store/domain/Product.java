package com.example.store.domain;

import com.example.store.converter.MapConverter;

import javax.persistence.*;
import java.util.Map;

/**
 * @author rudolf.shakhgaldyan on 2/20/2021.
 */
@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="category_id", nullable=false)
	private Category category;

	@Column(name = "name", nullable=false)
	private String name;

	@Column(name = "description", nullable=false)
	private String description;

	@Column(name = "price", nullable=false)
	private Double price;

	@Transient
	@Convert(converter = MapConverter.class)
	private Map<String, Object> fields;

	public Product() {
	}

	public Product(Category category, String name, String description, Double price, Map<String, Object> fields) {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Map<String, Object> getFields() {
		return fields;
	}

	public void setFields(Map<String, Object> fields) {
		this.fields = fields;
	}
}
