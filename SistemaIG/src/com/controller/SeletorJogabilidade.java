/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.Jogador;

/**
 *
 * @author Jânio Xavier
 */
public class SeletorJogabilidade {    
    public static final int NIVEL_MAXIMO = 6;    
    private int nivelJogabilidade;
    private Jogador jogador;
    
    public SeletorJogabilidade(Jogador jogador) {
        this.nivelJogabilidade = 0;
        this.jogador = jogador;
    }
    
    public void setNivelJogabilidade(int nivel) {
        if (nivel >= 0 && nivel <= NIVEL_MAXIMO) {
            nivelJogabilidade = nivel;
            jogador.setMaiorNivelAlcancado(nivel);
        }
    }
    
    public void aumentarNivel() {
        int nivel = jogador.getMaiorNivelAlcancado();
        if (nivel < NIVEL_MAXIMO) {
            nivel++;
            jogador.setMaiorNivelAlcancado(nivel);
        }
    }
    
    public void diminuirNivel() {
        int nivel = jogador.getMaiorNivelAlcancado();
        if (nivel > 0) {
            nivel--;
            jogador.setMaiorNivelAlcancado(nivel);
        }            
    }
}
