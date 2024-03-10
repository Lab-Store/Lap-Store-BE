package com.project.lapstore.core.auth.dto.response;

import lombok.Builder;

@Builder
public record LoginSimpleResponse(

	String accessToken
) {
	public static LoginSimpleResponse from(String accessToken) {
		return LoginSimpleResponse.builder()
			.accessToken(accessToken)
			.build();
	}
}
