/*----------------------------------------------------------------------------------------
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 *---------------------------------------------------------------------------------------*/

package com.mycompany.app;

public class App {
    public static void main(String[] args) {
        Carta carta = new Carta();
        carta.setNome("AS");
        carta.setNaipe("copas");

        switch (CartaEnum.valueOf(carta.getNome())){
            case AS:
                System.out.println("Valor Carta: "+CartaEnum.AS.getValor);
        }
        
    }
}
