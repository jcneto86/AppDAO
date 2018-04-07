/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;
import java.util.Date;

public class RentFilm
{
    private int id_locacao;
    private int id_cliente;
    private int  id_filme;
    private Date data_locacao;
    private Date data_devolucao;

    public RentFilm() {
    }

    public RentFilm(int id_locacao, int id_cliente, int id_filme, Date data_locacao, Date data_devolucao) {
        this.id_locacao = id_locacao;
        this.id_cliente = id_cliente;
        this.id_filme = id_filme;
        this.data_locacao = data_locacao;
        this.data_devolucao = data_devolucao;
    }

    public int getId_locacao() {
        return id_locacao;
    }

    public void setId_locacao(int id_locacao) {
        this.id_locacao = id_locacao;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_filme() {
        return id_filme;
    }

    public void setId_filme(int id_filme) {
        this.id_filme = id_filme;
    }

    public Date getData_locacao() {
        return data_locacao;
    }

    public void setData_locacao(Date data_locacao) {
        this.data_locacao = data_locacao;
    }

    public Date getData_devolucao() {
        return data_devolucao;
    }

    public void setData_devolucao(Date data_devolucao) {
        this.data_devolucao = data_devolucao;
    }

    @Override
    public String toString() {
        return "RentFilm{" +
                "id_locacao=" + id_locacao +
                ", id_cliente=" + id_cliente +
                ", id_filme=" + id_filme +
                ", data_locacao=" + data_locacao +
                ", data_devolucao=" + data_devolucao +
                '}';
    }
}
