package com.game.rpg.controller;

import com.game.rpg.enums.Elements;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/enum/elements")
public class ElementsController {

    @GetMapping("/all")
    public ResponseEntity<List<String>> getAllElements() {
        List<String> elements = Arrays.stream(Elements.values())
                .map(Elements::getName)
                .collect(Collectors.toList());
        return new ResponseEntity<>(elements, HttpStatus.OK);
    }
}
