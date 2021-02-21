package com.example.store.security;

/**
 * @author rudolf.shakhgaldyan on 2/21/2021.
 */
public class JwtPrincipal {
	private final Long id;
	private final Boolean isAdmin;

	public JwtPrincipal(Long id, boolean isAdmin) {
		this.id = id;
		this.isAdmin = isAdmin;
	}

	public Long getId() {
		return id;
	}

	public Boolean getAdmin() {
		return isAdmin;
	}
}
