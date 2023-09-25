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
    public void setValor (Integer valor){
        this.valor = valor;
    }

    
   public Integer CartaEnum (String nome){
        switch (nome){
            case "AS":
                return 1;
            case "DOIS":
                return 2;
            default:
                return 0;
        }
    }
}
  