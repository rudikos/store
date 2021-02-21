package com.example.store.service;

/**
 * @author rudolf.shakhgaldyan on 2/21/2021.
 */
public interface CurrentUserProvider {
	Long getCurrentUserId();

	Boolean isAdminUser();
}
