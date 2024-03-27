package com.game.rpg.enums;

public enum ItemType {
    Arma("Arma"),
    Acessório("Acessório"),
    AnimalDeEstimação("Animal de Estimação"),
    Consumível("Consumível"),
    Diversos("Diversos"),
    Amuleto("Amuleto"),
    Anel("Anel"),
    Colar("Colar"),
    Peitoral("Peitoral"),
    Elmo("Elmo"),
    Perneiras("Perneiras"),
    Botas("Botas"),
    Escudo("Escudo"),
    Artilharia("Artilharia");

    private final String displayName;

    ItemType(String displayName) {
        this.displayName = displayName;
    }

    public String getName() {
        return displayName;
    }
}
