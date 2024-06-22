package com.example.springSecurityG124.service;


import com.example.springSecurityG124.model.Item;
import com.example.springSecurityG124.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public List<Item> getAllItems(){
        return itemRepository.findAll();
    }

    public Item addItem(Item item){
        return itemRepository.save(item);
    }

    public Item updateItem(Item item) {
        Item item1 = itemRepository.findById(item.getId()).orElse(null);

        item1.setName(item.getName());
        item1.setDescription(item.getDescription());
        item1.setPrice(item.getPrice());
        item1.getUpdatedAt();
        return itemRepository.save(item1);
    }

    public Item getById(int id) {
        return itemRepository.findById(id).orElse(null);
    }

    public Item deleteItem(int id) {
        Item item = getById(id);
        itemRepository.deleteById(id);
        return item;
    }
}
