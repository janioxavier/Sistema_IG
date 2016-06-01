/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.acoes;

/**
 *
 * @author Jânio Xavier
 */
public enum TipoAcao {
    FACIAL ("Facial"),
    CORPORAL ("Corporal");
    
    String nome;
    
    private TipoAcao(String nome) {
        this.nome = nome;
    }
    
    public String getNome() {
        return nome;
    }
}
