package com.viborotto.explorandomarte.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "sondas")
public class Sonda {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String nome;

    private String tamanhoSuperficie;

    @NotNull
    @Column(name = "COORDENADAX")
    private Integer coordenadaX;

    @NotNull
    @Column(name = "COORDENADAY")
    private Integer coordenadaY;

    @NotNull
    private String direcao;

    @NotNull
    @JsonIgnore
    private String instrucoes;

//    @JsonIgnore
//    private String descricao;


    public Sonda(Long id, String nome, String tamanhoSuperficie, Integer coordenadaX, Integer coordenadaY, String direcao, String instrucoes) {
        this.id = id;
        this.nome = nome;
        this.tamanhoSuperficie = tamanhoSuperficie;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.direcao = direcao;
        this.instrucoes = instrucoes;
    }

    public Sonda() {
    }

    public Long getId() {
        return id;
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

    public String getDirecao() {
        return direcao;
    }

    public void setDirecao(String direcao) {
        this.direcao = direcao;
    }

    public String getInstrucoes() {
        return instrucoes;
    }

    public void setInstrucoes(String instrucoes) {
        this.instrucoes = instrucoes;
    }

    public String getTamanhoSuperficie() {
        return tamanhoSuperficie;
    }

    public void setTamanhoSuperficie(String tamanhoSuperficie) {
        this.tamanhoSuperficie = tamanhoSuperficie;
    }
}
