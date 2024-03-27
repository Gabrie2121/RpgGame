package com.game.rpg.enums;

public enum Rarity {
    Comum("Comum"),
    Incomum("Incomum"),
    Raro("Raro"),
    Epico("Épico"),
    Lendário("Lendário"),
    Mítico("Mítico"),
    Cósmico("Cósmico"),
    Eterno("Eterno"),
    Celestial("Celestial");

    private final String name;

    Rarity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
