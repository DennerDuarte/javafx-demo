package com.example.model;

public class Treino{

    
    private String nomeAluno;
    private String tipoTreino;
    

    public Treino(String nomeAluno, String tipoTreino) {
            this.nomeAluno = nomeAluno;
            this.tipoTreino = tipoTreino;
        }

    public String getNomeAluno() {
        return nomeAluno;
    }
    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }
    public String getTipoTreino() {
        return tipoTreino;
    }
    public void setTipoTreino(String tipoTreino) {
        this.tipoTreino = tipoTreino;
    }
   

}
