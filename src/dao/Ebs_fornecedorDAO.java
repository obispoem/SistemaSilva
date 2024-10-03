/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bean.Ebs_Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bispo
 */
public class Ebs_fornecedorDAO extends DAO_Abstract {

    @Override
    public void insert(Object objeto) {
        Ebs_Fornecedor fornecedor = (Ebs_Fornecedor) objeto;
        try {
            Connection con = DAO_Abstract.conDB();
            PreparedStatement pstm;
            String sql = "insert into ebs_fornecedor values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, fornecedor.getEbs_id_fornecedor());
            pstm.setString(2, fornecedor.getEbs_cnpj());
            pstm.setString(3, fornecedor.getEbs_nome_empresa());
            pstm.setString(4, fornecedor.getEbs_nome_fant());
            pstm.setString(5, fornecedor.getEbs_site_empresa());
            pstm.setString(6, fornecedor.getEbs_nome_fornecedor());
            pstm.setString(7, fornecedor.getEbs_ativo());
            pstm.setString(8, fornecedor.getEbs_telefone());
            pstm.setString(9, fornecedor.getEbs_celular());
            pstm.setString(10, fornecedor.getEbs_email());
            pstm.setString(11, fornecedor.getEbs_endereco());
            pstm.setString(12, fornecedor.getEbs_numero());
            pstm.setString(13, fornecedor.getEbs_bairro());
            pstm.setString(14, fornecedor.getEbs_cidade());
            pstm.setString(15, fornecedor.getEbs_estado());
            pstm.setInt(16, fornecedor.getEbs_fk_transportadora());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Ebs_fornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Object objeto) {
        Ebs_Fornecedor fornecedor = (Ebs_Fornecedor) objeto;
        try {
            Connection con = DAO_Abstract.conDB();
            PreparedStatement pstm;
            String sql = "update ebs_fornecedor set ebs_cnpj=?, ebs_nome_empresa=?, ebs_nome_fant=?, ebs_site_empresa=?, ebs_fornecedor=?, ebs_status=?, ebs_telefone=?, ebs_celular=?, ebs_email=?, ebs_endereco=?, ebs_numero=?, ebs_bairro=?, ebs_cidade=?, ebs_estado=?, ebs_fk_transportadora=? where ebs_id_fornecedor=?";
            pstm = con.prepareStatement(sql);

            pstm.setString(1, fornecedor.getEbs_cnpj());
            pstm.setString(2, fornecedor.getEbs_nome_empresa());
            pstm.setString(3, fornecedor.getEbs_nome_fant());
            pstm.setString(4, fornecedor.getEbs_site_empresa());
            pstm.setString(5, fornecedor.getEbs_nome_fornecedor());
            pstm.setString(6, fornecedor.getEbs_ativo());
            pstm.setString(7, fornecedor.getEbs_telefone());
            pstm.setString(8, fornecedor.getEbs_celular());
            pstm.setString(9, fornecedor.getEbs_email());
            pstm.setString(10, fornecedor.getEbs_endereco());
            pstm.setString(11, fornecedor.getEbs_numero());
            pstm.setString(12, fornecedor.getEbs_bairro());
            pstm.setString(13, fornecedor.getEbs_cidade());
            pstm.setString(14, fornecedor.getEbs_estado());
            pstm.setInt(15, fornecedor.getEbs_fk_transportadora());

            // ID do fornecedor a alterar
            pstm.setInt(16, fornecedor.getEbs_id_fornecedor());

            pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Ebs_fornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Object objeto) {
        Ebs_Fornecedor fornecedor = (Ebs_Fornecedor) objeto;
        try {
            Connection con = DAO_Abstract.conDB();
            PreparedStatement pstm;
            String sql = "delete from ebs_fornecedor where ebs_id_fornecedor=?";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, fornecedor.getEbs_id_fornecedor());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Ebs_fornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object list(int id) {
        Ebs_Fornecedor fornecedor = new Ebs_Fornecedor();
        try {
            Connection con = DAO_Abstract.conDB();
            PreparedStatement pstm;
            String sql = "select * from ebs_fornecedor where ebs_id_fornecedor=?";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);

            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                fornecedor.setEbs_id_fornecedor(rs.getInt("ebs_id_fornecedor"));
                fornecedor.setEbs_cnpj(rs.getString("ebs_cnpj"));
                fornecedor.setEbs_nome_empresa(rs.getString("ebs_nome_empresa"));
                fornecedor.setEbs_nome_fant(rs.getString("ebs_nome_fant"));
                fornecedor.setEbs_site_empresa(rs.getString("ebs_site_empresa"));
                fornecedor.setEbs_nome_fornecedor(rs.getString("ebs_fornecedor"));
                fornecedor.setEbs_ativo(rs.getString("ebs_status"));
                fornecedor.setEbs_telefone(rs.getString("ebs_telefone"));
                fornecedor.setEbs_celular(rs.getString("ebs_celular"));
                fornecedor.setEbs_email(rs.getString("ebs_email"));
                fornecedor.setEbs_endereco(rs.getString("ebs_endereco"));
                fornecedor.setEbs_numero(rs.getString("ebs_numero"));
                fornecedor.setEbs_bairro(rs.getString("ebs_bairro"));
                fornecedor.setEbs_cidade(rs.getString("ebs_cidade"));
                fornecedor.setEbs_estado(rs.getString("ebs_estado"));
                fornecedor.setEbs_fk_transportadora(rs.getInt("ebs_fk_transportadora"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Ebs_fornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fornecedor;
    }

    @Override
    public ArrayList listAll() {
        ArrayList list = new ArrayList<>();
        try {
            Connection con = DAO_Abstract.conDB();
            PreparedStatement pstm;
            String sql = "select * from ebs_fornecedor";
            pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                Ebs_Fornecedor fornecedor = new Ebs_Fornecedor();
                fornecedor.setEbs_id_fornecedor(rs.getInt("ebs_id_fornecedor"));
                fornecedor.setEbs_cnpj(rs.getString("ebs_cnpj"));
                fornecedor.setEbs_nome_empresa(rs.getString("ebs_nome_empresa"));
                fornecedor.setEbs_nome_fant(rs.getString("ebs_nome_fant"));
                fornecedor.setEbs_site_empresa(rs.getString("ebs_site_empresa"));
                fornecedor.setEbs_nome_fornecedor(rs.getString("ebs_nome_fornecedor"));
                fornecedor.setEbs_ativo(rs.getString("ebs_ativo"));
                fornecedor.setEbs_telefone(rs.getString("ebs_telefone"));
                fornecedor.setEbs_celular(rs.getString("ebs_celular"));
                fornecedor.setEbs_email(rs.getString("ebs_email"));
                fornecedor.setEbs_endereco(rs.getString("ebs_endereco"));
                fornecedor.setEbs_numero(rs.getString("ebs_numero"));
                fornecedor.setEbs_bairro(rs.getString("ebs_bairro"));
                fornecedor.setEbs_cidade(rs.getString("ebs_cidade"));
                fornecedor.setEbs_estado(rs.getString("ebs_estado"));
                fornecedor.setEbs_fk_transportadora(rs.getInt("ebs_fk_transportadora"));
                list.add(fornecedor);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Ebs_fornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
