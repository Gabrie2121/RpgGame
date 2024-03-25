package com.game.rpg.entity.itens;

public class Item {
    private int id;
    private String nome;
    private String descricao;
    private String elemento;
    private int reforja;
    private String raridade;
    private String tipoDePeca;
    private int danoFisico;
    private int danoMagico;
    private int defesaFisica;
    private int defesaMagica;
    private String imagem;

    // Construtor vazio
    public Item() {
    }

    // Getters e setters para todas as propriedades

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getReforja() {
        return reforja;
    }

    public void setReforja(int reforja) {
        this.reforja = reforja;
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

    public int getDanoFisico() {
        return danoFisico;
    }

    public void setDanoFisico(int danoFisico) {
        this.danoFisico = danoFisico;
    }

    public int getDanoMagico() {
        return danoMagico;
    }

    public void setDanoMagico(int danoMagico) {
        this.danoMagico = danoMagico;
    }

    public int getDefesaFisica() {
        return defesaFisica;
    }

    public void setDefesaFisica(int defesaFisica) {
        this.defesaFisica = defesaFisica;
    }

    public int getDefesaMagica() {
        return defesaMagica;
    }

    public void setDefesaMagica(int defesaMagica) {
        this.defesaMagica = defesaMagica;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
