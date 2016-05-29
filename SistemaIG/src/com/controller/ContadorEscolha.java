/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;
import java.util.Map;
import java.util.HashMap;

/**
 * Contabiliza a escolha da ação ou do personagem realizada pelo jogador e
 * determina as ações mais escolhidas e os personagens mais escolhidos.
 * @author Jânio Xavier
 */
public class ContadorEscolha {    
    private Map<TipoAcao, Integer> contadorAcao;
    private Map<TipoPersonagem, Integer> contadorPersonagem;
    
    public ContadorEscolha() {
        contadorAcao = new HashMap<>();        
        contadorPersonagem = new HashMap<>();
        initContadorAcao();
        initContadorPersonagem();
    }
    
    public void initContadorAcao() {
        contadorAcao.clear();        
        for (TipoAcao tipo : TipoAcao.values()) {
            contadorAcao.put(tipo, 0);
        }                
    }
    
    public void initContadorPersonagem() {
        contadorPersonagem.clear();
        for (TipoPersonagem tipo : TipoPersonagem.values()) {
            contadorPersonagem.put(tipo, 0);
        }
    }
    
    public void incrementarAcao(TipoAcao tipo) {
        int valor = getNumeroEscolha(tipo);
        contadorAcao.put(tipo, ++valor);
    }
    
    public void incrementarPersonagem(TipoPersonagem tipo) {
        int valor = getNumeroEscolha(tipo);
        contadorPersonagem.put(tipo, ++valor);
    }
    
    public int getNumeroEscolha(TipoAcao tipo) {
        if(contadorAcao.containsKey(tipo))
            return contadorAcao.get(tipo);
        return 0;
    }
    
    public int getNumeroEscolha(TipoPersonagem tipo) {
        if (contadorPersonagem.containsKey(tipo))
            return contadorPersonagem.get(tipo);
        return 0;
    }
    
    public TipoAcao getAcaoMaisEscolhida() {
        TipoAcao tipoMaisEscolhido = null;
        int maisEscolhido = 0;
        int vezesEscolhido;
        
        for (TipoAcao tipo : TipoAcao.values()) {
            vezesEscolhido = contadorAcao.get(tipo);
            if (vezesEscolhido > maisEscolhido) {
                maisEscolhido = vezesEscolhido;
                tipoMaisEscolhido = tipo;
            }
        }
        return tipoMaisEscolhido;
    }
    
    public TipoPersonagem getPersonagemMaisEscolhida() {
        TipoPersonagem tipoMaisEscolhido = null;
        int maisEscolhido = 0;
        int vezesEscolhido;
        
        for (TipoPersonagem tipo : TipoPersonagem.values()) {
            vezesEscolhido = contadorPersonagem.get(tipo);
            if (vezesEscolhido > maisEscolhido) {
                maisEscolhido = vezesEscolhido;
                tipoMaisEscolhido = tipo;
            }
        }
        return tipoMaisEscolhido;
    }
}
