/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;
import java.sql.Date;

/**
 *
 * @author bispo
 */
public class Ebs_Usuario {
    int ebs_id_usuario;
    String ebs_nome;
    String ebs_apelido;
    String ebs_cpf;
    Date ebs_data_nasc;
    String ebs_senha;
    int ebs_nivel;
    String ebs_ativo;

    public Ebs_Usuario() {
    }

    public int getEbs_id_usuario() {
        return ebs_id_usuario;
    }

    public void setEbs_id_usuario(int ebs_id_usuario) {
        this.ebs_id_usuario = ebs_id_usuario;
    }

    public String getEbs_nome() {
        return ebs_nome;
    }

    public void setEbs_nome(String ebs_nome) {
        this.ebs_nome = ebs_nome;
    }

    public String getEbs_apelido() {
        return ebs_apelido;
    }

    public void setEbs_apelido(String ebs_apelido) {
        this.ebs_apelido = ebs_apelido;
    }

    public String getEbs_cpf() {
        return ebs_cpf;
    }

    public void setEbs_cpf(String ebs_cpf) {
        this.ebs_cpf = ebs_cpf;
    }

    public Date getEbs_data_nasc() {
        return ebs_data_nasc;
    }

    public void setEbs_data_nasc(Date ebs_data_nasc) {
        this.ebs_data_nasc = ebs_data_nasc;
    }

    public String getEbs_senha() {
        return ebs_senha;
    }

    public void setEbs_senha(String ebs_senha) {
        this.ebs_senha = ebs_senha;
    }

    public int getEbs_nivel() {
        return ebs_nivel;
    }

    public void setEbs_nivel(int ebs_nivel) {
        this.ebs_nivel = ebs_nivel;
    }

    public String getEbs_ativo() {
        return ebs_ativo;
    }

    public void setEbs_ativo(String ebs_ativo) {
        this.ebs_ativo = ebs_ativo;
    }

}
