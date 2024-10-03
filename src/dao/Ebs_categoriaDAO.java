package dao;

import bean.Ebs_Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * DAO para manipulação da tabela ebs_categoria.
 * 
 * @author bispo
 */
public class Ebs_categoriaDAO extends DAO_Abstract {

    @Override
    public void insert(Object objeto) {
        Ebs_Categoria categoria = (Ebs_Categoria) objeto;
        try {
            Connection con = DAO_Abstract.conDB();
            PreparedStatement pstm;
            String sql = "INSERT INTO ebs_categoria (ebs_id_categoria, ebs_nome) VALUES (?, ?)";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, categoria.getEbs_id_categoria());
            pstm.setString(2, categoria.getEbs_nome());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Ebs_categoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Object objeto) {
        Ebs_Categoria categoria = (Ebs_Categoria) objeto;
        try {
            Connection con = DAO_Abstract.conDB();
            PreparedStatement pstm;
            String sql = "UPDATE ebs_categoria SET ebs_nome=? WHERE ebs_id_categoria=?";
            pstm = con.prepareStatement(sql);

            pstm.setString(1, categoria.getEbs_nome());
            pstm.setInt(2, categoria.getEbs_id_categoria());

            pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Ebs_categoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Object objeto) {
        Ebs_Categoria categoria = (Ebs_Categoria) objeto;
        try {
            Connection con = DAO_Abstract.conDB();
            PreparedStatement pstm;
            String sql = "DELETE FROM ebs_categoria WHERE ebs_id_categoria=?";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, categoria.getEbs_id_categoria());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Ebs_categoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object list(int id) {
        Ebs_Categoria categoria = new Ebs_Categoria();
        try {
            Connection con = DAO_Abstract.conDB();
            PreparedStatement pstm;
            String sql = "SELECT * FROM ebs_categoria WHERE ebs_id_categoria=?";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);

            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                categoria.setEbs_id_categoria(rs.getInt("ebs_id_categoria"));
                categoria.setEbs_nome(rs.getString("ebs_nome"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Ebs_categoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categoria;
    }

    @Override
    public ArrayList<Ebs_Categoria> listAll() {
        ArrayList<Ebs_Categoria> list = new ArrayList<>();
        try {
            Connection con = DAO_Abstract.conDB();
            PreparedStatement pstm;
            String sql = "SELECT * FROM ebs_categoria";
            pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                Ebs_Categoria categoria = new Ebs_Categoria();
                categoria.setEbs_id_categoria(rs.getInt("ebs_id_categoria"));
                categoria.setEbs_nome(rs.getString("ebs_nome"));
                list.add(categoria);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Ebs_categoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
