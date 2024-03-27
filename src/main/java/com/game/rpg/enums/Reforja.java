package com.game.rpg.enums;

public enum Reforja {
    DivineGuardian("Divine Guardian"),
    ShadowWard("Shadow Ward"),
    EternalSentinel("Eternal Sentinel"),
    Ironbark("Ironbark"),
    ArcaneBarrier("Arcane Barrier"),
    Frostforge("Frostforge"),
    Aegis("Aegis"),
    Stoneheart("Stoneheart"),
    Dreadnought("Dreadnought"),
    MysticVeil("Mystic Veil"),
    Flamekeeper("Flamekeeper"),
    TitaniumPlate("Titanium Plate"),
    Shadowbound("Shadowbound"),
    Dragonfury("Dragonfury"),
    Voidblade("Voidblade"),
    Thunderstrike("Thunderstrike"),
    Critical("Critical"),
    Frostbite("Frostbite"),
    Flaming("Flaming"),
    Lucky("Lucky"),
    Sunslayer("Sunslayer"),
    Sharpened("Sharpened"),
    Swift("Swift"),
    Relentless("Relentless"),
    Mystic("Mystic"),
    Devastating("Devastating");

    private final String name;

    Reforja(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}