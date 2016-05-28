/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Jânio Xavier
 */
public class OrdenadorAcoes {
    private static final int NIVEL_MISTURA_ACAO = 4;    
    private List<Acao> ordemAcoes;    
    private int quantidadeAcoes;
    
    public OrdenadorAcoes() {
        quantidadeAcoes = 0;
    }
    
    public List<Acao> ordenarAcoes(int nivel, Acao tipoAcao) {        
        ordemAcoes = null;
        quantidadeAcoes = nivel;
        if (nivel >= NIVEL_MISTURA_ACAO) {
            misturarAcoes();
        }
        else if (tipoAcao instanceof TipoFacial) {
            ordenarFacias();
        }
        else if (tipoAcao instanceof TipoCorporal) {
            ordenarCorporal();
        }
        return ordemAcoes;
    }
    
    private void ordenarFacias() {
        TipoFacial[] faciais = TipoFacial.values();
        List<Acao> acoesFaciais = Arrays.asList(faciais);
        Collections.shuffle(acoesFaciais);
        
        ordemAcoes = acoesFaciais.subList(0, quantidadeAcoes);        
    }
    
    private void ordenarCorporal() {
        TipoCorporal[] corporais = TipoCorporal.values();
        List<Acao> acoesCorporais = Arrays.asList(corporais);
        Collections.shuffle(acoesCorporais);
        
        ordemAcoes = acoesCorporais.subList(0, quantidadeAcoes);        
    }    
    
    private void misturarAcoes() {
        TipoCorporal[] corporais = TipoCorporal.values();
        List<Acao> acoesCorporais = Arrays.asList(corporais);        
        
        TipoFacial[] faciais = TipoFacial.values();
        List<Acao> acoesFaciais = Arrays.asList(faciais);
        
        List<Acao> acoes = new ArrayList<>();
        acoes.addAll(acoesFaciais);
        acoes.addAll(acoesCorporais);
                
        Collections.shuffle(acoes);
        
        ordemAcoes = acoes.subList(0, quantidadeAcoes);
    }
}
