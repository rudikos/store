package com.example.store.endpoint;

import com.example.store.service.CurrentUserProvider;
import org.springframework.security.access.AccessDeniedException;

/**
 * @author rudolf.shakhgaldyan on 2/21/2021.
 */
public abstract class BaseController {
	protected final CurrentUserProvider currentUserProvider;

	public BaseController(CurrentUserProvider currentUserProvider) {
		this.currentUserProvider = currentUserProvider;
	}

	protected void checkAccess() {
		if (!currentUserProvider.isAdminUser()) {
			throw new AccessDeniedException("only admin user can perform this action");
		}
	}
}
