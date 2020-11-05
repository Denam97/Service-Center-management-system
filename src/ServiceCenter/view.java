/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceCenter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Shehan Atapattu
 */
public class view {

    PreparedStatement pst;
    Connection con = DBconnection.DB.mycon();
    ResultSet rs;

    public void insert(String wht) {
        try {
            pst = con.prepareStatement(wht);
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(view.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet getTable(String wht) {
        try {
            pst = con.prepareStatement(wht);
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(view.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public void update(String wht) {
        try {
            pst = con.prepareStatement(wht);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(view.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void delete(String wht) {
        try {
            pst = con.prepareStatement(wht);
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(view.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean check(String wht, int qty) {
        boolean find = true;

        try {
            pst = con.prepareStatement(wht);
            rs = pst.executeQuery();
            while (rs.next()) {
                if (qty > rs.getInt(1)) {
                    find = false;
                }
            }
            }catch (SQLException ex) {
            Logger.getLogger(view.class.getName()).log(Level.SEVERE, null, ex);
        }
        return find;
    }
}
