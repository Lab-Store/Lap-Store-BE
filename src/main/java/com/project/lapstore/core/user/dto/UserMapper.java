package com.project.lapstore.core.user.dto;

import static lombok.AccessLevel.*;

import com.project.lapstore.core.auth.domain.EncryptHelper;
import com.project.lapstore.core.user.domain.User;
import com.project.lapstore.core.user.dto.request.JoinUserRequest;

import lombok.NoArgsConstructor;

@NoArgsConstructor(access = PRIVATE)
public class UserMapper {

	public static User toUser(JoinUserRequest request, EncryptHelper encryptHelper) {
		String password = request.password();
		String encryptedPassword = encryptHelper.encrypt(password);

		return User.of(
			request.email(),
			encryptedPassword,
			request.name()
		);
	}
}
