package com.example.store.repository;

import com.example.store.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author rudolf.shakhgaldyan on 2/20/2021.
 */
public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
