/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jânio Xavier
 */
public class JogadorDAO extends SQLiteDataBase{    

    public JogadorDAO(String nameDB) throws ClassNotFoundException, SQLException {
        super(nameDB);
    }
    
    /**
     * 
     * @param jogador jogador do jogo
     * @return true se foi inserido false caso contrário
     */
    public boolean addJogador(Jogador jogador) {
        boolean sucesso = false;
        String values = ("'" + jogador.getNome()+"', "
                        + "'" + jogador.getResponsavel() + "'");
        try {
            statement.execute("insert into Jogador(" + values + ")");
            sucesso = true;
        } catch (SQLException ex) {            
            Logger.getLogger(JogadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sucesso;
    }

    @Override
    public void createTable() throws SQLException {
        String tableField = "(nome string primary key,"
                            + " responsavel string)";
        statement.execute("create table if not exists Jogador" + tableField);
    }

    @Override
    public void dropTable() throws SQLException {
        statement.execute("drop table if exists Jogador");
        String tableField = "(nome string primary key,"
                            + " responsavel string)";
        statement.execute("create table Jogador" + tableField);
    }

    @Override
    public String mostrarTabela() throws SQLException {
        String str = "";
        ResultSet rs = statement.executeQuery("select * from Jogador");
        while(rs.next()) {
            str+= "nome: " + rs.getString("nome") + "\n"
                + "responsavel" + rs.getString("responsavel") + "\n";           
        }
        return str;
    }
    
    public List<Jogador> getTodosJogadores() throws SQLException {
        List<Jogador> todosJogadores = new ArrayList<>();
        ResultSet rs = statement.executeQuery("select * from Jogador");
        while(rs.next()) {
            todosJogadores.add(recuperarJogador(rs));
        }
        return todosJogadores;
    }
    
    public Jogador recuperarJogador(ResultSet rs) throws SQLException {
        Jogador jogador;
        jogador = new Jogador(rs.getString("nome"), rs.getString("responsavel"), null, 0);        
        return jogador;
    }
    
}
