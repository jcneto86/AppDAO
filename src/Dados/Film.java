/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

public class Film {
    private int id_filme;
    private String titulo, descricao;
    private int ano;

    public Film() {
    }

    public Film(int id_filme, String titulo, String descricao, int ano) {
        this.id_filme = id_filme;
        this.titulo = titulo;
        this.descricao = descricao;
        this.ano = ano;
    }

    public int getId_filme() {
        return id_filme;
    }

    public void setId_filme(int id_filme) {
        this.id_filme = id_filme;
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

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id_filme=" + id_filme +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", ano='" + ano + '\'' +
                '}';
    }
}
