package com.project.lapstore.item.application;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.lapstore.item.domain.entity.Item;
import com.project.lapstore.item.domain.repository.ItemRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemService {

	private final ItemRepository itemRepository;

	public Optional<Item> findById(Long id) {
		return itemRepository.findById(id);
	}

	public Long save(Item item) {
		return itemRepository.save(item);
	}

	public void delete(Long id) {
		itemRepository.deleteById(id);
	}
}
