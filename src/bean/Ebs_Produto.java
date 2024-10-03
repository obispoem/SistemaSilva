/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import java.util.Date;

/**
 *
 * @author bispo
 */
public class Ebs_Produto {
    int ebs_id_produto;
    String ebs_nome;
    int ebs_fk_categoria;
    Date ebs_data_chegada;
    Date ebs_data_validade;
    double ebs_valor;
    int ebs_estoque;

    public Ebs_Produto() {
    }

    public int getEbs_id_produto() {
        return ebs_id_produto;
    }

    public void setEbs_id_produto(int ebs_id_produto) {
        this.ebs_id_produto = ebs_id_produto;
    }

    public String getEbs_nome() {
        return ebs_nome;
    }

    public void setEbs_nome(String ebs_nome) {
        this.ebs_nome = ebs_nome;
    }

    public int getEbs_fk_categoria() {
        return ebs_fk_categoria;
    }

    public void setEbs_fk_categoria(int ebs_fk_categoria) {
        this.ebs_fk_categoria = ebs_fk_categoria;
    }

    public Date getEbs_data_chegada() {
        return ebs_data_chegada;
    }

    public void setEbs_data_chegada(Date ebs_data_chegada) {
        this.ebs_data_chegada = ebs_data_chegada;
    }

    public Date getEbs_data_validade() {
        return ebs_data_validade;
    }

    public void setEbs_data_validade(Date ebs_data_validade) {
        this.ebs_data_validade = ebs_data_validade;
    }

    public double getEbs_valor() {
        return ebs_valor;
    }

    public void setEbs_valor(double ebs_valor) {
        this.ebs_valor = ebs_valor;
    }

    public int getEbs_estoque() {
        return ebs_estoque;
    }

    public void setEbs_estoque(int ebs_estoque) {
        this.ebs_estoque = ebs_estoque;
    }
    
    
    
}
