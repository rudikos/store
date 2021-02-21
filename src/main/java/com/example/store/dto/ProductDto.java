package com.example.store.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author rudolf.shakhgaldyan on 2/20/2021.
 */
public class ProductDto implements Serializable {

	private static final long serialVersionUID = 7223227000748624947L;

	public final Long id;
	public final String name;
	public final String description;
	public final Double price;

	@JsonCreator
	public ProductDto(@JsonProperty("id") Long id,
					  @JsonProperty("name") String name,
					  @JsonProperty("description") String description,
					  @JsonProperty("price") Double price) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ProductDto)) return false;
		ProductDto that = (ProductDto) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
