/*----------------------------------------------------------------------------------------
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 *---------------------------------------------------------------------------------------*/

package com.mycompany.app;

public class App {
    public static void main(String[] args) {
        

        Baralho baralho = new Baralho();
        baralho.criarBaralho();
        String nome = baralho.sortearCarta();

        System.out.println("A carta sorteada é a: "+nome);
        
        
    }
}
