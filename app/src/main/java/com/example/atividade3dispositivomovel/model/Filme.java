package com.example.atividade3dispositivomovel.model;

public class Filme {

    private String titulo;
    private String descricao;
    private String ano;
    private String diretor;
    private String urlImage;

    public Filme() {
    }

    public Filme(String titulo, String descricao, String ano, String diretor, String urlImage) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.ano = ano;
        this.diretor = diretor;
        this.urlImage = urlImage;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
