/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.visao;

import com.controller.DadoPlotagem;
import com.controller.Progresso;
import com.controller.TipoPersonagem;
import java.util.Arrays;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jânio Xavier
 */
public class TelaResponsavelUITest {
    private DadoPlotagem dadoPlotagem;
    
    public TelaResponsavelUITest() {
        Progresso[] progressos = {
            new Progresso("joão", "pai"),
            new Progresso("maria", "pai"),
            new Progresso("rebeca", "pai")
        };
        
        progressos[0].setAcoesMaisEscolhidas(new String[]{"corporal"});
        progressos[1].setAcoesMaisEscolhidas(new String[]{"facial"});
        progressos[2].setAcoesMaisEscolhidas(new String[]{"facial"});
        
        progressos[0].setPersonagensMaisEscolhidos(new String[]{"gato"});
        progressos[1].setPersonagensMaisEscolhidos(new String[]{"menino"});
        progressos[2].setPersonagensMaisEscolhidos(new String[]{"menina"});
        
        progressos[0].setMaiorNivelAlcancado(TipoPersonagem.MENINA, 2);
        progressos[1].setMaiorNivelAlcancado(TipoPersonagem.MENINO, 6);
        progressos[2].setMaiorNivelAlcancado(TipoPersonagem.GATO, 1);        
        
        dadoPlotagem = new DadoPlotagem(Arrays.asList(progressos));        
    }
    
    public DadoPlotagem getDadosPlotagem() {
        return dadoPlotagem;
    }
        
    
    public static void main(String[] args) {        
        TelaResponsavelUITest teste = new TelaResponsavelUITest();
        TelaResponsavelUI.inicializarJanela(teste.getDadosPlotagem());
    }    
}
