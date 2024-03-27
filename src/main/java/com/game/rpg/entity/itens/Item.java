package com.game.rpg.entity.itens;

import com.game.rpg.enums.Elements;
import com.game.rpg.enums.ItemType;
import com.game.rpg.enums.Rarity;

public class Item {
    private Long id;
    private String nome;
    private String descricao;
    private String elemento;
    private String raridade;
    private String tipoDePeca;
    private Double forca;
    private Double destreza;
    private Double inteligencia;
    private Double constituicao;
    private Double sorte;
    private String imagem;

    // Construtor vazio
    public Item() {
    }

    // Getters e setters para todas as propriedades

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getElemento() {
        return elemento;
    }

    public void setElemento(String elemento) {
        this.elemento = elemento;
    }

    public String getRaridade() {
        return raridade;
    }

    public void setRaridade(String raridade) {
        this.raridade = raridade;
    }

    public String getTipoDePeca() {
        return tipoDePeca;
    }

    public void setTipoDePeca(String tipoDePeca) {
        this.tipoDePeca = tipoDePeca;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Double getForca() {
        return forca;
    }

    public void setForca(Double forca) {
        this.forca = forca;
    }

    public Double getDestreza() {
        return destreza;
    }

    public void setDestreza(Double destreza) {
        this.destreza = destreza;
    }

    public Double getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(Double inteligencia) {
        this.inteligencia = inteligencia;
    }

    public Double getConstituicao() {
        return constituicao;
    }

    public void setConstituicao(Double constituicao) {
        this.constituicao = constituicao;
    }

    public Double getSorte() {
        return sorte;
    }

    public void setSorte(Double sorte) {
        this.sorte = sorte;
    }

}
