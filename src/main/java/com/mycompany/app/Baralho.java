package com.mycompany.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Baralho {

    static List<Carta> baralho = new ArrayList<Carta>();

    
    public void criarBaralho(){
         String[] naipe = {"Copas","Espada", "Paus", "Ouro"};
       
        for (int naipes=0; naipes<4;naipes++){            
              Carta AS = new Carta();
              AS.setCarta("AS", naipe[naipes], 1);
              baralho.add(AS);
              Carta DOIS = new Carta();
              DOIS.setCarta("DOIS", naipe[naipes], 2);
              baralho.add(DOIS);
              Carta TRES = new Carta();
              TRES.setCarta("TRES", naipe[naipes], 3);
              baralho.add(TRES); 
              Carta QUATRO = new Carta();
              QUATRO.setCarta("QUATRO", naipe[naipes], 4);
              baralho.add(QUATRO); 
              Carta CINCO = new Carta();
              CINCO.setCarta("CINCO", naipe[naipes], 5);
              baralho.add(CINCO); 
              Carta SEIS = new Carta();
              SEIS.setCarta("SEIS", naipe[naipes], 6);
              baralho.add(SEIS); 
              Carta SETE = new Carta();
              SETE.setCarta("SETE", naipe[naipes], 7);
              baralho.add(SETE); 
              Carta OITO = new Carta();
              OITO.setCarta("OITO", naipe[naipes], 8);
              baralho.add(OITO); 
              Carta NOVE = new Carta();
              NOVE.setCarta("NOVE", naipe[naipes], 9);
              baralho.add(NOVE); 
              Carta DEZ = new Carta();
              DEZ.setCarta("DEZ", naipe[naipes], 10);
              baralho.add(DEZ); 
              Carta VALETE = new Carta();
              VALETE.setCarta("VALETE", naipe[naipes], 11);
              baralho.add(VALETE); 
              Carta DAMA = new Carta();
              DAMA.setCarta("DAMA", naipe[naipes], 11);
              baralho.add(DAMA); 
              Carta REI = new Carta();
              REI.setCarta("REI", naipe[naipes], 11);
              baralho.add(REI); 
        }
    } 

    
    public void embaralhar(){
        Collections.shuffle(baralho);
    }

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
       /*  for (int i=0; i<baralho.size(); i++){
            Carta cartaIndice = new Carta();
            cartaIndice = baralho.get(i);
            System.out.println("Carta apos remover: "+cartaIndice.getNome()+" de "+cartaIndice.getNaipe());
        }  */ 
        return carta;

    }

    
}

