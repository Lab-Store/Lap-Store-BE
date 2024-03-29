package com.project.lapstore.core.item.dto.response;

import com.project.lapstore.core.item.domain.entity.Brand;

public record ItemDetailResponse(
	Long itemId,
	String name,
	Brand brand
) {
}

