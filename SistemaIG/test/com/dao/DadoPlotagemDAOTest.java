/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.controller.Acao;
import com.controller.TipoCorporal;
import com.controller.TipoFacial;
import com.controller.TipoPersonagem;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jânio Xavier
 */
public class DadoPlotagemDAOTest {

    private final String nameBD = "testSistemaIG.bd";

    public DadoPlotagemDAOTest() {

    }    

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }
    
    private Progresso getProgresso() {
        Progresso progresso = new Progresso("joão", "Mario");
        for (TipoPersonagem tp : TipoPersonagem.values()) {
            progresso.setMaiorNivelAlcancado(tp, 2);
        }
        
        progresso.setAcoesMaisEscolhidas(new String[] {"corporal"});
        progresso.setPersonagensMaisEscolhidos(new String[] {"gato"});                                        
        return progresso;
    }

    /**
     * Test of createTable method, of class DadoPlotagemDAO.
     */
    @org.junit.Test
    public void testCreateTable() throws SQLException, ClassNotFoundException {
        System.out.println("createTable");
        DadoPlotagemDAO instance = new DadoPlotagemDAO(nameBD);
        instance.createTable();

    }

    /**
     * Test of dropTable method, of class DadoPlotagemDAO.
     */
    @org.junit.Test
    public void testDropTable() throws Exception {
        System.out.println("dropTable");
        DadoPlotagemDAO instance = new DadoPlotagemDAO(nameBD);
        instance.dropTable();                
    }

    /**
     * Test of addProgresso method, of class DadoPlotagemDAO.
     */
    @org.junit.Test
    public void testAddProgresso() throws Exception {
        System.out.println("addProgresso");                
        DadoPlotagemDAO instance = new DadoPlotagemDAO(nameBD);
        instance.addProgresso(getProgresso());
        // TODO review the generated test code and remove the default call to fail.        
    }

    /**
     * Test of getTodosProgressos method, of class DadoPlotagemDAO.
     */
    @org.junit.Test
    public void testGetTodosProgressos() throws Exception {
        System.out.println("getTodosProgressos");
        DadoPlotagemDAO instance = new DadoPlotagemDAO(nameBD); 
        instance.dropTable();
        List<Progresso> result = instance.getTodosProgressos();
        assertTrue(result != null);                
    }
    
    @org.junit.Test
    public void testMostrarTabela() throws Exception {        
        System.out.println("mostrarTabela");
        DadoPlotagemDAO instance = new DadoPlotagemDAO(nameBD);
        instance.dropTable();
        instance.addProgresso(getProgresso());
        instance.addProgresso(getProgresso());     
        System.out.println(instance.mostrarTabela("joão"));
    }
}
