package com.project.lapstore.core.user.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.lapstore.core.auth.domain.EncryptHelper;
import com.project.lapstore.core.common.exception.NotFoundException;
import com.project.lapstore.core.common.exception.ValidationException;
import com.project.lapstore.core.user.domain.User;
import com.project.lapstore.core.user.dto.UserMapper;
import com.project.lapstore.core.user.dto.request.EmailAvailibilityRequest;
import com.project.lapstore.core.user.dto.request.JoinUserRequest;
import com.project.lapstore.core.user.dto.response.EmailAvailabilityResponse;
import com.project.lapstore.core.user.exception.UserErrorCode;
import com.project.lapstore.core.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	private final EncryptHelper encryptHelper;

	private void validateDuplicateEmail(String email) {
		if (userRepository.findByEmail(email).isPresent()) {
			throw new ValidationException(UserErrorCode.DUPLICATED_EMAIL);
		}
	}

	public User getUserById(Long userId) {
		return userRepository.findById(userId)
			.orElseThrow(() -> new NotFoundException(UserErrorCode.NOT_FOUND_USER));
	}

	public User getUserByEmail(String email) {
		return userRepository.findByEmail(email)
			.orElseThrow(() -> new NotFoundException(UserErrorCode.NOT_FOUND_BY_EMAIL));
	}

	@Transactional
	public Long join(JoinUserRequest request) {
		validateDuplicateEmail(request.email());
		User user = UserMapper.toUser(request, encryptHelper);
		User savedUser = userRepository.save(user);    // 저장된 유저 확인

		return savedUser.getId();
	}

	public EmailAvailabilityResponse isEmailAvailable(EmailAvailibilityRequest request) {
		boolean isEmailAvailable = userRepository.findByEmail(request.email()).isEmpty();
		return EmailAvailabilityResponse.from(isEmailAvailable);
	}

}
