package com.project.lapstore.core.item.domain.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TagType {

	DEVELOPER("개발자노트북"),
	OFFICE("사무용노트북"),
	GAMING("게이밍노트북");

	private final String name;
}
