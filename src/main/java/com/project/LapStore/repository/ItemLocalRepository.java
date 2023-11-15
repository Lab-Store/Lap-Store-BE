package com.project.LapStore.repository;

import com.project.LapStore.domain.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ItemLocalRepository implements ItemRepository {

    private final List<Item> storage = new ArrayList<>();

    @Override
    public Item findById(Long id) {
        storage.get(id);
        return null;
    }

    @Override
    public List<Item> findAll() {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Item save(Item item) {
        return null;
    }
}
