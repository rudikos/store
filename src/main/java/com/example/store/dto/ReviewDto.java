package com.example.store.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.io.Serializable;

/**
 * @author rudolf.shakhgaldyan on 2/21/2021.
 */
public class ReviewDto implements Serializable {
	private static final long serialVersionUID = 5705062173672993223L;

	public final int rate;
	public final String comment;

	public final Long lastModifiedBy;
	public final long lastModifiedDate;

	@JsonCreator

	public ReviewDto(int rate, String comment, Long lastModifiedBy, long lastModifiedDate) {
		this.rate = rate;
		this.comment = comment;
		this.lastModifiedBy = lastModifiedBy;
		this.lastModifiedDate = lastModifiedDate;
	}
}
