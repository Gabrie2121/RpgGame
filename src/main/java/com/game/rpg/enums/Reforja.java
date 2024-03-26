package com.game.rpg.enums;

public enum Reforja {
    DIVINE_GUARDIAN("Divine Guardian", 15),
    SHADOW_WARD("Shadow Ward", 12),
    ETERNAL_SENTINEL("Eternal Sentinel", 12),
    IRONBARK("Ironbark", 10),
    ARCANE_BARRIER("Arcane Barrier", 10),
    FROSTFORGE("Frostforge", 10),
    AEGIS("Aegis", 8),
    STONEHEART("Stoneheart", 8),
    DREADNOUGHT("Dreadnought", 7),
    MYSTIC_VEIL("Mystic Veil", 5),
    FLAMEKEEPER("Flamekeeper", 5),
    TITANIUM_PLATE("Titanium Plate", 5),
    SHADOWBOUND("Shadowbound", 3),
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

    Reforja(String name, double chance) {
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
