/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemaXX;

/**
 * Enumera o grau de imitação do movimento realizado pelo jogador.
 * APROXIMADO, QUASE_PERFEITO e PERFEITO
 * @author Jânio Xavier
 */
public enum GrauImitacao {
    APROXIMADO (0),
    QUASE_PERFEITO (1),
    PERFEITO (2);
    
    int grau;
    
    private GrauImitacao(int grau) {
        this.grau = grau;
    }
    
    public int getGrau() {
        return grau;
    }
}
