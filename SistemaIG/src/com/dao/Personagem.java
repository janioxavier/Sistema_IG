/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.controle.Acao;
import java.util.List;

/**
 *
 * @author Jânio Xavier
 */
public abstract class Personagem {
    private List<Acao> listaAcoes;
    private int nivel;
    
    public abstract Acao realizarAcao();
    
    public void addAcao(Acao acao) {
        listaAcoes.add(acao);
    }
    
    public void removerAcao(Acao acao) {
        listaAcoes.remove(acao);
    }
    
    public List<Acao> getListaAcoes() {
        return listaAcoes;
    }
    
    public void subirNivel() {
        nivel++;
    }        
}
