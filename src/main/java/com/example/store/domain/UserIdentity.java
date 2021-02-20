package com.example.store.domain;

import javax.persistence.*;

/**
 * @author rudolf.shakhgaldyan on 2/20/2021.
 */
@Entity
@Table(name = "user_identities")
public class UserIdentity {
	@Id
	@GeneratedValue(generator = "user_identities_seq_gen", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "user_identities_seq_gen", sequenceName = "user_identities_id_seq", allocationSize = 1)
	private Long id;

	@Basic
	private Long userId;

	@Basic
	private String username;

	@Basic
	@Column(name = "hashedPassword")
	private String password;

	@Basic
	private Boolean isBlocked;

	public UserIdentity() {
	}

	public UserIdentity(Long userId, String username, String password, Boolean isBlocked) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.isBlocked = isBlocked;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getBlocked() {
		return isBlocked;
	}

	public void setBlocked(Boolean blocked) {
		isBlocked = blocked;
	}
}
