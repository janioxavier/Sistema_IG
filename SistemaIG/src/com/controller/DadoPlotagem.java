/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.controller.personagens.TipoPersonagem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Jânio Xavier
 */
public class DadoPlotagem {

    private List<Progresso> progressos;
    private Map<String, List<Progresso>> progressosJogadores;

    public DadoPlotagem(List<Progresso> todosProgressos) {
        this.progressos = todosProgressos;        
        initProgressosJogadores();
    }

    private void initProgressosJogadores() {
        progressosJogadores = new HashMap<>();
        List<Progresso> progressosJogador = null;
        String[] jogadores = getJogadores();
        
        for (String nick : jogadores) {                       
            progressosJogador = new ArrayList<>();            
            for (Progresso progresso : progressos) {
                if (nick.equals(progresso.getNickJogador())) {
                    progressosJogador.add(progresso);
                }
            }
            progressosJogadores.put(nick, progressosJogador);
        }
    }
    
    public String[] getJogadores() {
        Set<String> jogadores = new HashSet<>();
        for (Progresso progresso : progressos) {
            String nick = progresso.getNickJogador();
            jogadores.add(nick);
        }
        return jogadores.toArray(new String[jogadores.size()]);
    }
    
    
    public List<Progresso> getProgresso(String jogador) {
        List<Progresso> progressos = progressosJogadores.get(jogador);       
        return progressos;
    }
    
    public Progresso getUltimoProgresso(String jogador) {
        List<Progresso> progressos = progressosJogadores.get(jogador);       
        return progressos.get(progressos.size() - 1);
    }
    
    public String[] getPersonagemMaisEscolhido(String jogador) {
        return getUltimoProgresso(jogador).getPersonagensMaisEscolhidos();
    }
    
    public String[] getAcaoMaisEscolhida(String jogador) {
        return getUltimoProgresso(jogador).getAcoesMaisEscolhidas();
    }
    
    public int getMaiorNivelPersonagem(String jogador, TipoPersonagem personagem) {
        return getUltimoProgresso(jogador).getMaiorNivelAlcancado(personagem);
    }                
}
