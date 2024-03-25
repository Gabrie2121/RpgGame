package com.game.rpg.enums;

public enum Elements {
    FIRE("Fire"),
    WATER("Water"),
    EARTH("Earth"),
    AIR("Air"),
    LIGHTNING("Lightning"),
    ICE("Ice"),
    LIGHT("Light"),
    DARKNESS("Darkness"),
    NATURE("Nature"),
    CHAOS("Chaos"),
    DIVINITY("Divinity"),
    SOUL("Soul"),
    VOID("Void"),
    CELESTIAL("Celestial"),
    PRIMAL("Primal"),
    OMNI("Omni"),
    SUPREME("Supreme"),
    VORTEX("Vortex"),
    TEMPEST("Tempest"),
    FLAME("Flame"),
    SOLAR("Solar"),
    LUNAR("Lunar"),
    DAMNED("Damned"),
    ELDEN("Elden"),
    DIABOLIC("Diabolic");

    private final String description;

    Elements(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
