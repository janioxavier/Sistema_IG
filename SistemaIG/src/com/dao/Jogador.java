/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.controller.TipoPersonagem;

/**
 *
 * @author Jânio Xavier
 */
public class Jogador {
    private Personagem personagem;
    private transient TipoPersonagem tipoPersonagem;
    private transient int nivelJogador;

    public Personagem getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }

    public int getNivelJogador() {
        return nivelJogador;
    }

    public void setNivelJogador(int nivelJogador) {
        this.nivelJogador = nivelJogador;
    }        
}
