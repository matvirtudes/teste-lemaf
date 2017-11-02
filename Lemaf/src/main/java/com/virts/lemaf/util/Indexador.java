/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virts.lemaf.util;

import java.util.HashMap;

/**
 *
 * @author Matheus
 */
public class Indexador {
    
    private HashMap<String, Integer> indices;
    private Integer ultimoIndicePesquisado;

    public Indexador() {
        this.indices = new HashMap<String, Integer>();
        this.ultimoIndicePesquisado = 0;
    }
    
    public void indexarPalavra(String palavra, Integer posicao){
        if(palavra == null || palavra.trim().isEmpty()){
            throw new NullPointerException("Uma plavra deve ser informada");
        }
         if(posicao == null){
            throw new NullPointerException("Uma posicao deve ser informada");
        }
        indices.put(palavra.toLowerCase(), posicao);
        ultimoIndicePesquisado = posicao;
    }

    public Integer getUltimoIndicePesquisado() {
        return ultimoIndicePesquisado;
    }
    
    public Integer recuperarIndice(String palavra){
        return indices.get(palavra.toLowerCase());
    }    
    
}
