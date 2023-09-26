package com.mycompany.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Baralho {

    static List<Carta> baralho = new ArrayList<Carta>();

    public Carta sortearCarta(){
        Random random = new Random();
        Carta carta = new Carta();
        if(baralho.size() < 1){
            System.out.println("O baralho terminou");
            return null;
        }
        int indice = random.nextInt(baralho.size());
        carta = baralho.get(indice);
        baralho.remove(indice);
        return carta;

    }
    public void criarBaralho(){
         String[] naipe = {"Copas","Espada", "Paus", "Ouro"};
       
        for (int naipes=0; naipes<4;naipes++){            
              Carta carta = new Carta();
              carta.setCarta("AS", naipe[naipes], 1);
              baralho.add(carta);
              carta.setCarta("DOIS", naipe[naipes], 2);
              baralho.add(carta);
              carta.setCarta("TRES", naipe[naipes], 3);
              baralho.add(carta); 
              carta.setCarta("QUATRO", naipe[naipes], 4);
              baralho.add(carta); 
              carta.setCarta("CINCO", naipe[naipes], 5);
              baralho.add(carta); 
              carta.setCarta("SEIS", naipe[naipes], 6);
              baralho.add(carta); 
              carta.setCarta("SETE", naipe[naipes], 7);
              baralho.add(carta); 
              carta.setCarta("OITO", naipe[naipes], 8);
              baralho.add(carta); 
              carta.setCarta("NOVE", naipe[naipes], 9);
              baralho.add(carta); 
              carta.setCarta("DEZ", naipe[naipes], 10);
              baralho.add(carta); 
              carta.setCarta("VALETE", naipe[naipes], 11);
              baralho.add(carta); 
              carta.setCarta("DAMA", naipe[naipes], 11);
              baralho.add(carta); 
              carta.setCarta("REI", naipe[naipes], 11);
              baralho.add(carta); 
        }
    }         
    
}

