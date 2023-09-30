/*----------------------------------------------------------------------------------------
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 *---------------------------------------------------------------------------------------*/

package com.mycompany.app;

import java.util.Scanner;


public class App {
    private static Scanner in = new Scanner(System.in);
    static Baralho baralho = new Baralho();
    static int totalPontos = 0;
    public static void main(String[] args) throws Exception{               
        String iniciar;
        //int jogadores = 0;
        //System.out.println("Informe a quantidade de jogadores");
        //jogadores = in.nextInt();
        
        do {
        System.out.println("-------------- Jogo de 21 --------------------");
        System.out.println("---------------------------------------------");
        System.out.println("Deseja iniciar o jogo? Digite 's' e tecle Enter");
        System.out.println("Deseja ver as instruções? Digite 'h' e tecle Enter");
        System.out.println("---------------------------------------------");

        iniciar = in.nextLine();         
        if(iniciar.equals("s") || iniciar.equals("S")){
            baralho.criarBaralho();
            baralho.embaralhar();
            primeiraMao();
            jogadasAdicionais();
        }  
        else if (iniciar.equals("h") || iniciar.equals("H")){
            System.out.println("Você receberá inicialmente 2 cartas, a soma delas não pode ultrapassar 21 pontos. \n"+
                                "Após receber as 2 cartas você poderá solicitar uma nova carta ou parar o jogo.\n");
        }
    } while (!iniciar.equals("t") );
    
    }

    static void primeiraMao(){
        for (int i=0; i<2; i++){
            Carta cartaSorteada = new Carta();
            cartaSorteada = baralho.sortearCarta();
            totalPontos = totalPontos + cartaSorteada.valor;
            System.out.println("A carta sorteada é: "+cartaSorteada.nome+" de "+cartaSorteada.getNaipe());            
        }
        System.out.println("");
        System.out.println("Seu total é de "+totalPontos+" pontos até o momento!\n");
    }

     
    static void jogadasAdicionais() throws Exception{
        String continuar = "N";
        int totalCartas;

        System.out.println("Informe 'S' se deseja solicitar outra carta: ");
        continuar = in.nextLine();

        while (continuar.equals("S") || continuar.equals("s")){
            totalCartas = Baralho.baralho.size();
            Carta cartaSorteada = new Carta();
            cartaSorteada = baralho.sortearCarta();
            totalPontos = totalPontos + cartaSorteada.valor;
            System.out.println("A carta sorteada é: "+cartaSorteada.nome+" de "+cartaSorteada.getNaipe()+"\n");
            System.out.println("Seu total é de "+totalPontos+" pontos até o momento!\n");
            if (totalPontos > 21){
                continuar = "N";
                System.out.println("Não foi dessa vez, tente novamente quando estiver com mais sorte!");
            } else {
                System.out.println("Informe 'S' se deseja solicitar outra carta: ");
                continuar = in.nextLine();
            }
        }

         

        System.out.println("Final do jogo com o total de "+totalPontos+" pontos.");


        


        
    }
}
