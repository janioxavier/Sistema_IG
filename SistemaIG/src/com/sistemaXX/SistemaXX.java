/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemaXX;

import com.controller.acoes.Acao;
import java.util.Random;

/**
 *
 * @author Jânio Xavier
 */
public class SistemaXX {
    private Random randomGenerator;
    
    public SistemaXX() {
        randomGenerator = new Random(System.currentTimeMillis());
    }
    
    /**
     * 
     * @param imitacao imitação do jogado
     * @return o grau de imitação da ação
     */
    public GrauImitacao avaliarImitacao(Acao imitacao) {
        GrauImitacao[] values = GrauImitacao.values();
        int grau = randomGenerator.nextInt(values.length);        
        return values[grau];
    }
}
