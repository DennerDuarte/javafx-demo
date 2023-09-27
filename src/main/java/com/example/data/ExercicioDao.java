package com.example.data;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Exercicio;
import com.example.model.Treino;

public class ExercicioDao {

    private static Connection conexao;

    public ExercicioDao() throws SQLException {
        conexao = ConnectioFactory.getConnection();
    }

    public static void inserir(Exercicio exercicio) throws SQLException {
        var sql = "INSERT INTO exercicios (nomeExerc, repeticoes, treino) VALUES(?, ?, ?)";
        var comando = conexao.prepareStatement(sql);
        comando.setString(1, exercicio.getNomeExerc());
        comando.setInt(2, exercicio.getRepeticoes());
        comando.setString(3, exercicio.getTreino().getTipoTreino());
        comando.executeUpdate();
    }

    public static List<Exercicio> buscarTodos() throws SQLException{
        var listaExerc = new ArrayList<Exercicio>();

        var comando = conexao.prepareStatement("SELECT exercicio.*, treino.nomeAluno, treino.tipoTreino FROM exercicios INNER JOIN treino on exercicio.treino_id=treino.id");
        var resultado = comando.executeQuery();

        while(resultado.next()){
            listaExerc.add(new Exercicio(
                resultado.getLong("id"),
                resultado.getString("nomeExerc"),
                resultado.getInt("repeticoes"),
                new Treino(
                    resultado.getLong("id"),
                    resultado.getString("nomeAluno"),
                    resultado.getString("tipoTreino")
                )
            ));
        }
        return listaExerc;
    }

	public static void apagar(Long id) throws SQLException{
        var comando = conexao.prepareStatement("DELETE FROM exercicios WHERE id =?");
        comando.setLong(1, id);
        comando.executeUpdate();
	}

    public static void atualizar(Exercicio exercicio) throws SQLException {
        var comando = conexao.prepareStatement("UPDATE exercicios SET nomeAluno = ?, repeticoes = ? WHERE id=?");
        comando.setString(1, exercicio.getNomeExerc());
        comando.setInt(2, exercicio.getRepeticoes());
        comando.setLong(3, exercicio.getId());
        comando.executeUpdate();
        
    }

   

}
