/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.visao;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Jânio Xavier
 */
public class Comemoracao {    
    // Definição dos icones do jogo
    private static final Icon[] ICONES_COMEMORACAO = new Icon[]{
        new ImageIcon(""),
        new ImageIcon(""),
        new ImageIcon("")
    };    
    private List<Icon> comemoracoes;
    private List<Integer> sequenciaAnterior;
    private List<Integer> sequenciaAtual;
    private boolean novaSequencia;
    private Random randomGenerator;
    
    public Comemoracao() {        
        randomGenerator = new Random(System.currentTimeMillis());
        sequenciaAtual = new LinkedList<>();
        sequenciaAnterior = new LinkedList<>();
        comemoracoes = new LinkedList<>(Arrays.asList(ICONES_COMEMORACAO));
    }
    
    public Icon comemorar() {        
        return getProximoIcon();
    }
    
    public Icon getProximoIcon() {        
        int indice = getProximoIndice();        
        return comemoracoes.get(indice);  
    }

    private int getProximoIndice() {
        int aleatorio = randomGenerator.nextInt() % comemoracoes.size();
        /* implementação de sequencias diferentes
        sequenciaAtual.add(aleatorio);
        if (novaSequencia) {
            if (sequenciaAtual.containsAll(sequenciaAnterior)) {
                aleatorio = 
            }
            
        }*/
        return aleatorio;
    }
}
