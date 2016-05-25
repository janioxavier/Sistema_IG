/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.controller.Acao;
import com.controller.TipoCorporal;
import com.controller.TipoFacial;
import java.util.List;

/**
 *
 * @author Jânio Xavier
 */
public abstract class Personagem {
    private List<Acao> listaAcoes;
    private TipoCorporal acoesCorporais;
    private TipoFacial acoesFaciais;
    private transient int nivel;
    
    public abstract Acao realizarAcao();
    
    public void addAcao(Acao acao) {
        listaAcoes.add(acao);
    }

    public TipoCorporal getAcoesCorporais() {
        return acoesCorporais;
    }

    public void setAcoesCorporais(TipoCorporal acoesCorporais) {
        this.acoesCorporais = acoesCorporais;
    }

    public TipoFacial getAcoesFaciais() {
        return acoesFaciais;
    }

    public void setAcoesFaciais(TipoFacial acoesFaciais) {
        this.acoesFaciais = acoesFaciais;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
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
