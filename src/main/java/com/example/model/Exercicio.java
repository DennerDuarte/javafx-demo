package com.example.model;

public class Exercicio {
    
    private Long id;
    private String exercicio;
    private String tipoExerc;
    private int repeticao;
    
    
    public Exercicio(Long id, String exercicio, String tipoExerc, int repeticao) {
        this.id = id;
        this.exercicio = exercicio;
        this.tipoExerc = tipoExerc;
        this.repeticao = repeticao;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getExercicio() {
        return exercicio;
    }


    public void setExercicio(String exercicio) {
        this.exercicio = exercicio;
    }


    public String getTipoExerc() {
        return tipoExerc;
    }


    public void setTipoExerc(String tipoExerc) {
        this.tipoExerc = tipoExerc;
    }


    public int getRepeticao() {
        return repeticao;
    }


    public void setRepeticao(int repeticao) {
        this.repeticao = repeticao;
    }
    
    
   
    
    
    
}
