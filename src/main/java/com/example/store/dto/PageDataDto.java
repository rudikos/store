package com.example.store.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Nonnull;
import java.io.Serializable;
import java.util.List;

public class PageDataDto<T> implements Serializable {
	private static final long serialVersionUID = -9196516035701961686L;

	@Nonnull
	public final List<T> data;

	@Nonnull
	public final long count;

	@JsonCreator
	public PageDataDto(@JsonProperty("data") @Nonnull List<T> data, @JsonProperty("count") @Nonnull long count) {
		this.data = data;
		this.count = count;
	}
}
