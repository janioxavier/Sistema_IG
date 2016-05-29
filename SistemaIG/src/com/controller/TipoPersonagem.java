/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

/**
 *
 * @author janioxavier
 */
public enum TipoPersonagem {
    GATO ("Gato"),
    CACHORRO ("Cachorro"),
    MENINO ("Menino"),
    MENINA ("Menina");
    
    private String nome;    
    private TipoPersonagem(String nome) {
        this.nome = nome;
    }
    
    public String getNome() {
        return nome;
    }
}
