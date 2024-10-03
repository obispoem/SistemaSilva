/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bispo
 */
public abstract class DAO_Abstract {

    protected static String banco;

    public static void setBanco(String bancoDados) {
        banco = bancoDados;
    }

    public static String getBanco() {
        return banco;
    }

    public abstract void insert(Object objeto);

    public abstract void update(Object objeto);

    public abstract void delete(Object objeto);

    public abstract Object list(int codigo);

    public abstract ArrayList listAll();

    @SuppressWarnings("empty-statement")
    public static Connection conDB() {
        if ("local".equals(banco)) {
            try {

                Class.forName("com.mysql.jdbc.Driver");
                String url, user, pass;
                url = "jdbc:mysql://localhost/db_emanuel_silva";
                user = "root";
                pass = null;
                System.out.println("RODOU LOCAL");
                return DriverManager.getConnection(url, user, pass);
            } catch (ClassNotFoundException | SQLException ex) {
                System.out.println("NAO RODOU LOCAL");
                Logger.getLogger(DAO_Abstract.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if ("if".equals(banco)) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                String url, user, pass;
                url = "jdbc:mysql://10.7.0.51:33062/db_emanuel_silva";;
                user = "emanuel_silva";
                pass = "emanuel_silva";
                System.out.println("RODOU IF");
                return DriverManager.getConnection(url, user, pass);
            } catch (ClassNotFoundException | SQLException ex) {
                System.out.println("NAO RODOU IF");
                Logger.getLogger(DAO_Abstract.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                String url, user, pass;
                url = "jdbc:mysql://localhost/db_emanuel_silva";
                user = "root";
                pass = null;
                System.out.println("RODOU LOCAL");
                return DriverManager.getConnection(url, user, pass);
            } catch (ClassNotFoundException | SQLException ex) {
                System.out.println("NAO RODOU LOCAL");
                Logger.getLogger(DAO_Abstract.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

}
