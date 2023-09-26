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
        int jogadores = 1;

        System.out.println("Informe a quantidade de jogadores");
        jogadores = in.nextInt();

        baralho.criarBaralho();
        
        primeiraMao();
        jogadasAdicionais();

        
        
    }

    static void primeiraMao(){
        for (int i=0; i<1; i++){
            Carta cartaSorteada = new Carta();
            cartaSorteada = baralho.sortearCarta();
            totalPontos = totalPontos + cartaSorteada.valor;
            System.out.println("A carta sorteada é a: "+cartaSorteada.nome+" de "+cartaSorteada.getNaipe());
            System.out.println("Seu total é de "+totalPontos+" pontos até o momento!");

        }
    }

     /**
     * @throws Exception
     */
    static void jogadasAdicionais() throws Exception{
        String continuar = "N";
        int totalCartas;

        System.out.println("Informe se deseja solicitar outra carta: ");
        continuar = in.nextLine();

        do {
            totalCartas = Baralho.baralho.size();
            Carta cartaSorteada = new Carta();
            cartaSorteada = baralho.sortearCarta();
            totalPontos = totalPontos + cartaSorteada.valor;
            System.out.println("A carta sorteada é a: "+cartaSorteada.nome+" de "+cartaSorteada.getNaipe());
            System.out.println("Seu total é de "+totalPontos+" pontos até o momento!");
            System.out.println("Informe se deseja solicitar outra carta: ");
            continuar = in.nextLine();

        } while (continuar.equals("S") || continuar.equals("s"));

        System.out.println("Final do jogo com o total de "+totalPontos);


        


        
    }
}
