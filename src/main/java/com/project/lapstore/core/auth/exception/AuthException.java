package com.project.lapstore.core.auth.exception;

import com.project.lapstore.core.common.exception.ErrorCode;

import lombok.Getter;

@Getter
public class AuthException extends RuntimeException {

	private final String code;

	public AuthException(ErrorCode errorCode) {
		super(errorCode.getMessage());
		this.code = errorCode.getCode();
	}
}
