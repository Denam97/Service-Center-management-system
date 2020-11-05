/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functions;

import DBconnection.DB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Denam
 */
public class function {
    
    PreparedStatement ps;
    ResultSet rs;
    
    public void insert(String wht){
        try {
            ps=DB.mycon().prepareStatement(wht);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(function.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public ResultSet view(String wht){
        try {
            ps=DB.mycon().prepareStatement(wht);
            rs=ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(function.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public void delete(String wht){
        try {
            ps=DB.mycon().prepareStatement(wht);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(function.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   public void update(String wht){
        try {
            ps=DB.mycon().prepareStatement(wht);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(function.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
        
}
