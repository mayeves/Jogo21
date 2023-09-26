package com.mycompany.app;

public class Carta {
    String nome;
    String naipe;    
    int valor;

     public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNaipe(){
        return naipe;
    }
    public void setNaipe(String naipe){
        this.naipe = naipe;
    } 
    public int getvalor(){
        return valor;
    }
    public void setValor(int valor){
        this.valor = valor;
    }
    public void setCarta(String nome, String naipe, int valor){
        this.nome = nome;
        this.naipe = naipe;        
        this.valor = valor;
    }
  }
  