/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.controller.Acao;
import com.controller.TipoPersonagem;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
/**
 *
 * @author Jânio Xavier
 */
public class Progresso {
    private transient static final int NUMERO_PERSONAGENS_MAIS_ESCOLHIDOS = 3;
    private transient static final int NUMERO_ACOES_MAIS_ESCOLHIDAS = 5;
    private int maiorNivelAlcancado;
    private Map<TipoPersonagem, Integer> quantidadePersonagemEscolhidos;
    private Map<Acao, Integer> quantidadeAcoesEscolhidos;
    private transient List<Personagem> personagemMaisEscolhidos;
    private transient List<Acao> acoesMaisEscolhidas;
    private String[] personagemMaisEscolhido;
    private String[] acoesMaisEscolhida;

    public Progresso() {
       personagemMaisEscolhido = new String[NUMERO_PERSONAGENS_MAIS_ESCOLHIDOS];
       acoesMaisEscolhida = new String[NUMERO_ACOES_MAIS_ESCOLHIDAS];
       quantidadePersonagemEscolhidos = new HashMap<>();
       quantidadeAcoesEscolhidos = new HashMap<>();
    }
    
    public void incrementarPersonagemEscolhido(TipoPersonagem personagem) {
        int qtdPersonagensEscolhidos = quantidadePersonagemEscolhidos.
                get(personagem);
        quantidadePersonagemEscolhidos.put(personagem, ++qtdPersonagensEscolhidos);
    }
    
    public void incrementarAcoesEscolhidas(Acao acao) {
        int qtdAcoesEscolhidas = quantidadeAcoesEscolhidos.get(acao);
        quantidadeAcoesEscolhidos.put(acao, ++qtdAcoesEscolhidas);
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
