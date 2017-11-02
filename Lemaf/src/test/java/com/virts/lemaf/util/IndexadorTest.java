/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virts.lemaf.util;

import static org.junit.Assert.*;

/**
 *
 * @author Matheus
 */
public class IndexadorTest {

    public IndexadorTest() {
    }

    /**
     * Test of IndexarPalavra method, of class Indexador.
     */
    @org.junit.Test
    public void testIndexarPalavra() {
        System.out.println("IndexarPalavra");
        String palavra = "Teste";
        Integer posicao = 0;
        Indexador instance = new Indexador();
        instance.indexarPalavra(palavra, posicao);
    }

    /**
     * Test of IndexarPalavra method, of class Indexador.
     */
    @org.junit.Test(expected = NullPointerException.class)
    public void testIndexarPalavraNula() {
        System.out.println("IndexarPalavra");
        String palavra = null;
        Integer posicao = 0;
        Indexador instance = new Indexador();
        instance.indexarPalavra(palavra, posicao);
    }
    
    @org.junit.Test(expected = NullPointerException.class)
    public void testIndexarPalavraVazia() {
        System.out.println("IndexarPalavra");
        String palavra = "    ";
        Integer posicao = 0;
        Indexador instance = new Indexador();
        instance.indexarPalavra(palavra, posicao);
    }

    @org.junit.Test(expected = NullPointerException.class)
    public void testIndexarPalavraPosicaoNula() {
        System.out.println("IndexarPalavra");
        String palavra = "Tests";
        Integer posicao = null;
        Indexador instance = new Indexador();
        instance.indexarPalavra(palavra, posicao);
    }

    /**
     * Test of RecuperarIndice method, of class Indexador.
     */
    @org.junit.Test
    public void testRecuperarIndicePalavraInexistente() {
        System.out.println("RecuperarIndice");
        String palavra = "Teste";
        Indexador instance = new Indexador();
        Integer expResult = null;
        Integer result = instance.recuperarIndice(palavra);
        assertEquals(expResult, result);
    }

    @org.junit.Test
    public void testRecuperarIndicePalavraExistente() {
        System.out.println("RecuperarIndice");
        String palavra = "Teste";
        Integer posicao = 0;

        Indexador instance = new Indexador();
        instance.indexarPalavra(palavra, posicao);

        Integer expResult = posicao;
        Integer result = instance.recuperarIndice(palavra);
        assertEquals(expResult, result);
    }

}
