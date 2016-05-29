/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.Jogador;
import com.dao.Personagem;
import com.sistemaXX.GrauImitacao;
import com.sistemaXX.SistemaXX;

/**
 *
 * @author Jânio Xavier
 */
public class AvaliadorImitacao {
    public static final int FALHAS_MAXIMA = 5;
    public static final int SUCESSOS_MAXIMO = 5;
    private int sucessosSucessivos;
    private int falhasSucessivas;
    private SeletorJogabilidade seletorJogabilidade;
    private final SistemaXX sistemaXX;             

    public AvaliadorImitacao(Jogador jogador) {
        this.seletorJogabilidade = new SeletorJogabilidade(jogador);
        sistemaXX = new SistemaXX();
    }

    public int getSucessosSucessivos() {
        return sucessosSucessivos;
    }

    public int getFalhasSucessivas() {
        return falhasSucessivas;
    }

    /**
     * Verifica a imitação incrementando os sucessos sucessivos se a imitação
     * foi no mínimo quase perfeita ou as falhas sucessivas se a imitação foi
     * aproximada.
     * @param imitacao 
     * @return true se a imitação foi no mínimo quase perfeito, false cc.
     */
    public boolean verificarImitacao(Acao imitacao) {
        boolean sucesso = false;
        GrauImitacao grau = sistemaXX.avaliarImitacao(imitacao);

        switch (grau) {
            case APROXIMADO:
                incFalhasSucessivas();
                break;
            case QUASE_PERFEITO:
                incSucessosSucessivos();
                sucesso = true;
                break;  
        }
        
        return sucesso;
    }
    
    /**
     * Zera as falhas e sucessos sucessivos
     */
    public void zerarSucessosFalhas() {
        zerarFalhasSucessivas();
        zerarSucessosSucessivos();
    }

    private void zerarFalhasSucessivas() {
        falhasSucessivas = 0;
    }

    private void zerarSucessosSucessivos() {
        sucessosSucessivos = 0;
    }

    private void incSucessosSucessivos() {
        if (sucessosSucessivos < SUCESSOS_MAXIMO) {
            sucessosSucessivos++;
            zerarFalhasSucessivas();
        } else {
            zerarSucessosFalhas();
            seletorJogabilidade.aumentarNivel();
        }        
    }

    private void incFalhasSucessivas() {
        if (falhasSucessivas < FALHAS_MAXIMA) {
            falhasSucessivas++;
            zerarSucessosSucessivos();            
        } else {
            zerarSucessosFalhas();
            seletorJogabilidade.diminuirNivel();
        }
    }   
}
 