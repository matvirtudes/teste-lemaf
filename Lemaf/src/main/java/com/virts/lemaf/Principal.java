/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virts.lemaf;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matheus
 */
public class Principal {

    public static void main(String[] args) {
        AcessoApi api = new AcessoApi();

        try {
            String resposta = "";
            String palavra = "Amor";
            int i = 7927;
            while (!palavra.equalsIgnoreCase(resposta)) {
               
                resposta = api.getPalavra(i);
                
                System.out.println("Palavra " + resposta + " indice: " + i);
                i++;
            }
            System.out.println("Achei::: " + i);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
