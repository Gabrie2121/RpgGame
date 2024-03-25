package com.game.rpg.enums;

public enum Rarity {
    COMMON("Comum", 35),
    UNCOMMON("Incomum", 20),
    RARE("Raro", 12),
    EPIC("Épico", 8),
    LEGENDARY("Lendário", 5),
    MYTHICAL("Mítico", 3),
    COSMIC("Cósmico", 1),
    ETHEREAL("Eterno", 0.3),
    CELESTIAL("Celestial", 0.1);

    private final String name;
    private final double chance;

    Rarity(String name, double chance) {
        this.name = name;
        this.chance = chance;
    }

    public String getName() {
        return name;
    }

    public double getChance() {
        return chance;
    }
}
