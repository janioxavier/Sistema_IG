/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.controller.acoes.TipoAcao;
import com.controller.acoes.Acao;
import com.controller.acoes.TipoFacial;
import com.controller.acoes.TipoCorporal;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jânio Xavier
 */
public class OrdenadorAcoesTest {
    
    public OrdenadorAcoesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of ordenarAcoes method, of class OrdenadorAcoes.
     */
    @Test
    public void testOrdenarAcoes() {
        System.out.println("ordenarAcoes");
        int nivel = 6;
        TipoAcao tipoAcao = TipoAcao.FACIAL;
        OrdenadorAcoes instance = new OrdenadorAcoes();        
        List<Acao> result = instance.ordenarAcoes(nivel, tipoAcao);        
        assertEquals(6, result.size());        
        
        for (Acao acao : result) {
            if(acao instanceof TipoFacial) {
                System.out.println(((TipoFacial) acao).name());
            } else if(acao instanceof TipoCorporal) {
                System.out.println(((TipoCorporal) acao).name());
            }
        }
    }
        
}
