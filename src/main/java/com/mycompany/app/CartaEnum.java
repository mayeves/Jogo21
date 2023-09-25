package com.mycompany.app;
import java.util.HashMap;
import java.util.Map;

public enum CartaEnum {
    
    AS(1L, "AS"),
    DOIS(2L, "DOIS"),
    TRES(3L, "TRES");

    private Long valor;
    private String nome;

    private CartaEnum(Long valor, String nome){
        this.valor = valor;
        this.nome = nome;
    }

    private static final Map<String,CartaEnum> map = new HashMap<>();

    static {
        for (CartaEnum e : CartaEnum.values()){
            map.put(e.nome, e);
        }
    }
    
    public Long getValor(){
        return valor;
    }

    public String getNome(){
        return nome;
    }
}
