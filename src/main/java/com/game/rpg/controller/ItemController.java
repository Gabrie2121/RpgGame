package com.game.rpg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.game.rpg.commom.helper.UpdateHelper;
import com.game.rpg.entity.itens.Item;
import com.game.rpg.service.ItemService;

@RestController
@RequestMapping("/api/items")
public class ItemController {
    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping(value = "/create", consumes = "multipart/form-data")
    public ResponseEntity<String> createItem(@RequestPart("file") MultipartFile file,
            @RequestPart("item") String item) {

        Item newItem = new Item();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            newItem = objectMapper.readValue(item, Item.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        itemService.createItem(newItem, file);
        return ResponseEntity.status(HttpStatus.CREATED).body("Item created successfully");
    }

    @PutMapping("/update/{itemId}")
    public ResponseEntity<String> updateItemField(@PathVariable long itemId,
            @RequestBody UpdateHelper request) {

        itemService.updateItemField(itemId, request.getFieldName(), request.getNewValue());
        return ResponseEntity.ok("Item field updated successfully");
    }

    @GetMapping("/find/{itemId}")
    public ResponseEntity<Item> getItemById(@PathVariable long itemId) {
        Item item = itemService.findById(itemId);
        if (item != null) {
            return ResponseEntity.ok(item);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<Item>> findItemsByFilters(@RequestParam(required = false) String nome,
            @RequestParam(required = false) String descricao,
            @RequestParam(required = false) String elemento,
            @RequestParam(required = false) String raridade,
            @RequestParam(required = false) String tipoDePeca) {
        List<Item> items = itemService.findItemsByFilters(nome, descricao, elemento, raridade, tipoDePeca);
        return ResponseEntity.ok(items);
    }
}
