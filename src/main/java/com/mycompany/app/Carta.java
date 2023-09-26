package com.mycompany.app;

public class Carta {
    String naipe;
    String nome;
    int valor;

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
      public int getvalor(){
        return valor;
    }
    public void setValor(int valor){
        this.valor = valor;
    }
    public void setCarta(String nome, String naipe, int valor){
        this.naipe = naipe;
        this.nome = nome;
        this.valor = valor;
    }
  }
  