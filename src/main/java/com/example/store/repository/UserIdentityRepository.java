package com.example.store.repository;

import com.example.store.domain.UserIdentity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author rudolf.shakhgaldyan on 2/20/2021.
 */
public interface UserIdentityRepository extends JpaRepository<UserIdentity, Long> {
	UserIdentity findByUsername(String username);
}
