package com.example.store.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author rudolf.shakhgaldyan on 2/20/2021.
 */
public class UserDataDto implements Serializable {

	private static final long serialVersionUID = -3407727263849227129L;

	public final Long id;
	public final String username;
	public final CharSequence password;
	public final String firstName;
	public final String lastName;
	public final String email;
	public final boolean isBlocked;
	public final boolean isAdmin;

	@JsonCreator
	public UserDataDto(@JsonProperty("id") Long id,
					   @JsonProperty("username") String username,
					   @JsonProperty("password") CharSequence password,
					   @JsonProperty("firstName") String firstName,
					   @JsonProperty("lastName") String lastName,
					   @JsonProperty("email") String email,
					   @JsonProperty("isBlocked") boolean isBlocked,
					   @JsonProperty("isAdmin") boolean isAdmin) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.isBlocked = isBlocked;
		this.isAdmin = isAdmin;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof UserDataDto)) return false;
		UserDataDto that = (UserDataDto) o;
		return Objects.equals(id, that.id) &&
				Objects.equals(username, that.username);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, username);
	}
}
