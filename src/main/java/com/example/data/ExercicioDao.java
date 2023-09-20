package com.example.data;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Exercicio;

public class ExercicioDao {

    static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    static final String USER = "rm550531";
    static final String PASS = "300704";

    public static void inserir(Exercicio exercicio) throws SQLException {
        var conexao = DriverManager.getConnection(URL, USER, PASS);

        var sql = "INSERT INTO exercicios (id_exerc, exercicio, tipoExerc, repeticao) VALUES (?, ?, ?, ?) ";
        var comando = conexao.prepareStatement(sql);
        comando.setLong(1, exercicio.getId());
        comando.setString(1, exercicio.getExercicio());
        comando.setInt(2, exercicio.getRepeticao());
        comando.setString(3, exercicio.getTipoExerc());

        comando.executeUpdate();

        conexao.close();

    }

    public static List<Exercicio> buscarTodos() throws SQLException {
        var lista = new ArrayList<Exercicio>();

        var conexao = DriverManager.getConnection(URL, USER, PASS);
        var comando = conexao.prepareStatement("SELECT * FROM exercicio");
        var resultado = comando.executeQuery();

        while (resultado.next()) {
            lista.add(new Exercicio(
                    resultado.getLong("id"),
                    resultado.getString("exercicio"),
                    resultado.getString("tipoExerc"),
                    resultado.getInt("repeticao")
            ));
                    
        }

        conexao.close();
        return lista;
    }

}
