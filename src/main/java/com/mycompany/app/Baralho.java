package com.mycompany.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Baralho {

    List<Carta> baralho = new ArrayList<Carta>();

    public String sortearCarta(){
        Random random = new Random();
        int indice = random.nextInt(30);

        Carta carta = new Carta();
        carta = baralho[indice];
        return carta.getNome();
    }
    public void criarBaralho(){
        baralho = new ArrayList<Carta>();

        String[] naipe = {"Copas","Espada", "Paus", "Ouro"};
       
        
        for (int naipes=0; naipes<4;naipes++){            
              Carta carta = new Carta();
              carta.setCarta("AS", naipe[naipes], 1);
              baralho.add(carta);
              System.out.println("Carta: "+carta.getNome()+carta.getNaipe()+baralho.size());              
              carta.setCarta("DOIS", naipe[naipes], 2);
              baralho.add(carta);
              System.out.println("Carta: "+carta.getNome()+carta.getNaipe()+baralho.size());              
              carta.setCarta("TRES", naipe[naipes], 3);
              baralho.add(carta); 
              System.out.println("Carta: "+carta.getNome()+carta.getNaipe()+baralho.size()); 
              carta.setCarta("QUATRO", naipe[naipes], 4);
              baralho.add(carta); 
              System.out.println("Carta: "+carta.getNome()+carta.getNaipe()+baralho.size()); 
              carta.setCarta("CINCO", naipe[naipes], 5);
              baralho.add(carta); 
              System.out.println("Carta: "+carta.getNome()+carta.getNaipe()+baralho.size()); 
              carta.setCarta("SEIS", naipe[naipes], 6);
              baralho.add(carta); 
              System.out.println("Carta: "+carta.getNome()+carta.getNaipe()+baralho.size()); 
              carta.setCarta("SETE", naipe[naipes], 7);
              baralho.add(carta); 
              System.out.println("Carta: "+carta.getNome()+carta.getNaipe()+baralho.size()); 
              carta.setCarta("OITO", naipe[naipes], 8);
              baralho.add(carta); 
              System.out.println("Carta: "+carta.getNome()+carta.getNaipe()+baralho.size()); 
              carta.setCarta("NOVE", naipe[naipes], 9);
              baralho.add(carta); 
              System.out.println("Carta: "+carta.getNome()+carta.getNaipe()+baralho.size()); 
              carta.setCarta("DEZ", naipe[naipes], 10);
              baralho.add(carta); 
              System.out.println("Carta: "+carta.getNome()+carta.getNaipe()+baralho.size()); 
              carta.setCarta("VALETE", naipe[naipes], 11);
              baralho.add(carta); 
              System.out.println("Carta: "+carta.getNome()+carta.getNaipe()+baralho.size()); 
              carta.setCarta("DAMA", naipe[naipes], 11);
              baralho.add(carta); 
              System.out.println("Carta: "+carta.getNome()+carta.getNaipe()+baralho.size()); 
              carta.setCarta("REI", naipe[naipes], 11);
              baralho.add(carta); 
              System.out.println("Carta: "+carta.getNome()+carta.getNaipe()+baralho.size()); 
                         
                        
        }
    }         
    
}

