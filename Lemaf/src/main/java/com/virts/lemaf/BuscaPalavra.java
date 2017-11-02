/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virts.lemaf;

import com.virts.lemaf.Model.Resultado;
import com.virts.lemaf.util.Indexador;
import java.io.IOException;

/**
 *
 * @author Matheus
 */
public class BuscaPalavra {

    private Indexador indexador;

    public BuscaPalavra(Indexador indexador) {
        this.indexador = indexador;
    }

    public Resultado buscarPalavra(String palavra) {
        Integer possivelPosicao = indexador.recuperarIndice(palavra);
        return possivelPosicao != null ? new Resultado(String.valueOf(possivelPosicao), 0) : buscarPalavraNaApi(palavra);
    }

    private Integer buscarPalavraNoIndexador(String palavra) {
        return indexador.recuperarIndice(palavra);
    }

    private Resultado buscarPalavraNaApi(String palavra) {
       int gatinhosMortos = 1;
        try {

            if (palavra == null || palavra.trim().isEmpty()) {
                throw new NullPointerException("Uma plavra deve ser informada");
            }

            AcessoApi api = new AcessoApi();
            
            String resposta = "";
            boolean parar = false;
            int i = indexador.getUltimoIndicePesquisado();

            while (!parar) {
                resposta = api.getPalavra(i);
                indexador.indexarPalavra(resposta, i);
                if (palavra.equalsIgnoreCase(resposta)) {
                    parar = true;
                } else {
                    i++;
                    gatinhosMortos++;
                }

                //System.out.println(palavra + " = " + resposta + " " + palavra.equalsIgnoreCase(resposta));
                //System.out.println("Palavra " + resposta + " indice: " + i);
            }
            return new Resultado(String.valueOf(i), gatinhosMortos);
        } catch (Exception ex) {
            return new Resultado("Palavra não encontrada", gatinhosMortos);
        }
    }
}
