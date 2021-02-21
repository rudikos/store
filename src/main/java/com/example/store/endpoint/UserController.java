package com.example.store.endpoint;

import com.example.store.domain.User;
import com.example.store.dto.UserDataDto;
import com.example.store.exception.ResourceNotFoundException;
import com.example.store.service.CurrentUserProvider;
import com.example.store.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author rudolf.shakhgaldyan on 2/20/2021.
 */
@RestController
@RequestMapping("users")
public class UserController extends BaseController {

	private final UserService userService;

	public UserController(UserService userService, CurrentUserProvider currentUserProvider) {
		super(currentUserProvider);
		this.userService = userService;
	}

	@GetMapping("/{userId}")
	public UserDataDto getUser(@PathVariable("userId") Long userId) throws ResourceNotFoundException {
		return toDto(userService.getUser(userId));
	}

	@PostMapping
	public UserDataDto create(@RequestBody UserDataDto userDataDto) {
		return toDto(userService.saveUser(userDataDto));
	}

	@PutMapping("/{userId}")
	public UserDataDto update(@RequestBody UserDataDto userDataDto, @PathVariable("userId") Long userId) throws ResourceNotFoundException {
		checkAccess();
		return toDto(userService.updateUser(userDataDto, userId));
	}


	@DeleteMapping("/{userId}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable("userId") Long userId) {
		checkAccess();
		userService.deleteUser(userId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	private UserDataDto toDto(User user) {
		return new UserDataDto(user.getId(), user.getUsername(), "dummy", user.getFirstName(), user.getLastName(), user.getEmail(), user.getBlocked(), user.getAdmin());
	}
}
