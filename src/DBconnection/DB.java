/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ravindu
 */
public class DB {

    
    public static Connection mycon(){
        Connection c = null;
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/samantables", "root", "");
            
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return c;
    }
}
