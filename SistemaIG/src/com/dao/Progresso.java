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
    private int maiorNivelAlcancado;
    private List<Personagem> personagemMaisEscolhidos;
    private List<Acao> acoesMaisEscolhidas;

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
