package com.game.rpg.enums;

public enum Elements {
    Fogo("Fogo"),
    Agua("Água"),
    Terra("Terra"),
    Ar("Ar"),
    Relampago("Relâmpago"),
    Gelo("Gelo"),
    Luz("Luz"),
    Escuridão("Escuridão"),
    Natureza("Natureza"),
    Caos("Caos"),
    Divindade("Divindade"),
    Alma("Alma"),
    Vazio("Vazio"),
    Celestial("Celestial"),
    Primal("Primal"),
    Omni("Omni"),
    Supremo("Supremo"),
    Vortice("Vórtice"),
    Tempestade("Tempestade"),
    Chama("Chama"),
    Solar("Solar"),
    Lunar("Lunar"),
    Condenado("Condenado"),
    Elden("Elden"),
    Diabolico("Diabólico");

    private final String description;

    Elements(String description) {
        this.description = description;
    }

    public String getName() {
        return description;
    }
}
