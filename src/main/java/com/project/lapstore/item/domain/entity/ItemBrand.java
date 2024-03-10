package com.project.lapstore.item.domain.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ItemBrand {

	APPLE("APPLE"),
	SAMSUNG("SAMSUNG"),
	LG("LG"),
	LENOVO("LENOVO"),
	ASUS("ASUS");

	private final String name;
}
