package com.example.store.audit;

import com.example.store.security.JwtPrincipal;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author rudolf.shakhgaldyan on 2/21/2021.
 */
@Component
public class AuditAwareImpl implements AuditorAware<Long> {

	@Override
	public Optional<Long> getCurrentAuditor() {
		JwtPrincipal principal = (JwtPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return Optional.of(principal.getId());
	}
}
