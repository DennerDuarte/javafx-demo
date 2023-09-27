package com.example.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Exercicio;
import com.example.model.Treino;

public class TreinoDao {

    static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    static final String USER = "rm550531";
    static final String PASS = "300704";   

    public static void inserir (Treino treino) throws SQLException {
        var conexao = DriverManager.getConnection(URL, USER, PASS);

        var sql = "INSERT INTO treino (id, nomeAluno, tipoTreino) VALUES (?, ?, ?) ";
        var comando = conexao.prepareStatement(sql);
        comando.setLong(1, treino.getId()); 
        comando.setString(2, treino.getNomeAluno());
        comando.setString(3, treino.getTipoTreino());
        comando.executeUpdate();

        conexao.close();
    }   

    public static List <Treino> buscarTodos() throws SQLException{
        var lista = new ArrayList<Treino>();

        var conexao = DriverManager.getConnection(URL, USER, PASS);
        var comando = conexao.prepareStatement("SELECT treino.*, exercicio.id, exercicio.nomeExerc, exercicio.repeticao, exercicio.treino");    
        var resultado = comando.executeQuery();

        while(resultado.next()){
            lista.add (new Treino(
                resultado.getLong("id"),
                resultado.getString("nomeAluno"),
                resultado.getString("tipoTreino")
            ));
        }
        
        conexao.close();
        return lista;
    }

    public static void apagar(Long id) throws SQLException{
        var conexao = DriverManager.getConnection(URL, USER, PASS);
        var comando = conexao.prepareStatement("DELETE FROM WHERE id=?");
        comando.setLong(1, id);
        comando.executeUpdate();
        conexao.close();
    }

    public static void atualizar(Treino treino) throws SQLException{
        var conexao = DriverManager.getConnection(URL, USER, PASS);
        var comando = conexao.prepareStatement("UPDATE treino SET nomeAluno=?, tipoExerc=?, WHERE id=?");

        comando.setLong(1, treino.getId());
        comando.setString(2, treino.getNomeAluno());
        comando.setString(3, treino.getTipoTreino());
        comando.executeUpdate();
        conexao.close();
    }

}
