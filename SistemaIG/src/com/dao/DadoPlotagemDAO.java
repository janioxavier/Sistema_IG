/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.controller.Progresso;
import com.controller.personagens.TipoPersonagem;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author janioxavier
 */
public class DadoPlotagemDAO extends SQLiteDataBase {    
    
    public DadoPlotagemDAO(String nameBD) throws ClassNotFoundException, SQLException {
        super(nameBD);
    }

    @Override
    public void createTable() throws SQLException {
        statement.executeUpdate("create table if not exists Progresso ("
                + "progressoJogador string, "
                + "responsavel string, "
                + "maiorNivelMenino int, maiorNivelMenina int, maiorNivelGato"
                + " int, maiorNivelCachorro int, "
                + "personagensMaisEscolhidos1 string, "                
                + "acoesMaisEscolhidas1 string"
                + ")");
    }

    @Override
    public void dropTable() throws SQLException {
        statement.executeUpdate("drop table if exists Progresso");
        statement.executeUpdate("create table Progresso ("
                + "progressoJogador string, "
                + "responsavel string, "
                + "maiorNivelMenino int, maiorNivelMenina int, maiorNivelGato"
                + " int, maiorNivelCachorro int, "
                + "personagensMaisEscolhidos1 string, "                
                + "acoesMaisEscolhidas1 string"
                + ")");
    }

    public void addProgresso(Progresso progresso) throws SQLException {
        if (progresso != null) {
            String values = "'" + progresso.getNickJogador() + "', " 
                    + "'" + progresso.getResponsavel() + "'"
                    + getMaiorNivelPersonagens(progresso)
                    + getPersonagensMaisEscolhidos(progresso)
                    + getAcoesMaisEscolhidas(progresso);
            statement.executeUpdate("insert into Progresso values("+values +")"
            );
        }
    }

    private String getPersonagensMaisEscolhidos(Progresso progresso) {
        String str = ", ";
        String[] personagens = progresso.getPersonagensMaisEscolhidos();
        int cont = 0;
        for (String personagem : personagens) {
            str += "'" + personagem + "'";
            cont++;
            if (cont < personagens.length) {
                str += ", ";
            }
        }
        for (int i = cont; i < progresso.NUMERO_PERSONAGENS_MAIS_ESCOLHIDOS; i++) {
            if (cont < progresso.NUMERO_PERSONAGENS_MAIS_ESCOLHIDOS) {
                str += ", ";
            }
            str += "''";
        }
        return str;
    }

    private String getAcoesMaisEscolhidas(Progresso progresso) {
        String str = ", ";
        String[] acoes = progresso.getAcoesMaisEscolhidas();
        int cont = 0;
        for (String acao : acoes) {
            str += "'" + acao + "'";
            cont++;
            if (cont < acoes.length) {
                str += ", ";
            }
        }        
        for (int i = cont; i < progresso.NUMERO_ACOES_MAIS_ESCOLHIDAS; i++) {
            if (cont < progresso.NUMERO_ACOES_MAIS_ESCOLHIDAS) {
                str += ", ";
            }
            str += "''";
        }
        
        return str;

    }

    private String getMaiorNivelPersonagens(Progresso progresso) {
        String str = ", ";
        TipoPersonagem[] values = TipoPersonagem.values();
        int cont = 0;
        for (TipoPersonagem tp : values) {
            str += progresso.getMaiorNivelAlcancado(tp);
            cont++;
            if (cont < values.length) {
                str += ", ";
            }
        }
        return str;
    }

    public List<Progresso> getTodosProgressos() throws SQLException {
        List<Progresso> todosProgressos = new ArrayList<>();
        ResultSet rs = statement.executeQuery("select * from Progresso");
        while (rs.next()) {
            todosProgressos.add(recuperarProgresso(rs));
        }
        return todosProgressos;
    }
    
    public List<Progresso> getTodosProgressos(String nickJogador) throws SQLException {
        List<Progresso> todosProgressos = new ArrayList<>();
        ResultSet rs = statement.executeQuery("select * from Progresso"
                + " where progressoJogador = " + "'"+nickJogador+"'");
        while(rs.next()) {
            todosProgressos.add(recuperarProgresso(rs));
        }
        return todosProgressos;
    }
    
    public List<Progresso> getTodosProgressosResponsavel(String responsavel)
            throws SQLException {
        List<Progresso> todosProgressos = new ArrayList<>();
        ResultSet rs = statement.executeQuery("select * from Progresso"
                + " where progressoJogador = " + "'"+responsavel+"'");
        while(rs.next()) {
            todosProgressos.add(recuperarProgresso(rs));
        }
        return todosProgressos;
    }

    private Progresso recuperarProgresso(ResultSet rs) throws SQLException {
        String[] personagensMaisEscolhidos;
        String[] acoesMaisEscolhidas;
        Progresso progresso;
        
        progresso = new Progresso(rs.getString("progressoJogador"), rs.getString("responsavel"));
        
        progresso.setMaiorNivelAlcancado(TipoPersonagem.MENINO, rs.getInt("maiorNivelMenino"));
        progresso.setMaiorNivelAlcancado(TipoPersonagem.MENINA, rs.getInt("maiorNivelMenina"));
        progresso.setMaiorNivelAlcancado(TipoPersonagem.GATO, rs.getInt("maiorNivelGato"));
        progresso.setMaiorNivelAlcancado(TipoPersonagem.CACHORRO, rs.getInt("maiorNivelCachorro"));

        personagensMaisEscolhidos = new String[Progresso.NUMERO_PERSONAGENS_MAIS_ESCOLHIDOS];
        for (int i = 0; i < personagensMaisEscolhidos.length; i++) {
            personagensMaisEscolhidos[i] = rs.getString("personagensMaisEscolhidos" + (i + 1));
        }
        progresso.setPersonagensMaisEscolhidos(personagensMaisEscolhidos);

        acoesMaisEscolhidas = new String[Progresso.NUMERO_ACOES_MAIS_ESCOLHIDAS];
        for (int i = 0; i < acoesMaisEscolhidas.length; i++) {
            acoesMaisEscolhidas[i] = rs.getString("acoesMaisEscolhidas" + (i + 1));
        }
        progresso.setAcoesMaisEscolhidas(acoesMaisEscolhidas);
        return progresso;
    }
    
    @Override
    public String mostrarTabela() throws SQLException {
        String str = "";        
        ResultSet rs = statement.executeQuery("select * from Progresso");        
        while(rs.next()) {
            str = getProgressoString(str, rs);                                 
        }
        return str;
    }
    
    public String mostrarTabela(String nickJogador) throws SQLException {
        String str = "";        
        ResultSet rs = statement.executeQuery("select * from Progresso"
                + " where progressoJogador = " + "'"+nickJogador+"'");
        while(rs.next()) {
            str = getProgressoString(str, rs);                                 
        }
        return str;
    }
    
    public boolean contemJogador(String jogador) {
        boolean contem = false;
        try {
            List<Progresso> cadaProgresso = getTodosProgressos(jogador);
            for (Progresso progresso : cadaProgresso) {
                if (progresso.getNickJogador().equals(jogador)) {
                    contem = true;
                    break;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DadoPlotagemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return contem;
    }

    private String getProgressoString(String str, ResultSet rs) throws SQLException {
        str +=    "progresso do jogador: " + rs.getString("progressoJogador") + "\n"
                + "responsavel: " + rs.getString("responsavel") + "\n"
                + "maior nivel menino: " + rs.getInt("maiorNivelMenino") + "\n"
                + "maior nivel menina: " + rs.getInt("maiorNivelMenina") + "\n"
                + "maior nivel gato: " + rs.getInt("maiorNivelGato") + "\n"
                + "maior nivel cachoro: " + rs.getInt("maiorNivelCachorro") + "\n"
                + "personagem mais escolhido: " + rs.getString("personagensMaisEscolhidos1") + "\n"                
                + "acoes mais escolhidas: " + rs.getString("acoesMaisEscolhidas1") + "\n";                
        return str;
    }

    public boolean contemResponsavel(String responsavel) {
        boolean contem = false;
        try {
            List<Progresso> cadaProgresso = getTodosProgressos();
            for (Progresso progresso : cadaProgresso) {
                if (progresso.getResponsavel().equals(responsavel)) {
                    contem = true;
                    break;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DadoPlotagemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return contem;
    }
}
