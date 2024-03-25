package com.game.rpg.enums;

public enum ReforgWeapons {
    DRAGONFURY("Dragonfury", 15),
    VOIDBLADE("Voidblade", 12),
    THUNDERSTRIKE("Thunderstrike", 12),
    CRITICAL("Critical", 10),
    FROSTBITE("Frostbite", 10),
    FLAMING("Flaming", 10),
    LUCKY("Lucky", 8),
    SUNSLAYER("Sunslayer", 8),
    SHARPENED("Sharpened", 7),
    SWIFT("Swift", 5),
    RELENTLESS("Relentless", 5),
    MYSTIC("Mystic", 5),
    DEVASTATING("Devastating", 3);

    private final String name;
    private final double chance;

    ReforgWeapons(String name, double chance) {
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
