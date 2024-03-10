package com.project.lapstore.core.user.dto.request;

import static lombok.AccessLevel.*;

import lombok.Builder;

@Builder(access = PRIVATE)
public record JoinUserRequest(

	String email,
	String password,
	String name
) {
	public static JoinUserRequest of(String email, String password, String name) {
		return JoinUserRequest.builder()
			.email(email)
			.password(password)
			.name(name)
			.build();
	}
}
