/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.DadoPlotagem;
import com.dao.DadoPlotagemDAO;
import com.dao.Jogador;
import com.dao.Personagem;
import com.dao.Progresso;
import com.sistemaXX.SistemaXX;
import com.visao.TelaJogo;
import com.visao.TelaJogoUI;
import com.visao.TelaResponsavel;
import com.visao.TelaResponsavelUI;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Jânio Xavier
 */
public class ControladorJogo {
    private static final String NOME_BANCO = "dados_jogo.db";
    private Jogador jogador;
    private DadoPlotagemDAO dpDAO;
    private List<Personagem> personagens;
    private AvaliadorImitacao avaliadorImitacao;    
    private Cronometro cronometro;
    private TelaJogoUI telaJogo;
    private TelaResponsavelUI telaResponsavel;
    
    public ControladorJogo() throws ClassNotFoundException, SQLException {
        dpDAO = new DadoPlotagemDAO(NOME_BANCO);
    }
    
    /**
     * inicia o jogo passando o nome do jogador
     * @param nome nome do jogador     
     * @return true se o nome do jogador é novo, false cc.
     */
    public boolean iniciarJogo(String nomeJogador) throws SQLException {
        boolean novoNome = !dpDAO.contemJogador(nomeJogador);        
        if (!novoNome) {            
            List<Progresso> todosProgressos = dpDAO.getTodosProgressos(nomeJogador);
            int size = todosProgressos.size();
            jogador = new Jogador(todosProgressos.get(size-1));
        }
        return novoNome;
    } 
    
    /**
     * inicia o jogo passando o nome do jogador e seu responsável.
     * @param nome nome do jogador
     * @param responsavel responsável do jogador
     * @return true se o nome do jogador é novo, false cc.
     */
    public boolean iniciarJogo(String nome, String responsavel) {
        boolean novoNome = !dpDAO.contemJogador(nome);
        
        if (novoNome) {
            telaJogo = new TelaJogoUI();
            jogador = new Jogador(nome, responsavel);            
        } else {
            
        }        
        return novoNome;
    }
    
    /**
     * 
     * @param responsavel
     * @return true se existe um responsável com dado nome, false cc.
     */
    public boolean iniciaAreaResponsavel(String responsavel) {
       boolean existeResponsavel = dpDAO.contemResponsavel(responsavel); 
       if (existeResponsavel) {
           telaResponsavel = new TelaResponsavelUI();
       }
       return existeResponsavel;
    }
    
    public void aguadarAcao() {
                
    }
    
    public void realizarAcao() {
        
    }
    
    public void avaliarImitacao() {
        
    }
    
    public void comemorarAcerto() {
        
    }
    
    public Jogador getJogador() {
        return jogador;
    }
    
    public void armazenarProgresso() {
        
    }
    
    public DadoPlotagem gerarDadosPlotagem() {
        return null;
    }
    
    public void encerrar() {
        
    }    
}
