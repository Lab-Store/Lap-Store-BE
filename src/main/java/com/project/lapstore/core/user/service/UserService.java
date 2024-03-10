package com.project.lapstore.core.user.service;

import static com.project.lapstore.core.user.exception.UserErrorCode.*;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.lapstore.core.auth.domain.EncryptHelper;
import com.project.lapstore.core.common.exception.NotFoundException;
import com.project.lapstore.core.common.exception.ValidationException;
import com.project.lapstore.core.user.domain.User;
import com.project.lapstore.core.user.dto.UserMapper;
import com.project.lapstore.core.user.dto.request.JoinUserRequest;
import com.project.lapstore.core.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	private final EncryptHelper encryptHelper;

	private void validateDuplicateEmail(String email) {
		if (userRepository.findByEmail(email).isPresent()) {
			throw new ValidationException(DUPLICATED_EMAIL);
		}
	}

	public User getUserById(Long userId) {
		return userRepository.findById(userId)
			.orElseThrow(() -> new NotFoundException(NOT_FOUND_BY_ID));
	}

	public User getUserByEmail(String email) {
		return userRepository.findByEmail(email)
			.orElseThrow(() -> new NotFoundException(NOT_FOUND_BY_EMAIL));
	}

	@Transactional
	public Long join(JoinUserRequest joinUserRequest) {
		validateDuplicateEmail(joinUserRequest.email());
		User user = UserMapper.toUser(joinUserRequest, encryptHelper);
		return userRepository.save(user).getId();
	}
}
