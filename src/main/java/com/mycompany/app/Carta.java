package com.mycompany.app;

public class Carta {
    String naipe;
    String nome;
    Integer valor;

    public String getNaipe(){
        return naipe;
    }
    public void setNaipe(String naipe){
        this.naipe = naipe;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public Integer getValor(){
        return valor;
    }
    public void setNaipe(Integer valor){
        this.valor = valor;
    }
}