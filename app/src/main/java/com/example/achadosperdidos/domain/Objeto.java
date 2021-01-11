package com.example.achadosperdidos.domain;

import java.util.Date;

public class Objeto {

    private String nome;
    private String descricao;
    private int recompensa;
    private String data_encontrada;
    private int flag_objeto;
    private Endereco endereco;


    public Objeto(String nome, String descricao, int recompensa, String data_encontrada, int flag_objeto, Endereco endereco) {
        this.nome = nome;
        this.descricao = descricao;
        this.recompensa = recompensa;
        this.data_encontrada = data_encontrada;
        this.flag_objeto = flag_objeto;
        this.endereco = endereco;
    }

    public Objeto() {
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

    public int getRecompensa() {
        return recompensa;
    }

    public void setRecompensa(int recompensa) {
        this.recompensa = recompensa;
    }

    public String getData_encontrada() {
        return data_encontrada;
    }

    public void setData_encontrada(String data_encontrada) {
        this.data_encontrada = data_encontrada;
    }

    public int getFlag_objeto() {
        return flag_objeto;
    }

    public void setFlag_objeto(int flag_objeto) {
        this.flag_objeto = flag_objeto;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
