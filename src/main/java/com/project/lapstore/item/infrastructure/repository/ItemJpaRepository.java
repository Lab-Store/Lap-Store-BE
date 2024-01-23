package com.project.lapstore.item.infrastructure.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.lapstore.item.domain.entity.Item;

public interface ItemJpaRepository extends JpaRepository<Item, Long> {

	Optional<Item> findByName(String name);

}
