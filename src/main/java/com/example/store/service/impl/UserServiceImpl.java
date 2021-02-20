package com.example.store.service.impl;

import com.example.store.domain.User;
import com.example.store.domain.UserIdentity;
import com.example.store.dto.UserDataDto;
import com.example.store.repository.UserIdentityRepository;
import com.example.store.repository.UserRepository;
import com.example.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static java.util.Collections.emptyList;

/**
 * @author rudolf.shakhgaldyan on 2/20/2021.
 */
@Service
@Qualifier("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService{

	private final UserRepository userRepository;
	private final UserIdentityRepository userIdentityRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public UserServiceImpl(UserRepository userRepository, UserIdentityRepository userIdentityRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepository = userRepository;
		this.userIdentityRepository = userIdentityRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	@Transactional
	public void saveUser(UserDataDto userDataDto) {
		User savedUser = userRepository.save(new User(userDataDto.id, userDataDto.firstName, userDataDto.lastName, userDataDto.lastName, userDataDto.isAdmin));
		userIdentityRepository.save(new UserIdentity(savedUser.getId(), userDataDto.username, bCryptPasswordEncoder.encode(userDataDto.password),
				userDataDto.isBlocked));
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserIdentity userIdentity = userIdentityRepository.findByUsername(username);
		if (userIdentity == null) {
			throw new UsernameNotFoundException(username);
		}
		return new org.springframework.security.core.userdetails.User(userIdentity.getUsername(), userIdentity.getPassword(), emptyList());
	}
}
