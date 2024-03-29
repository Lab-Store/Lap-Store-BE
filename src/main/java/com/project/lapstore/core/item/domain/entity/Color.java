package com.project.lapstore.core.item.domain.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Color {

	BLACK("블랙"),
	GREY("그레이"),
	SILVER("실버"),
	WHITE("화이트"),
	NAVY("네이비");

	private final String name;
}
