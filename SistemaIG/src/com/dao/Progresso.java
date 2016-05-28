/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.controller.Acao;
import com.controller.TipoPersonagem;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author Jânio Xavier
 */
public class Progresso {
    public transient static final int NUMERO_PERSONAGENS_MAIS_ESCOLHIDOS = 3;
    public transient static final int NUMERO_ACOES_MAIS_ESCOLHIDAS = 5;
    private Map<TipoPersonagem, Integer> maiorNivelAlcancado;        
    private transient List<Personagem> personagemMaisEscolhidos;
    private transient List<Acao> acaoMaisEscolhidas;       
    private String[] personagensMaisEscolhidos;
    private String[] acoesMaisEscolhidas;    
    private String nickJogador;
    private String responsavel;
        
    
    public Progresso(String nickJogador, String responsavel) {        
        personagensMaisEscolhidos = new String[NUMERO_PERSONAGENS_MAIS_ESCOLHIDOS];
        acoesMaisEscolhidas = new String[NUMERO_ACOES_MAIS_ESCOLHIDAS];
        maiorNivelAlcancado = new HashMap<>();
        this.nickJogador = nickJogador;
        this.responsavel = responsavel;
    }        

    
    public String getNickJogador() {
        return nickJogador;
    }
    
    public String getResponsavel() {
        return responsavel;
    }   

    public String[] getPersonagensMaisEscolhidos() {
        return personagensMaisEscolhidos;
    }

    /**
     * as primeira posições do array referem-se aos personagens mais escolhidos
     * @param personagensMaisEscolhidos 
     */
    public void setPersonagensMaisEscolhidos(String[] personagensMaisEscolhidos) {
        if (personagensMaisEscolhidos.length <= NUMERO_PERSONAGENS_MAIS_ESCOLHIDOS)
        this.personagensMaisEscolhidos = personagensMaisEscolhidos;
    }

    public String[] getAcoesMaisEscolhidas() {
        return acoesMaisEscolhidas;
    }

    /**
     * As primeiras posições do vetor refere-se as ações mais escolhidas
     * @param acoesMaisEscolhidas array  5 das ações mais escolhidas
     */
    public void setAcoesMaisEscolhidas(String[] acoesMaisEscolhidas) {
        if (acoesMaisEscolhidas.length <= NUMERO_ACOES_MAIS_ESCOLHIDAS) {
            this.acoesMaisEscolhidas = acoesMaisEscolhidas;
        }
    }
            
    public int getMaiorNivelAlcancado(TipoPersonagem tipo) {
        if (maiorNivelAlcancado.containsKey(tipo)) {
            return maiorNivelAlcancado.get(tipo);
        }
        return 0;
    }

    public void setMaiorNivelAlcancado(TipoPersonagem personagem, Integer nivel) {
        if (personagem != null) {
            maiorNivelAlcancado.put(personagem, nivel);
        }
    }

    public List<Personagem> getPersonagemMaisEscolhidos() {
        return personagemMaisEscolhidos;
    }

    public void setPersonagemMaisEscolhidos(List<Personagem> personagemMaisEscolhidos) {
        this.personagemMaisEscolhidos = personagemMaisEscolhidos;        
    }

    public void setAcaoMaisEscolhidas(List<Acao> acoesMaisEscolhidas) {
        this.acaoMaisEscolhidas = acoesMaisEscolhidas;
    }
        
    public List<Acao> getAcaoMaisEscolhidas() {
        return acaoMaisEscolhidas;
    }
}
