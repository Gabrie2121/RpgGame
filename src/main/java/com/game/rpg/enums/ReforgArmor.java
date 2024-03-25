package com.game.rpg.enums;

public enum ReforgArmor {
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
    SHADOWBOUND("Shadowbound", 3);

    private final String name;
    private final double chance;

    ReforgArmor(String name, double chance) {
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
