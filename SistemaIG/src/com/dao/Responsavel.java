/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import java.util.List;

/**
 *
 * @author Jânio Xavier
 */
public class Responsavel {
    private String nome;
    private Jogador jogador;
    
    public Responsavel(String nome, Jogador jogador) {
        this.nome = nome;
        this.jogador = jogador;
    }
    
    public Progresso getProgresso() {
        return jogador.getProgresso();
    }
}
