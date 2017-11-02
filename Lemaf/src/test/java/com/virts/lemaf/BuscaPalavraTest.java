/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virts.lemaf;

import com.virts.lemaf.Model.Resultado;
import com.virts.lemaf.util.Indexador;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Matheus
 */
public class BuscaPalavraTest {
    
    private String primeiraPalavra;
    private Indexador indexador;
            
    public BuscaPalavraTest() {
        try {
            primeiraPalavra = new AcessoApi().getPalavra(0);
            indexador = new Indexador();
        } catch (IOException ex) {
            primeiraPalavra = "";
        }
    }  
    /**
     * Test of buscarPalavra method, of class BuscaPalavra.
     */
    @Test
    public void testBuscarPalavraIndexador() {
        System.out.println("buscarPalavra");
        String palavra = "Teste";
        Integer posicao = 0;
        indexador.indexarPalavra(palavra, posicao);
        BuscaPalavra instance = new BuscaPalavra(indexador);
        Resultado expResult = new Resultado(posicao.toString(), 0);
        Resultado result = instance.buscarPalavra(palavra);
        assertEquals(expResult.getPosicao(), result.getPosicao());
       
    }
    
     @Test
    public void testBuscarPalavraApi() {
        System.out.println("buscarPalavra");        
        Integer posicao = 0;       
        BuscaPalavra instance = new BuscaPalavra(indexador);
        Resultado expResult = new Resultado(posicao.toString(), 0);
        Resultado result = instance.buscarPalavra(primeiraPalavra);
        assertEquals(expResult.getPosicao(), result.getPosicao());
       
    }
    
}
