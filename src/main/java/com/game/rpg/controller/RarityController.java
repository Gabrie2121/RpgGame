package com.game.rpg.controller;

import com.game.rpg.enums.Rarity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/enum/rarities")
public class RarityController {

    @GetMapping("/all")
    public ResponseEntity<List<String>> getAllRarities() {
        List<String> rarities = Arrays.stream(Rarity.values())
                .map(rarity -> rarity.getName())
                .collect(Collectors.toList());
        return new ResponseEntity<>(rarities, HttpStatus.OK);
    }
}
