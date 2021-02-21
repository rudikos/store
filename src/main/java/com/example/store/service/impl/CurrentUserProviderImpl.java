package com.example.store.service.impl;

import com.example.store.security.JwtPrincipal;
import com.example.store.service.CurrentUserProvider;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * @author rudolf.shakhgaldyan on 2/21/2021.
 */
@Component
public class CurrentUserProviderImpl implements CurrentUserProvider {
	@Override
	public Long getCurrentUserId() {
		JwtPrincipal jwtPrincipal = (JwtPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return jwtPrincipal.getId();
	}

	@Override
	public Boolean isAdminUser() {
		JwtPrincipal jwtPrincipal = (JwtPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return jwtPrincipal.getAdmin();
	}
}
