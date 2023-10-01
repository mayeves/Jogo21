package com.mycompany.app;

public class Jogador {
    String nome;       
    int totalPontos;
    int vitorias;

     public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public int getTotalPontos(){
        return totalPontos;
    }
    public void setTotalPontos(int totalPontos){
        this.totalPontos = totalPontos;
    }
    public int getVitorias(){
        return vitorias;
    }
    public void setVitorias(int vitorias){
        this.vitorias = vitorias;
    }
    public void setJogador(String nome, int totalPontos, int vitorias){
        this.nome = nome;
        this.totalPontos = totalPontos;
        this.vitorias = vitorias;
    }   
}
