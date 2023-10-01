/*----------------------------------------------------------------------------------------
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 *---------------------------------------------------------------------------------------*/

package com.mycompany.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class App {
    private static Scanner in = new Scanner(System.in);
    static Baralho baralho = new Baralho();
    static List<Jogador> jogadores = new ArrayList<Jogador>();
    static int totalPontos;
    static String jogador;
    static int totalVitorias1 = 0;
    static int totalVitorias2 = 0;
    public static void main(String[] args) throws Exception{               
        int menu;
        int quantidadeJogadores;
        jogador ="";        
        
        System.out.printf("Informe a quantidade de jogadores. Somente 1 ou 2 jogadores: ");
        quantidadeJogadores = in.nextInt();
        in.nextLine(); 
        for (int i=0; i<quantidadeJogadores;i++){
            Jogador jogadorClasse = new Jogador();
            System.out.printf("Informe o nome do jogador "+(i+1)+": ");
            jogador = in.nextLine();
            jogadorClasse.setJogador(jogador, 0, 0);
            jogadores.add(jogadorClasse);
            
        }
        if(quantidadeJogadores > 0){
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
                baralho.criarBaralho();
                baralho.embaralhar();                
                for(int i=0; i<jogadores.size(); i++){
                    primeiraMao(i);
                    jogadasAdicionais(i);
                }
            }  
            else if (menu == 2){
                System.out.println("\n");
                System.out.println("------------------------------Instruções--------------------------------------------\n"+
                                    "Você receberá inicialmente 2 cartas, a soma delas não pode ultrapassar 21 pontos.  \n"+
                                    "Após receber as 2 cartas você poderá solicitar uma nova carta ou parar o jogo.     \n"+
                                    "-----------------------------------------------------------------------------------\n");
            }
            else if (menu == 3){
                if(quantidadeJogadores>1){
                    System.out.println(jogadores.get(0).getNome()+" e "+jogadores.get(1).getNome()+
                    " vocês estão saindo do Jogo 21. Obrigado por participar!\n");
                    System.out.println("Total de vitorias de "+jogadores.get(0).getNome()+" = "+jogadores.get(0).getVitorias()+"\n"+
                                       "Total de vitorias de "+jogadores.get(1).getNome()+" = "+jogadores.get(1).getVitorias()+" \n");
                } else {
                   System.out.println(jogadores.get(0).getNome()+" você está saindo do Jogo 21. Obrigado por participar!");
                }
            } else {
                System.out.println("Digite uma opção válida.");
            }
        
        } while (menu != 3 );
}
    
    }

    static void primeiraMao(int jogador){
        totalPontos = 0;
        System.out.println("\n ---------------Primeira Jogada---------\n");
        for (int i=0; i<2; i++){
            Carta cartaSorteada = new Carta();
            cartaSorteada = baralho.sortearCarta();
            jogadores.get(jogador).setTotalPontos(pontosAcumulados(cartaSorteada.valor));
            
            System.out.println("A carta sorteada é: "+cartaSorteada.nome+" de "+cartaSorteada.getNaipe());            
        }
        System.out.println("");
        System.out.println(jogadores.get(jogador).getNome()+", seu total é de "+jogadores.get(jogador).getTotalPontos()+" pontos até o momento!\n");
    }

     
    static void jogadasAdicionais(int jogador) throws Exception{
        String continuar = "N";
        String vinteUm = "";        
        int numeroJogada = 2;

        vinteUm = estourouPontos(jogadores.get(jogador).getTotalPontos());

        if (vinteUm.equals("Acima")){                
            System.out.println("Não foi dessa vez "+jogadores.get(jogador).getNome()+", tente novamente quando estiver com mais sorte!");
        } else if (vinteUm.equals("Igual")){
            System.out.println(jogadores.get(jogador).getNome()+" você está com sorte, atingiu 21 pontos!");
        } else if (vinteUm.equals("Abaixo")){
            System.out.printf("Informe 's' se deseja solicitar outra carta ou 'n' se deseja parar: ");
            continuar = in.nextLine();
        }
        

        while (continuar.equals("S") || continuar.equals("s")){            
            System.out.println("\n ---------------Jogada "+numeroJogada+" ---------\n");
            numeroJogada++;
            Carta cartaSorteada = new Carta();
            cartaSorteada = baralho.sortearCarta();
            jogadores.get(jogador).setTotalPontos(pontosAcumulados(cartaSorteada.valor));
            System.out.println("A carta sorteada é: "+cartaSorteada.nome+" de "+cartaSorteada.getNaipe()+"\n");
            System.out.println(jogadores.get(jogador).getNome()+", seu total é de "+jogadores.get(jogador).getTotalPontos()+" pontos até o momento!\n");
            
            vinteUm = estourouPontos(jogadores.get(jogador).getTotalPontos());
            if (vinteUm.equals("Acima")){
                continuar = "N";
                System.out.println("Não foi dessa vez "+jogadores.get(jogador).getNome()+", tente novamente quando estiver com mais sorte!");
            } else if (vinteUm.equals("Igual")){
                continuar = "N";
                System.out.println(jogadores.get(jogador).getNome()+" você está com sorte, atingiu 21 pontos!");
            } else if (vinteUm.equals("Abaixo")) {
                System.out.printf("Informe 's' se deseja solicitar outra carta ou 'n' se deseja parar: ");
                continuar = in.nextLine();
            }
        }        
        System.out.println("Final da rodada com o total de "+jogadores.get(jogador).getTotalPontos()+" pontos.\n");
        if (jogador == jogadores.size()-1){
            
            if((jogadores.get(0).getTotalPontos() > 21 && jogadores.get(1).getTotalPontos() > 21) ||
                (jogadores.get(0).getTotalPontos() == jogadores.get(1).getTotalPontos())){
                System.out.println("O jogo empatou.\n"); 
                System.out.println(jogadores.get(0).getNome()+" voce fez "+jogadores.get(0).getTotalPontos()+" pontos."+
                                   jogadores.get(1).getNome()+" voce fez "+jogadores.get(1).getTotalPontos()+" pontos.\n");
            } else if((jogadores.get(0).getTotalPontos() <= 21 && jogadores.get(1).getTotalPontos() > 21) ||
                      (jogadores.get(0).getTotalPontos() <= 21 && jogadores.get(0).getTotalPontos() > jogadores.get(1).getTotalPontos())){
                System.out.println(jogadores.get(0).getNome()+" ganhou o jogo com o total de "+
                                    jogadores.get(0).getTotalPontos()+" pontos. Enquanto "+jogadores.get(1).getNome()+" ficou com "+
                                    jogadores.get(1).getTotalPontos()+" pontos.\n"); 
                totalVitorias1++;
                jogadores.get(0).setVitorias(totalVitorias1);
            } else {
                System.out.println(jogadores.get(1).getNome()+" ganhou o jogo com o total de "+
                                    jogadores.get(1).getTotalPontos()+" pontos. Enquanto "+jogadores.get(0).getNome()+" ficou com "+
                                    jogadores.get(0).getTotalPontos()+" pontos.\n");
                totalVitorias2++;
                jogadores.get(1).setVitorias(totalVitorias2);
            }
                    
        }
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
