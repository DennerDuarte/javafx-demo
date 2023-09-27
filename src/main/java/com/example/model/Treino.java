package com.example.model;

public class Treino{

    private Long id;
    private String nomeAluno;
    private String tipoTreino;
    


    public Treino(Long id, String nomeAluno, String tipoTreino) {
        this.id = id;
        this.nomeAluno = nomeAluno;
        this.tipoTreino = tipoTreino;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString(){
        return nomeAluno;
    }

    

   

}
