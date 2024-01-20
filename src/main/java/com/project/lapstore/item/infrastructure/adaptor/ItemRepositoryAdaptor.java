package com.project.lapstore.item.infrastructure.adaptor;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.project.lapstore.item.domain.entity.Item;
import com.project.lapstore.item.domain.repository.ItemRepository;
import com.project.lapstore.item.infrastructure.repository.ItemJpaRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ItemRepositoryAdaptor implements ItemRepository {

	private final ItemJpaRepository itemJpaRepository;

	@Override
	public Optional<Item> findById(Long id) {
		return itemJpaRepository.findById(id);
	}

	@Override
	public Optional<Item> findByName(String name) {
		return itemJpaRepository.findByName(name);
	}

	@Override
	public Long save(Item item) {
		return itemJpaRepository.save(item).getId();
	}

	@Override
	public void deleteById(Long id) {
		itemJpaRepository.deleteById(id);
	}
}
