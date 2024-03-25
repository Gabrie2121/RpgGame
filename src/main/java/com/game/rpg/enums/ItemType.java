package com.game.rpg.enums;

public enum ItemType {
    WEAPON("Weapon"),
    ACCESSORY("Accessory"),
    PET("Pet"),
    CONSUMABLE("Consumable"),
    TOOL("Tool"),
    MISC("Miscellaneous"),
    CURSE("Curse"),
    AMULET("Amulet"),
    RING("Ring"),
    NECKLACE("Necklace"),
    CHESTPLATE("Chestplate"),
    HELMET("Helmet"),
    GAUNTLETS("Gauntlets"),
    LEGGINGS("Leggings"),
    BOOTS("Boots"),
    SHIELD("Shield"),
    ARTILLERY("Artillery");

    private final String displayName;

    ItemType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
