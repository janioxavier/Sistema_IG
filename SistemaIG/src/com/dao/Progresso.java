/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.controller.Acao;
import java.util.List;

/**
 *
 * @author Jânio Xavier
 */
public class Progresso {
    private static final int NUMERO_PERSONAGENS_MAIS_ESCOLHIDOS = 3;
    private static final int NUMERO_ACOES_MAIS_ESCOLHIDAS = 5;
    private int maiorNivelAlcancado;
    private List<Personagem> personagemMaisEscolhidos;
    private List<Acao> acoesMaisEscolhidas;
    private transient String[] personagemMaisEscolhido;
    private transient String[] acoesMaisEscolhida;

    public Progresso() {
       personagemMaisEscolhido = new String[NUMERO_PERSONAGENS_MAIS_ESCOLHIDOS];
       acoesMaisEscolhida = new String[NUMERO_ACOES_MAIS_ESCOLHIDAS];
    }

    public String[] getPersonagemMaisEscolhido() {
        return personagemMaisEscolhido;
    }

    public void setPersonagemMaisEscolhido(String[] personagemMaisEscolhido) {
        this.personagemMaisEscolhido = personagemMaisEscolhido;
    }

    public String[] getAcoesMaisEscolhida() {
        return acoesMaisEscolhida;
    }

    public void setAcoesMaisEscolhida(String[] acoesMaisEscolhida) {
        this.acoesMaisEscolhida = acoesMaisEscolhida;
    }        
    
    public int getMaiorNivelAlcancado() {
        return maiorNivelAlcancado;
    }

    public void setMaiorNivelAlcancado(int maiorNivelAlcancado) {
        this.maiorNivelAlcancado = maiorNivelAlcancado;
    }

    public List<Personagem> getPersonagemMaisEscolhidos() {
        return personagemMaisEscolhidos;
    }

    public List<Acao> getAcoesMaisEscolhidas() {
        return acoesMaisEscolhidas;
    }
    
    public void addPersonagenEscolhido(Personagem personagem) {
        personagemMaisEscolhidos.add(personagem);
    }
    
    public void addAcaoEscolhida(Acao acao) {
        acoesMaisEscolhidas.add(acao);
    }
}
