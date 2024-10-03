package dao;

import bean.Ebs_Produto;
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
public class Ebs_produtoDAO extends DAO_Abstract {

    @Override
    public void insert(Object objeto) {
        Ebs_Produto produto = (Ebs_Produto) objeto;
        try {
            Connection con = DAO_Abstract.conDB();
            PreparedStatement pstm;
            String sql = "insert into ebs_produto (ebs_nome, ebs_fk_categoria, ebs_data_chegada, ebs_data_validade, ebs_valor, ebs_estoque) values (?, ?, ?, ?, ?, ?)";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, produto.getEbs_nome());
            pstm.setInt(2, 1);

            // Convertendo java.util.Date para java.sql.Date
            java.sql.Date dataChegada = new java.sql.Date(produto.getEbs_data_chegada().getTime());
            java.sql.Date dataValidade = new java.sql.Date(produto.getEbs_data_validade().getTime());
            pstm.setDate(3, dataChegada);
            pstm.setDate(4, dataValidade);

            pstm.setDouble(5, produto.getEbs_valor());
            pstm.setInt(6, produto.getEbs_estoque());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Ebs_produtoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Object objeto) {
        Ebs_Produto produto = (Ebs_Produto) objeto;
        try {
            Connection con = DAO_Abstract.conDB();
            PreparedStatement pstm;
            String sql = "update ebs_produto set ebs_nome=?, ebs_fk_categoria=?, ebs_data_chegada=?, ebs_data_validade=?, ebs_valor=?, ebs_estoque=? where ebs_id_produto=?";
            pstm = con.prepareStatement(sql);

            pstm.setString(1, produto.getEbs_nome());
            pstm.setInt(2, produto.getEbs_fk_categoria());
            pstm.setDate(3, new java.sql.Date(produto.getEbs_data_chegada().getTime()));
            pstm.setDate(4, new java.sql.Date(produto.getEbs_data_validade().getTime()));
            pstm.setDouble(5, produto.getEbs_valor());
            pstm.setInt(6, produto.getEbs_estoque());

            // id do produto a alterar
            pstm.setInt(7, produto.getEbs_id_produto());

            pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Ebs_produtoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void delete(Object objeto) {
        Ebs_Produto produto = (Ebs_Produto) objeto;
        try {
            Connection con = DAO_Abstract.conDB();
            PreparedStatement pstm;
            String sql = "delete from ebs_produto where ebs_id_produto=?";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, produto.getEbs_id_produto());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Ebs_produtoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object list(int id) {
        Ebs_Produto produto = new Ebs_Produto();
        try {
            Connection con = DAO_Abstract.conDB();
            PreparedStatement pstm;
            String sql = "select * from ebs_produto where ebs_id_produto=?";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);

            ResultSet rs = pstm.executeQuery();
            if (rs.next() == true) {
                produto.setEbs_id_produto(rs.getInt("ebs_id_produto"));
                produto.setEbs_nome(rs.getString("ebs_nome"));
                produto.setEbs_fk_categoria(rs.getInt("ebs_fk_categoria"));
                produto.setEbs_data_chegada(rs.getDate("ebs_data_chegada"));
                produto.setEbs_data_validade(rs.getDate("ebs_data_validade"));
                produto.setEbs_valor(rs.getDouble("ebs_valor"));
                produto.setEbs_estoque(rs.getInt("ebs_estoque"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Ebs_produtoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produto;
    }

    @Override
    public ArrayList listAll() {
        java.util.List list = new ArrayList();
        try {
            Connection con = DAO_Abstract.conDB();
            PreparedStatement pstm;
            String sql = "select * from ebs_produto";
            pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                Ebs_Produto produto = new Ebs_Produto();
                produto.setEbs_id_produto(rs.getInt("ebs_id_produto"));
                produto.setEbs_nome(rs.getString("ebs_nome"));
                produto.setEbs_fk_categoria(rs.getInt("ebs_fk_categoria"));
                produto.setEbs_data_chegada(rs.getDate("ebs_data_chegada"));
                produto.setEbs_data_validade(rs.getDate("ebs_data_validade"));
                produto.setEbs_valor(rs.getDouble("ebs_valor"));
                produto.setEbs_estoque(rs.getInt("ebs_estoque"));
                list.add(produto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Ebs_produtoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (ArrayList) list;
    }
}
