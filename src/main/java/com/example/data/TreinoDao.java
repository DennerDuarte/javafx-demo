package com.example.data;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.example.model.Treino;

public class TreinoDao {
    
     static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    static final String USER = "rm550531";
    static final String PASS = "300704";

    public static void inserir(Treino treino) throws SQLException {
        var conexao = DriverManager.getConnection(URL, USER, PASS);

        var sql = "INSERT INTO treino (nomeAluno, tipoTreino) VALUES (?, ?) ";
        var comando = conexao.prepareStatement(sql);
        comando.setString(1, treino.getNomeAluno());
        comando.setString(2, treino.getTipoTreino());

        comando.executeUpdate();

        conexao.close();

    }

    public static List<Treino> buscarTodos() throws SQLException {
        var lista = new ArrayList<Treino>();

        var conexao = DriverManager.getConnection(URL, USER, PASS);
        var comando = conexao.prepareStatement("SELECT * FROM treino");
        var resultado = comando.executeQuery();

        while (resultado.next()) {
            lista.add(new Treino(
                    resultado.getString("nomeAluno"),
                    resultado.getString("tipoTreino")
            ));
                    
        }

        conexao.close();
        return lista;
    }

}
