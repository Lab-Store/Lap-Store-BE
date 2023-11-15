package com.project.LapStore.controller;

import com.project.LapStore.domain.Item;
import com.project.LapStore.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public List<Item> getAllItems() {
        return itemService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id) {
        return itemService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Item createItem(@RequestBody Item item) {
        return itemService.save(item);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Long id, @RequestBody Item itemDetails) {
        return itemService.findById(id)
                .map(item -> {
                    item.setName(itemDetails.getName());
                    item.setBrand(itemDetails.getBrand());
                    // ... 다른 필드들 업데이트
                    return ResponseEntity.ok(itemService.save(item));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable Long id) {
        return itemService.findById(id)
                .map(item -> {
                    itemService.delete(id);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
