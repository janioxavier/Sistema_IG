/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.controller.TipoPersonagem;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Jânio Xavier
 */
public class Jogador {
    private transient Personagem personagem;
    private TipoPersonagem tipoPersonagem;    
    private Progresso progresso;
    
    public Jogador(String nickJogador, String responsavel,
            TipoPersonagem tipoPersonagem, int nivel) {             
        progresso = new Progresso(nickJogador, responsavel);
        progresso.setMaiorNivelAlcancado(tipoPersonagem, nivel);
        this.tipoPersonagem = tipoPersonagem;
    }
    
    public Jogador(String nickJogador, String responsavel) {             
        progresso = new Progresso(nickJogador, responsavel);        
    }
    
    public Jogador(Progresso progresso) {
        this.progresso = progresso;
    }   
    
    public String getNome() {
        return progresso.getNickJogador();
    }
    
    public String getResponsavel() {
        return progresso.getResponsavel();
    }
    
    public int getMaiorNivelAlcancado(TipoPersonagem tipo) {
        return progresso.getMaiorNivelAlcancado(tipo);
    }
    
    public int getMaiorNivelAlcancado() {
        return progresso.getMaiorNivelAlcancado(tipoPersonagem);
    }

    public void setMaiorNivelAlcancado(TipoPersonagem personagem, Integer nivel) {
        progresso.setMaiorNivelAlcancado(personagem, nivel);
    }
    
    public void setMaiorNivelAlcancado(Integer nivel) {
        progresso.setMaiorNivelAlcancado(tipoPersonagem, nivel);
    }
    
    public void setTipoPersonagem(TipoPersonagem personagem) {
        this.tipoPersonagem = personagem;
    }
                    
    public Progresso getProgresso() {
        return progresso;
    }
    
    public Personagem getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }   
}
