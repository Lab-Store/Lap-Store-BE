package com.project.lapstore.core.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.lapstore.core.auth.domain.BlacklistToken;

public interface BlacklistTokenRepository extends JpaRepository<BlacklistToken, Long> {
	boolean existsByRefreshToken(String refreshToken);
}
