package com.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jânio Xavier
 */
public abstract class SQLiteDataBase {

    private Connection connection; 
    protected Statement statement;    

    public SQLiteDataBase(String nameDB) throws ClassNotFoundException, SQLException {
        // load the sqlite-JDBC driver using the current class loader
        Class.forName("org.sqlite.JDBC");
        connection = null;
        // create a database connection
        connection = DriverManager.getConnection("jdbc:sqlite:" + nameDB);
        statement = connection.createStatement();
        statement.setQueryTimeout(5);  // set timeout to 30 sec.
        createTable();
    }

    public abstract void createTable() throws SQLException;
    public abstract void dropTable() throws SQLException;

    public void createJogadorTable() throws SQLException {
        statement.executeUpdate("drop table if exists person");
        statement.executeUpdate("create table person (id integer, name string)");
        statement.executeUpdate("insert into person values(1, 'leo')");
        statement.executeUpdate("insert into person values(2, 'yui')");
    }
    
    public int getInt(String tableName, String fieldName) throws SQLException {
        ResultSet rs = statement.executeQuery("select * from " + tableName);
        return rs.getInt(fieldName);
    }
    
    public void close() throws SQLException {
        connection.close();
    }
    
    public abstract String mostrarTabela() throws SQLException;            

    public void main(String[] args) throws ClassNotFoundException {
        try {
            ResultSet rs = statement.executeQuery("select * from person");
            while (rs.next()) {
                // read the result set
                System.out.println("name = " + rs.getString("name"));
                System.out.println("id = " + rs.getInt("id"));
            }
        } catch (SQLException e) {
            // if the error message is "out of memory", 
            // it probably means no database file is found
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e);
            }
        }
    }
}
