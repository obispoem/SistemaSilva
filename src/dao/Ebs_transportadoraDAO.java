/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bean.Ebs_Transportadora;
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
public class Ebs_transportadoraDAO extends DAO_Abstract {

    @Override
    public void insert(Object objeto) {
        Ebs_Transportadora transportadora = (Ebs_Transportadora) objeto;
        try {
            Connection con = DAO_Abstract.conDB();
            PreparedStatement pstm;
            String sql = "insert into ebs_transportadora values(?,?,?,?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, transportadora.getEbs_id_transportadora());
            pstm.setString(2, transportadora.getEbs_nome());
            pstm.setString(3, transportadora.getEbs_telefone());
            pstm.setString(4, transportadora.getEbs_endereco());
            pstm.setString(5, transportadora.getEbs_cnpj());
            pstm.setString(6, transportadora.getEbs_email());
            pstm.setString(7, transportadora.getEbs_responsavel());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Ebs_transportadoraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Object objeto) {
        Ebs_Transportadora transportadora = (Ebs_Transportadora) objeto;
        try {
            Connection con = DAO_Abstract.conDB();
            PreparedStatement pstm;
            String sql = "update ebs_transportadora set ebs_nome=?, ebs_telefone=?, ebs_endereco=?, ebs_cnpj=?, ebs_email=?, ebs_responsavel=? where ebs_id_transportadora=?";
            pstm = con.prepareStatement(sql);

            pstm.setString(1, transportadora.getEbs_nome());
            pstm.setString(2, transportadora.getEbs_telefone());
            pstm.setString(3, transportadora.getEbs_endereco());
            pstm.setString(4, transportadora.getEbs_cnpj());
            pstm.setString(5, transportadora.getEbs_email());
            pstm.setString(6, transportadora.getEbs_responsavel());

            // ID da transportadora a alterar
            pstm.setInt(7, transportadora.getEbs_id_transportadora());

            pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Ebs_transportadoraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Object objeto) {
        Ebs_Transportadora transportadora = (Ebs_Transportadora) objeto;
        try {
            Connection con = DAO_Abstract.conDB();
            PreparedStatement pstm;
            String sql = "delete from ebs_transportadora where ebs_id_transportadora=?";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, transportadora.getEbs_id_transportadora());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Ebs_transportadoraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object list(int id) {
        Ebs_Transportadora transportadora = new Ebs_Transportadora();
        try {
            Connection con = DAO_Abstract.conDB();
            PreparedStatement pstm;
            String sql = "select * from ebs_transportadora where ebs_id_transportadora=?";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);

            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                transportadora.setEbs_id_transportadora(rs.getInt("ebs_id_transportadora"));
                transportadora.setEbs_nome(rs.getString("ebs_nome"));
                transportadora.setEbs_telefone(rs.getString("ebs_telefone"));
                transportadora.setEbs_endereco(rs.getString("ebs_endereco"));
                transportadora.setEbs_cnpj(rs.getString("ebs_cnpj"));
                transportadora.setEbs_email(rs.getString("ebs_email"));
                transportadora.setEbs_responsavel(rs.getString("ebs_responsavel"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Ebs_transportadoraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return transportadora;
    }

    @Override
    public ArrayList listAll() {
        ArrayList list = new ArrayList<>();
        try {
            Connection con = DAO_Abstract.conDB();
            PreparedStatement pstm;
            String sql = "select * from ebs_transportadora";
            pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                Ebs_Transportadora transportadora = new Ebs_Transportadora();
                transportadora.setEbs_id_transportadora(rs.getInt("ebs_id_transportadora"));
                transportadora.setEbs_nome(rs.getString("ebs_nome"));
                transportadora.setEbs_telefone(rs.getString("ebs_telefone"));
                transportadora.setEbs_endereco(rs.getString("ebs_endereco"));
                transportadora.setEbs_cnpj(rs.getString("ebs_cnpj"));
                transportadora.setEbs_email(rs.getString("ebs_email"));
                transportadora.setEbs_responsavel(rs.getString("ebs_responsavel"));
                list.add(transportadora);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Ebs_transportadoraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
