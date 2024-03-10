package com.project.lapstore.core.item.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.lapstore.core.item.domain.entity.Item;
import com.project.lapstore.core.item.repository.ItemRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemService {

	private final ItemRepository itemRepository;

	public Optional<Item> findById(Long id) {
		return itemRepository.findById(id);
	}

	public Item registerItem(Item item) {
		return itemRepository.save(item);
	}

	public void delete(Long id) {
		itemRepository.deleteById(id);
	}
}
