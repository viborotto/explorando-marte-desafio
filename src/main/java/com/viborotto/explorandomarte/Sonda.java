package com.viborotto.explorandomarte;

public class Sonda {

    private String nome;

    private Integer coordenadaX;

    private Integer coordenadaY;

    private String direcao;

    private String instrucoes;

    public Sonda(String nome, Integer coordenadaX, Integer coordenadaY, String direcao, String instrucoes) {
        this.nome = nome;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.direcao = direcao;
        this.instrucoes = instrucoes;
    }

    public Sonda() {
    }

    public String getDirecao() {
        return direcao;
    }

    public void setDirecao(String direcao) {
        this.direcao = direcao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(Integer coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public Integer getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(Integer coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    public String getInstrucoes() {
        return instrucoes;
    }

    public void setInstrucoes(String instrucoes) {
        this.instrucoes = instrucoes;
    }
}
