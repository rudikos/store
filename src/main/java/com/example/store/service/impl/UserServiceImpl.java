package com.example.store.service.impl;

import com.example.store.domain.User;
import com.example.store.dto.UserDataDto;
import com.example.store.exception.ResourceNotFoundException;
import com.example.store.repository.UserRepository;
import com.example.store.security.AppUserDetails;
import com.example.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author rudolf.shakhgaldyan on 2/20/2021.
 */
@Service
@Qualifier("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {

	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepository = userRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	public User getUser(Long id) throws ResourceNotFoundException {
		return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("user with %s id not found", id)));
	}

	@Override
	public User updateUser(UserDataDto userDataDto, Long id) throws ResourceNotFoundException {
		User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("user with %s id not found", id)));
		user.setAdmin(userDataDto.isAdmin);
		user.setBlocked(userDataDto.isBlocked);
		user.setEmail(userDataDto.email);
		user.setFirstName(userDataDto.firstName);
		user.setLastName(userDataDto.lastName);
		userRepository.save(user);
		return user;
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public User saveUser(UserDataDto userDto) {
		return userRepository.save(new User(userDto.id, userDto.username, bCryptPasswordEncoder.encode(userDto.password), userDto.firstName, userDto.lastName,
				userDto.email, userDto.isAdmin, false));

	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		return new AppUserDetails(user);
	}


}
