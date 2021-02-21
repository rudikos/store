package com.example.store.security;

import com.example.store.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

/**
 * @author rudolf.shakhgaldyan on 2/21/2021.
 */
public class AppUserDetails implements UserDetails {

	private final User user;

	public AppUserDetails(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.emptyList();
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return !user.getBlocked();
	}

	@Override
	public boolean isAccountNonLocked() {
		return !user.getBlocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return !user.getBlocked();
	}

	@Override
	public boolean isEnabled() {
		return !user.getBlocked();
	}
}
