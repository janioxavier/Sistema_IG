/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.Personagem;

/**
 *
 * @author Jânio Xavier
 */
public class AvaliadorImitacao {
    private int sucessosSucessivos;
    private int falhasSucessivas;
    private SeletorJogabilidade seletorJogabilidade;
    private Festejador festejador;
    private Personagem personam;

    public int getSucessosSucessivos() {
        return sucessosSucessivos;
    }

    public int getFalhasSucessivas() {
        return falhasSucessivas;
    }            
    
    public void verificarImitacao(int grau) {
        
    }
    
    public void zerarFalhasSucessivas() {
        falhasSucessivas = 0;
    }
    
    public void zerarSucessosSucessivos() {
        sucessosSucessivos = 0;
    }
    
    public void incSucessosSucessivos() {
        sucessosSucessivos ++;
    }
    
    public void incFalhasSucessivas() {
        falhasSucessivas ++;
    }
    
    public void decSucessosSucessivos() {
        sucessosSucessivos --;
    }
    
    public void decFalhasSucessivas() {
        falhasSucessivas --;
    }        
}
