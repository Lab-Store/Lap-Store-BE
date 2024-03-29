package com.project.lapstore.core.item.dto;

import static lombok.AccessLevel.*;

import com.project.lapstore.core.item.domain.entity.Item;
import com.project.lapstore.core.item.dto.request.RegisterItemRequest;
import com.project.lapstore.core.item.dto.response.ItemDetailResponse;

import lombok.NoArgsConstructor;

@NoArgsConstructor(access = PRIVATE)
public class ItemMapper {

	public static Item toItem(RegisterItemRequest request) {
		return Item.of(
			request.name(),
			request.brand(),
			request.category()
		);
	}

	public static ItemDetailResponse toItemDetailResponse(Item item) {
		return new ItemDetailResponse(item.getId(), item.getName(), item.getBrand());
	}
}
