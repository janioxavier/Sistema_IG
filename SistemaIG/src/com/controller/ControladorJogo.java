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
    private Progresso progresso;
    private ContadorEscolha contadorEscolha;
    private DadoPlotagemDAO dpDAO;
    private List<Personagem> personagens;
    private AvaliadorImitacao avaliadorImitacao;    
    private OrdenadorAcoes ordenadorAcoes;
    private TelaJogoUI telaJogo;
    private TelaResponsavelUI telaResponsavel;
    
    public ControladorJogo() throws ClassNotFoundException, SQLException {
        dpDAO = new DadoPlotagemDAO(NOME_BANCO);
        contadorEscolha = new ContadorEscolha();
        ordenadorAcoes = new OrdenadorAcoes();
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
            progresso = todosProgressos.get(size-1);
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
            progresso = jogador.getProgresso();
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
    
    public int getNivelJogador() {
        return jogador.getMaiorNivelAlcancado();
    }
    
    public void atualizarNivelJogador(int nivel) {
        jogador.setMaiorNivelAlcancado(nivel);
    }
    
    /**
     * inicializa a jogada configurando o jogador e retornando uma lista
     * das ações a serem realizados pelo jogador
     * @param personagem personagem do jogo.
     * @param acao tipo de ação facial ou corporal.
     * @param nivel nivel do jogador
     * @return ações a serem realizadas pelo jogador.
     */
    public List<Acao> inicializarJogada(TipoPersonagem personagem, Acao acao,
            int nivel) {
        atualizarTipoPersonagem(personagem);
        atualizarNivelJogador(nivel);
        contarAcaoEscolhida(acao);
        return ordenadorAcoes.ordenarAcoes(nivel, acao);
    }
    
    private void contarAcaoEscolhida(Acao acao) {
        if (acao instanceof TipoFacial) {
            contadorEscolha.incrementarAcao(TipoAcao.Facial);
        } else if (acao instanceof TipoCorporal){
            contadorEscolha.incrementarAcao(TipoAcao.Corporal);
        }
    }
    
    private void atualizarTipoPersonagem(TipoPersonagem personagem) {
        jogador.setTipoPersonagem(personagem);
        contadorEscolha.incrementarPersonagem(personagem);
    }
    
    
    /**
     * avaliar a imitação e retorna o resultado da imitação
     * @param acao ação escolhida pelo usuário
     * @return true se ação foi realizada com sucesso, false cc.
     */
    public boolean avaliarImitacao(Acao acao) {        
        return avaliadorImitacao.verificarImitacao(acao);
    }        
    
    public Jogador getJogador() {
        return jogador;
    }
    
    /**
     * Armazena o progresso do jogador
     * @throws SQLException caso ocorra um erro no banco
     */
    public void armazenarProgresso() throws SQLException {
        String[] acaoMaisEscolhida = {
            contadorEscolha.getAcaoMaisEscolhida().getNome()};
        String[] personagemMaisEscolhido = {
            contadorEscolha.getPersonagemMaisEscolhida().getNome()};
        
        progresso.setAcoesMaisEscolhidas(acaoMaisEscolhida);
        progresso.setPersonagensMaisEscolhidos(personagemMaisEscolhido);
        
        dpDAO.addProgresso(progresso);
    }
    
    public DadoPlotagem getDadosPlotagem() throws SQLException {
        return new DadoPlotagem(dpDAO.getTodosProgressos());        
    }        
    
    public void encerrar() throws SQLException {
        dpDAO.close();        
    }    
}
