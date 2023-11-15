package com.project.LapStore.repository;

import com.project.LapStore.domain.Item;

import java.util.List;

public interface ItemRepository {

    Item findById(Long id);

    List<Item> findAll();

    void deleteById(Long id);

    Item save(Item item);
}
