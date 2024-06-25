package com.example.springSecurityG124.service;


import com.example.springSecurityG124.dto.ItemDTO;
import com.example.springSecurityG124.mapper.ItemMapper;
import com.example.springSecurityG124.model.Item;
import com.example.springSecurityG124.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    public List<ItemDTO> getAllItems(){
        return itemMapper.toListItemDTO(itemRepository.findAll());
    }

    public ItemDTO addItem(ItemDTO item){
        Item item1 = itemMapper.toItem(item);
        ItemDTO itemDTO =  itemMapper.toItemDTO(item1);
        itemRepository.save(item1);
        return itemDTO;
    }

    public ItemDTO updateItem(ItemDTO item) {

        Item item2 = itemMapper.toItem(item);
        item2.setId(item.getId());
        item2.setName(item.getItemName());
        item2.setUpdatedAt(item.getUpdatedAt());
        item2.setDescription(item.getDescription());
        item2.setPrice(item.getPrice());

        ItemDTO itemDTO = itemMapper.toItemDTO(item2);

        itemRepository.save(item2);

        return itemDTO;
    }

    public ItemDTO getById(int id) {
        return itemMapper.toItemDTO(itemRepository.findById(id).orElse(null));
    }

    public ItemDTO deleteItem(int id) {
        ItemDTO item = getById(id);

        itemRepository.deleteById(id);
        return item;
    }
}
