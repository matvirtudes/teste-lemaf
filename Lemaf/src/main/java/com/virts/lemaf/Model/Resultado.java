/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virts.lemaf.Model;

import java.util.Objects;

/**
 *
 * @author Matheus
 */
public class Resultado {
    
    private String posicao;
    private Integer gatinhosMortos;

    public Resultado(String posicao, Integer gatinhosMortos) {
        this.posicao = posicao;
        this.gatinhosMortos = gatinhosMortos;
    }

    public String getPosicao() {
        return posicao;
    }

    public Integer getGatinhosMortos() {
        return gatinhosMortos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.posicao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Resultado other = (Resultado) obj;
        if (!Objects.equals(this.posicao, other.posicao)) {
            return false;
        }
        return true;
    }
    
    
    
}
