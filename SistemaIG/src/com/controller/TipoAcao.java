/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

/**
 *
 * @author Jânio Xavier
 */
public enum TipoAcao {
    Facial ("Facial"),
    Corporal ("Corporal");
    
    String nome;
    
    private TipoAcao(String nome) {
        this.nome = nome;
    }
    
    public String getNome() {
        return nome;
    }
}
