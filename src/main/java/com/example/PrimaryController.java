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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class PrimaryController implements Initializable {

    @FXML TextField txtNomeAluno;
    @FXML TextField txtTipoTreino;

    @FXML TextField txtNomeExerc;
    @FXML TextField txtNumeroExercicios;
    @FXML ComboBox<Treino> cbTipoExerc;

    @FXML TableView<Treino> tabelaTreino;
    @FXML TableView<Exercicio> tabelaExercicio;
    
    @FXML TableColumn<Treino, String> colAluno;
    @FXML TableColumn<Treino, String> colTipoTreino;

    
    @FXML TableColumn<Exercicio, String> colNomeExerc;
    @FXML TableColumn<Exercicio, Integer> colRepeticoes;
    @FXML TableColumn<Exercicio, String> colTipoExerc;
    
    ExercicioDao exercicioDao;
    TreinoDao treinoDao;

    public void adicionarExercicio(){
        var exercicio = new Exercicio(
            null,
            txtNomeExerc.getText(),
            Integer.valueOf(txtNumeroExercicios.getText()),
            cbTipoExerc.getSelectionModel().getSelectedItem()
        );
        
        try {
            ExercicioDao.inserir(exercicio);
            tabelaExercicio.getItems().add(exercicio);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void carregarExercicio(){
        tabelaExercicio.getItems().clear();

        try{
            var exercicios = ExercicioDao.buscarTodos();
            exercicios.forEach(exercicio -> tabelaExercicio.getItems().add(exercicio));
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void adicionarTreino(){
        var treino = new Treino(
            null,
            txtNomeAluno.getText(),
            txtTipoTreino.getText()
            );

            try {
                TreinoDao.inserir(treino);
                tabelaTreino.getItems().add(treino);
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    public void carregarTreino(){
        tabelaTreino.getItems().clear();
        try {
            var treinos = TreinoDao.buscarTodos();
            treinos.forEach(treino -> tabelaTreino.getItems().add(treino));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void apagarExercicio(){
        var exercicio = tabelaExercicio.getSelectionModel().getSelectedItem();
        if( exercicio == null){
            mostrarMensagem("Erro", "Você deve selecionar um veículo para apagar");
            return;
        }
        try {
            ExercicioDao.apagar(exercicio.getId());
            tabelaExercicio.getItems().remove(exercicio);
        } catch (SQLException e) {
            mostrarMensagem("Erro", "Erro o apagar");
        }
    }

    public void atualizarExercicio(Exercicio exercicio){
         try {
            ExercicioDao.atualizar(exercicio);
        } catch (SQLException e) {
            mostrarMensagem("Erro", "Erro ao atualizar dados");
            e.printStackTrace();
        }
    }

    private void mostrarMensagem(String titulo, String mensagem) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setHeaderText(titulo);
        alert.setContentText(mensagem);
        alert.show();
    }
    
    public void initialize(URL arg0, ResourceBundle arg1) {
        colNomeExerc.setCellValueFactory(new PropertyValueFactory<>("nomeExercicio"));
        colNomeExerc.setCellFactory(TextFieldTableCell.forTableColumn());
        colNomeExerc.setOnEditCommit(e -> atualizarExercicio(e.getRowValue().NomeExerc(e.getNewValue())));

        colRepeticoes.setCellValueFactory(new PropertyValueFactory<>("repeticoes"));
        colRepeticoes.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        colRepeticoes.setOnEditCommit(e -> atualizarExercicio(e.getRowValue().repeticoes(e.getNewValue())));

        try {
            exercicioDao = new ExercicioDao();
            treinoDao = new TreinoDao();
            cbTipoExerc.getItems().addAll(TreinoDao.buscarTodos());
        } catch (Exception e1) {
             mostrarMensagem("Erro", "Erro ao buscar clientes");
            e1.printStackTrace();
        }

        carregarExercicio();
        carregarTreino();

        tabelaExercicio.setEditable(true);
        tabelaTreino.setEditable(true);
    } 


    
    

}
