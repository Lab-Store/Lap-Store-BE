package com.project.lapstore.core.item.domain.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Category {

	DESIGN("디자인노트북"),
	DEVELOPER("개발자노트북"),
	OFFICE("사무용노트북"),
	GAMING("게이밍노트북");

	private final String name;
}
