package com.example.store.service;

import com.example.store.domain.User;
import com.example.store.dto.UserDataDto;
import com.example.store.exception.ResourceNotFoundException;

/**
 * @author rudolf.shakhgaldyan on 2/20/2021.
 */
public interface UserService {
	User saveUser(UserDataDto userDataDto);

	User getUser(Long id) throws ResourceNotFoundException;

	User updateUser(UserDataDto userDataDto, Long id) throws ResourceNotFoundException;

	void deleteUser(Long id);
}
