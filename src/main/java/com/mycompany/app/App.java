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
        int jogadores = 0;
        String desejaIniciar;
        String iniciar;

        //System.out.println("Informe a quantidade de jogadores");
        //jogadores = in.nextInt();

        baralho.criarBaralho();
        baralho.embaralhar();
        System.out.println("Deseja iniciar o jogo? Digite 's' e tecle Enter");
        desejaIniciar = in.nextLine(); 
        if(desejaIniciar.equals("s")){
            primeiraMao();
            jogadasAdicionais();
        }     
        
            
    }

    static void primeiraMao(){
        for (int i=0; i<2; i++){
            Carta cartaSorteada = new Carta();
            cartaSorteada = baralho.sortearCarta();
            totalPontos = totalPontos + cartaSorteada.valor;
            System.out.println("A carta sorteada é: "+cartaSorteada.nome+" de "+cartaSorteada.getNaipe());
            System.out.println("Seu total é de "+totalPontos+" pontos até o momento!");

        }
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
            System.out.println("A carta sorteada é: "+cartaSorteada.nome+" de "+cartaSorteada.getNaipe());
            System.out.println("Seu total é de "+totalPontos+" pontos até o momento!");
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
