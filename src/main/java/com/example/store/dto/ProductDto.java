package com.example.store.dto;

import java.io.Serializable;
import java.util.Map;

/**
 * @author rudolf.shakhgaldyan on 2/20/2021.
 */
public class ProductDto implements Serializable {

	private static final long serialVersionUID = 7223227000748624947L;

	public final Long id;
	public final String name;
	public final String description;
	public final Double price;
	public final Map<String, Object> fields;

	public ProductDto(Long id, String name, String description, Double price, Map<String, Object> fields) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.fields = fields;
	}
}
