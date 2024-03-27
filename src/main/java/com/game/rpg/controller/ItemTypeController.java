package com.game.rpg.controller;

import com.game.rpg.enums.ItemType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/enum/item-types")
public class ItemTypeController {

    @GetMapping("/all")
    public ResponseEntity<List<String>> getAllItemTypes() {
        List<String> itemTypes = Arrays.stream(ItemType.values())
                .map(ItemType::getName)
                .collect(Collectors.toList());
        return new ResponseEntity<>(itemTypes, HttpStatus.OK);
    }
}
