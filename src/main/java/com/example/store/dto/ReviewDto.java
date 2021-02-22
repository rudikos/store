package com.example.store.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.io.Serializable;

/**
 * @author rudolf.shakhgaldyan on 2/21/2021.
 */
public class ReviewDto implements Serializable {
	private static final long serialVersionUID = 5705062173672993223L;

	public int rate;
	public String comment;

	public Long lastModifiedBy;
	public long lastModifiedDate;

	public ReviewDto(String comment, int rate, Long lastModifiedBy, long lastModifiedDate) {
		this.rate = rate;
		this.comment = comment;
		this.lastModifiedBy = lastModifiedBy;
		this.lastModifiedDate = lastModifiedDate;
	}

	public ReviewDto(int rate, String comment) {
		this.rate = rate;
		this.comment = comment;
	}

	public ReviewDto() {
	}
}
