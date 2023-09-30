/*----------------------------------------------------------------------------------------
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 *---------------------------------------------------------------------------------------*/

package com.mycompany.app;

import java.util.Scanner;


public class App {
    private static Scanner in = new Scanner(System.in);
    static Baralho baralho = new Baralho();
    static int totalPontos;
    static String jogador;
    public static void main(String[] args) throws Exception{               
        int menu;
        jogador ="";
       
        System.out.printf("Informe o seu nome: ");
        jogador = in.nextLine();

        if(!jogador.equals("")){
            do {
            System.out.println("-------------- Jogo de 21 --------------------");
            System.out.println("---------------------------------------------\n");
            System.out.println("1 - Iniciar");
            System.out.println("2 - Instruções");
            System.out.println("3 - Sair\n");
            System.out.println("---------------------------------------------");
            
            System.out.printf("Opção: ");
            menu = in.nextInt();
            in.nextLine();
            
                
            if(menu == 1){
                totalPontos = 0;
                baralho.criarBaralho();
                baralho.embaralhar();
                primeiraMao();
                jogadasAdicionais();
            }  
            else if (menu == 2){
                System.out.println("\n");
                System.out.println("------------------------------Instruções--------------------------------------------\n"+
                                    "Você receberá inicialmente 2 cartas, a soma delas não pode ultrapassar 21 pontos.  \n"+
                                    "Após receber as 2 cartas você poderá solicitar uma nova carta ou parar o jogo.     \n"+
                                    "-----------------------------------------------------------------------------------\n");
            }
            else if (menu == 3){
                System.out.println(jogador+" você está saindo do Jogo 21. Obrigado por participar!");
            } else {
                System.out.println("Digite uma opção válida.");
            }
        
        } while (menu != 3 );
}
    
    }

    static void primeiraMao(){
        System.out.println("\n ---------------Primeira Jogada---------\n");
        for (int i=0; i<2; i++){
            Carta cartaSorteada = new Carta();
            cartaSorteada = baralho.sortearCarta();
            totalPontos = pontosAcumulados(cartaSorteada.valor);
            System.out.println("A carta sorteada é: "+cartaSorteada.nome+" de "+cartaSorteada.getNaipe());            
        }
        System.out.println("");
        System.out.println(jogador+", seu total é de "+totalPontos+" pontos até o momento!\n");
    }

     
    static void jogadasAdicionais() throws Exception{
        String continuar = "N";
        String vinteUm = "";
        int totalCartas;
        int numeroJogada = 2;

        vinteUm = estourouPontos(totalPontos);

        if (vinteUm.equals("Acima")){                
            System.out.println("Não foi dessa vez "+jogador+", tente novamente quando estiver com mais sorte!");
        } else if (vinteUm.equals("Igual")){
            System.out.println(jogador+" você está com sorte, atingiu 21 pontos!");
        } else if (vinteUm.equals("Abaixo")){
            System.out.printf("Informe 's' se deseja solicitar outra carta ou 'n' se deseja parar: ");
            continuar = in.nextLine();
        }
        

        while (continuar.equals("S") || continuar.equals("s")){            
            System.out.println("\n ---------------Jogada "+numeroJogada+" ---------\n");
            numeroJogada++;
            Carta cartaSorteada = new Carta();
            cartaSorteada = baralho.sortearCarta();
            totalPontos = pontosAcumulados(cartaSorteada.valor);
            System.out.println("A carta sorteada é: "+cartaSorteada.nome+" de "+cartaSorteada.getNaipe()+"\n");
            System.out.println(jogador+", seu total é de "+totalPontos+" pontos até o momento!\n");
            
            vinteUm = estourouPontos(totalPontos);
            if (vinteUm.equals("Acima")){
                continuar = "N";
                System.out.println("Não foi dessa vez "+jogador+", tente novamente quando estiver com mais sorte!");
            } else if (vinteUm.equals("Igual")){
                continuar = "N";
                System.out.println(jogador+" você está com sorte, atingiu 21 pontos!");
            } else if (vinteUm.equals("Abaixo")) {
                System.out.printf("Informe 's' se deseja solicitar outra carta ou 'n' se deseja parar: ");
                continuar = in.nextLine();
            }
        }        
        System.out.println("Final do jogo com o total de "+totalPontos+" pontos.\n");
    }
    static int pontosAcumulados(int pontos){ 
        return totalPontos += pontos; 
    }

    static String estourouPontos(int pontosTotal){ 
        if (pontosTotal < 21){
            return "Abaixo";
        } else if (pontosTotal == 21){
            return "Igual"; 
        } else {
            return "Acima";
        }
    }
}
