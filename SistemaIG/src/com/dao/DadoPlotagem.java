/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import java.util.List;

/**
 *
 * @author Jânio Xavier
 */
public class DadoPlotagem {
    private List<Progresso> cadaProgresso;
    
    public void addProgresso(Progresso progesso) {
        cadaProgresso.add(progesso);
    }
    
    public List<Progresso> getCadaProgresso() {
        return cadaProgresso;
    } 
}
