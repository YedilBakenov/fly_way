package com.example.springSecurityG124.controller;

import com.example.springSecurityG124.model.Item;
import com.example.springSecurityG124.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping(value = "/get-items")
    public List<Item> getAll(){
        return itemService.getAllItems();
    }

    @PostMapping(value = "/add-item")
    public Item addItem(@RequestBody Item item){
        return itemService.addItem(item);
    }

    @PutMapping(value = "/update-item")
    public Item updateItem(@RequestBody Item item){
        return itemService.updateItem(item);
    }

    @GetMapping(value = "/get-item/{id}")
    public Item getItemById(@PathVariable int id){
        return itemService.getById(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public Item deleteItem(@PathVariable int id){
        return itemService.deleteItem(id);
    }

    @PostMapping(value = "/add-item2")
    public ResponseEntity<Void> addItem2(@RequestBody Item item){
       itemService.addItem(item);
       return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/add-item3")
    public ResponseEntity<String> addItem3(@RequestBody Item item){
        itemService.addItem(item);
        System.out.println(HttpStatus.CREATED);
        return ResponseEntity.status(HttpStatus.CREATED).body("We added new item");
    }
}
