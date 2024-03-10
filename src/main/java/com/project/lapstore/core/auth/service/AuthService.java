package com.project.lapstore.core.auth.service;

import static com.project.lapstore.core.auth.exception.AuthErrorCode.*;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.lapstore.core.auth.domain.Auth;
import com.project.lapstore.core.auth.domain.BlacklistToken;
import com.project.lapstore.core.auth.domain.EncryptHelper;
import com.project.lapstore.core.auth.dto.request.AuthRequest;
import com.project.lapstore.core.auth.dto.response.AuthResponse;
import com.project.lapstore.core.auth.exception.AuthException;
import com.project.lapstore.core.auth.repository.AuthRepository;
import com.project.lapstore.core.auth.repository.BlacklistTokenRepository;
import com.project.lapstore.core.common.exception.NotFoundException;
import com.project.lapstore.core.user.domain.User;
import com.project.lapstore.core.user.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

	private final UserService userService;
	private final JwtProvider jwtProvider;
	private final AuthRepository authRepository;
	private final EncryptHelper encryptHelper;
	private final BlacklistTokenRepository blacklistTokenRepository;

	private Auth getAuthByRefreshToken(String refreshToken) {
		return authRepository.findByRefreshToken(refreshToken)
			.orElseThrow(() -> new NotFoundException(NOT_FOUND_REFRESH_TOKEN));
	}

	private AuthResponse saveAuth(Long userId) {
		String refreshToken = jwtProvider.createRefreshToken(userId);
		String accessToken = jwtProvider.createAccessToken(userId);
		Optional<Auth> auth = authRepository.findByUserId(userId);

		auth.ifPresentOrElse(
			existingAuth -> authRepository.updateRefreshToken(existingAuth.getId(), refreshToken),
			() -> {
				Auth newAuth = Auth.builder()
					.userId(userId)
					.refreshToken(refreshToken)
					.build();

				authRepository.save(newAuth);
			}
		);

		return AuthResponse.builder()
			.refreshToken(refreshToken)
			.accessToken(accessToken)
			.build();
	}

	@Transactional
	public AuthResponse login(AuthRequest authRequest) {
		Long userId = userService.getUserByEmail(authRequest.email()).getId();
		AuthResponse authResponse = saveAuth(userId);
		String plainPassword = authRequest.password();
		String hashedPassword = userService.getUserById(userId).getPassword();

		if (encryptHelper.isMatch(plainPassword, hashedPassword)) {
			return authResponse;
		}
		throw new NotFoundException(FAILED_LOGIN_BY_ANYTHING);
	}

	@Transactional
	public void logout(User user) {

		authRepository.findByUserId(user.getId()).ifPresentOrElse(
			auth ->
				blacklistTokenRepository.save(
					BlacklistToken.builder()
						.refreshToken(auth.getRefreshToken())
						.build()),
			() -> {
				throw new NotFoundException(NOT_FOUND_USER_ID);
			}
		);
	}

	public String createAccessTokenByRefreshToken(String refreshToken) {
		boolean isBlacklisted = blacklistTokenRepository.existsByRefreshToken(refreshToken);
		if (isBlacklisted) {
			throw new AuthException(BLACKLISTED_TOKEN);
		}

		Auth auth = getAuthByRefreshToken(refreshToken);
		Long userId = userService.getUserById(auth.getUserId()).getId();
		return jwtProvider.createAccessToken(userId);
	}

}
