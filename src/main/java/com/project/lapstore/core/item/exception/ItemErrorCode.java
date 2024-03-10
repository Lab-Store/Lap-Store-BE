package com.project.lapstore.core.item.exception;

import com.project.lapstore.core.common.exception.ErrorCode;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ItemErrorCode implements ErrorCode {

	private final String message;
	private final String code;
}
