package com.example.store.endpoint;

import com.example.store.dto.UserDataDto;
import com.example.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rudolf.shakhgaldyan on 2/20/2021.
 */
@RestController
@RequestMapping("users")
public class UserController {

	private final UserService userService;


	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/")
	public void create(@RequestBody UserDataDto userDataDto) {
		userService.saveUser(userDataDto);
	}
}
