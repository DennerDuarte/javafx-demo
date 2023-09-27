package com.example.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectioFactory {

    static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    static final String USER = "rm550531";
    static final String PASS = "300704";

    private static Connection conexao;

    public static Connection getConnection() throws SQLException{
        if(conexao == null || conexao.isClosed()){
            conexao = DriverManager.getConnection(URL, USER, PASS);
        }
        return conexao;
    }
}
