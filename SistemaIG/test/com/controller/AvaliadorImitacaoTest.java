/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.controller.acoes.Acao;
import com.dao.Jogador;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jânio Xavier
 */
public class AvaliadorImitacaoTest {        
    private Jogador jogador;
    public AvaliadorImitacaoTest() {
        jogador = new Jogador("João", "Peixe");        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getSucessosSucessivos method, of class AvaliadorImitacao.
     */
    @Test
    public void testGetSucessosSucessivos() {
        System.out.println("getSucessosSucessivos");
        AvaliadorImitacao instance = new AvaliadorImitacao(jogador);
        int expResult = 0;
        int result = instance.getSucessosSucessivos();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFalhasSucessivas method, of class AvaliadorImitacao.
     */
    @Test
    public void testGetFalhasSucessivas() {
        System.out.println("getFalhasSucessivas");
        AvaliadorImitacao instance = new AvaliadorImitacao(jogador);
        int expResult = 0;
        int result = instance.getFalhasSucessivas();
        assertEquals(expResult, result);        
    }

    /**
     * Test of verificarImitacao method, of class AvaliadorImitacao.
     */
    @Test
    public void testVerificarImitacao() {
        System.out.println("verificarImitacao");
        Acao imitacao = null;
        AvaliadorImitacao instance = new AvaliadorImitacao(jogador);
        instance.verificarImitacao(imitacao);        
    }

    /**
     * Test of zerarSucessosFalhas method, of class AvaliadorImitacao.
     */
    @Test
    public void testZerarSucessosFalhas() {
        System.out.println("zerarSucessosFalhas");
        AvaliadorImitacao instance = new AvaliadorImitacao(jogador);
        instance.verificarImitacao(null);
        instance.verificarImitacao(null);
        instance.verificarImitacao( null);
        instance.zerarSucessosFalhas();
        assertEquals(0, instance.getFalhasSucessivas());
        assertEquals(0, instance.getSucessosSucessivos());
                
    }
    
}
