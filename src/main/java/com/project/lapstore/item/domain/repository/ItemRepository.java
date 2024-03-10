package com.project.lapstore.item.domain.repository;

import java.util.Optional;

import com.project.lapstore.item.domain.entity.Item;

public interface ItemRepository {

	Optional<Item> findById(Long id);

	Optional<Item> findByName(String name);

	Long save(Item item);

	void deleteById(Long id);
}
