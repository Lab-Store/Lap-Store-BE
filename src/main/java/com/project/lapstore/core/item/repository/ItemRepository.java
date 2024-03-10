package com.project.lapstore.core.item.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.lapstore.core.item.domain.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

	Optional<Item> findByName(String name);

}
