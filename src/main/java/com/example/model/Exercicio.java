package com.example.model;

public class Exercicio {
    
    private Long id;
    private String nomeExerc;
    private Integer repeticoes;
    private Treino treino;


    public Exercicio(Long id, String nomeExerc, Integer repeticoes, Treino treino) {
        this.id = id;
        this.nomeExerc = nomeExerc;
        this.repeticoes = repeticoes;
        this.treino = treino;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getNomeExerc() {
        return nomeExerc;
    }


    public void setNomeExerc(String nomeExerc) {
        this.nomeExerc = nomeExerc;
    }


    public Integer getRepeticoes() {
        return repeticoes;
    }


    public void setRepeticoes(Integer repeticoes) {
        this.repeticoes = repeticoes;
    }


    public Treino getTreino() {
        return treino;
    }


    public void setTreino(Treino treino) {
        this.treino = treino;
    }


	public Exercicio NomeExerc(String nomeExerc) {
        this.nomeExerc = nomeExerc;
		return this;
	}


    public Exercicio repeticoes(Integer repeticoes) {
        this.repeticoes = repeticoes;
        return this;
    }

    

    

    
    
}
