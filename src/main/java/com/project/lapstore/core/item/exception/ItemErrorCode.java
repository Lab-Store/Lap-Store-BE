package com.project.lapstore.core.item.exception;

import com.project.lapstore.core.common.exception.ErrorCode;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ItemErrorCode implements ErrorCode {

	NOT_FOUND_AUCTION("해당 아이디의 경매가 존재하지 않습니다.", "IT_000");

	private final String message;
	private final String code;
}
