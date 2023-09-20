package com.example;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.data.ExercicioDao;
import com.example.data.TreinoDao;
import com.example.model.Exercicio;
import com.example.model.Treino;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class PrimaryController implements Initializable {

    @FXML TextField txtNomeAluno;
    @FXML TextField txtTipoTreino;

    @FXML TextField txtNomeExerc;
    @FXML TextField txtNumeroExercicios;
    @FXML TextField txtTipoExerc;

    @FXML TableView<Treino> tabelaTreino;
    @FXML TableView<Exercicio> tabelaExercicio;
    
    @FXML TableColumn<Treino, String> colAluno;
    @FXML TableColumn<Treino, String> colTipoTreino;
    @FXML TableColumn<Treino, String> colExerciciosDoTreino;
    
    @FXML TableColumn<Exercicio, String> colNomeExerc;
    @FXML TableColumn<Exercicio, Integer> colRepeticoes;
    @FXML TableColumn<Exercicio, String> colTipoExerc;


    public void adicionaExercicio(){
        var exercicio = new Exercicio(
            null,
            txtNomeExerc.getText(),
            txtTipoExerc.getText(),
            Integer.valueOf(txtNumeroExercicios.getText())
        );

        try {
            ExercicioDao.inserir(exercicio);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void adicionarTreino(){
        var treino = new Treino(
            txtNomeAluno.getText(),
            txtTipoTreino.getText()
        );

        try {
            TreinoDao.inserir(treino);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void carregar(){
        tabelaExercicio.getItems().clear();
        tabelaTreino.getItems().clear();

       try {
            var exercicios = ExercicioDao.buscarTodos();
            exercicios.forEach(exercicio -> tabelaExercicio.getItems().add(exercicio)); 
        } catch (Exception e) {
            e.printStackTrace();      
        }

        try {
            var treinos = ExercicioDao.buscarTodos();
            treinos.forEach(exercicio -> tabelaExercicio.getItems().add(exercicio)); 
        } catch (Exception e) {
            e.printStackTrace();      
        }
    }


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        colAluno.setCellValueFactory(new PropertyValueFactory<>("aluno"));
        colExerciciosDoTreino.setCellValueFactory(new PropertyValueFactory<>("exercicios do treino"));
        colNomeExerc.setCellValueFactory(new PropertyValueFactory<>("nomeExerc"));
        colRepeticoes.setCellValueFactory(new PropertyValueFactory<>("repeticoes"));
        colTipoExerc.setCellValueFactory(new PropertyValueFactory<>("tipoExerc"));
        colTipoTreino.setCellValueFactory(new PropertyValueFactory<>("tipoTreino"));

        carregar();
    }

}
