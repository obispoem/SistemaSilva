
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bean.Ebs_Usuario;
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
public class Ebs_usuarioDAO extends DAO_Abstract {

    @Override
    public void insert(Object objeto) {
        Ebs_Usuario usuario = (Ebs_Usuario) objeto;
        try {
            Connection con = DAO_Abstract.conDB();
            PreparedStatement pstm;
            String sql = "insert into ebs_usuario values(?,?,?,?,?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, usuario.getEbs_id_usuario());
            pstm.setString(2, usuario.getEbs_nome());
            pstm.setString(3, usuario.getEbs_apelido());
            pstm.setString(4, usuario.getEbs_cpf());

            // Convertendo java.util.Date para java.sql.Date
            java.sql.Date sqlDate = new java.sql.Date(usuario.getEbs_data_nasc().getTime());
            pstm.setDate(5, sqlDate);

            pstm.setString(6, usuario.getEbs_senha());
            pstm.setInt(7, usuario.getEbs_nivel());
            pstm.setString(8, usuario.getEbs_ativo());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Ebs_usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Object objeto) {
        Ebs_Usuario usuario = (Ebs_Usuario) objeto;
        try {
            Connection con = DAO_Abstract.conDB();
            PreparedStatement pstm;
            String sql = "update ebs_usuario set ebs_nome=?,ebs_apelido=?,ebs_cpf=?,ebs_data_nasc=?,ebs_senha=?,ebs_nivel=?, ebs_ativo=? where ebs_id_usuario=?";
            pstm = con.prepareStatement(sql);

            pstm.setString(1, usuario.getEbs_nome());
            pstm.setString(2, usuario.getEbs_apelido());
            pstm.setString(3, usuario.getEbs_cpf());
            pstm.setDate(4, new java.sql.Date(usuario.getEbs_data_nasc().getTime()));
            pstm.setString(5, usuario.getEbs_senha());
            pstm.setInt(6, usuario.getEbs_nivel());
            pstm.setString(7, usuario.getEbs_ativo());

            // id do usuario a alterar
            pstm.setInt(8, usuario.getEbs_id_usuario());

            pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Ebs_usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void delete(Object objeto) {
        Ebs_Usuario usuario = (Ebs_Usuario) objeto;
        try {
            Connection con = DAO_Abstract.conDB();
            PreparedStatement pstm;
            String sql = "delete from ebs_usuario where ebs_id_usuario=?";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, usuario.getEbs_id_usuario());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Ebs_usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object list(int id) {
        Ebs_Usuario usuario = new Ebs_Usuario();
        try {
            Connection con = DAO_Abstract.conDB();
            PreparedStatement pstm;
            String sql = "select * from ebs_usuario where ebs_id_usuario=?";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);

            ResultSet rs = pstm.executeQuery();
            if (rs.next() == true) {
                usuario.setEbs_id_usuario(rs.getInt("ebs_id_usuario"));
                usuario.setEbs_nome(rs.getString("ebs_nome"));
                usuario.setEbs_apelido(rs.getString("ebs_apelido"));
                usuario.setEbs_cpf(rs.getString("ebs_cpf"));
                usuario.setEbs_data_nasc(rs.getDate("ebs_data_nasc"));
                usuario.setEbs_senha(rs.getString("ebs_senha"));
                usuario.setEbs_nivel(rs.getInt("ebs_nivel"));
                usuario.setEbs_ativo(rs.getString("ebs_ativo"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Ebs_usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }

    @Override
    public ArrayList listAll() {
        java.util.List list = new ArrayList();
        try {
            Connection con = DAO_Abstract.conDB();
            PreparedStatement pstm;
            String sql = "select * from ebs_usuario";
            pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                Ebs_Usuario usuario = new Ebs_Usuario();
                usuario.setEbs_id_usuario(rs.getInt("ebs_id_usuario"));
                usuario.setEbs_nome(rs.getString("ebs_nome"));
                usuario.setEbs_apelido(rs.getString("ebs_apelido"));
                usuario.setEbs_cpf(rs.getString("ebs_cpf"));
                usuario.setEbs_data_nasc(rs.getDate("ebs_data_nasc"));
                usuario.setEbs_senha(rs.getString("ebs_senha"));
                usuario.setEbs_nivel(rs.getInt("ebs_nivel"));
                usuario.setEbs_ativo(rs.getString("ebs_ativo"));
                list.add(usuario);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Ebs_usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (ArrayList) list;
    }
    
    
}
