package com.project.lapstore.core.item.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.lapstore.core.common.exception.NotFoundException;
import com.project.lapstore.core.item.domain.entity.Item;
import com.project.lapstore.core.item.dto.ItemMapper;
import com.project.lapstore.core.item.dto.request.RegisterItemRequest;
import com.project.lapstore.core.item.dto.response.ItemDetailResponse;
import com.project.lapstore.core.item.exception.ItemErrorCode;
import com.project.lapstore.core.item.repository.ItemRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemService {

	private final ItemRepository itemRepository;

	public Optional<Item> findById(Long id) {
		return itemRepository.findById(id);
	}

	@Transactional
	public Long registerItem(RegisterItemRequest request) {
		Item item = ItemMapper.toItem(request);

		// 태그 저장

		return itemRepository.save(item).getId();
	}

	@Transactional(readOnly = true)
	public ItemDetailResponse getItemDetail(Long id) {
		Item item = getItemById(id);
		return ItemMapper.toItemDetailResponse(item);
	}

	// 수정

	@Transactional
	public void delete(Long id) {
		itemRepository.deleteById(id);
	}

	private Item getItemById(Long id) {
		return itemRepository.findById(id).orElseThrow(
			() -> new NotFoundException(ItemErrorCode.NOT_FOUND_AUCTION));
	}
}
