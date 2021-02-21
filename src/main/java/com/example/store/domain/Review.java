package com.example.store.domain;

import javax.persistence.*;

/**
 * @author rudolf.shakhgaldyan on 2/20/2021.
 */
@Entity
@Table(name = "reviews")
public class Review extends Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@Column(name = "rate")
	private int rate;

	@Column(name = "comment")
	private String comment;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	public Review() {
	}

	public Review(int rate, String comment, User user, Product product) {
		this.rate = rate;
		this.comment = comment;
		this.user = user;
		this.product = product;
	}

	public int getRate() {
		return rate;
	}

	public String getComment() {
		return comment;
	}
}
