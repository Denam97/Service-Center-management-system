/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceCenter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Denam
 */
public class tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        try {
            view v=new view();
            ResultSet rs=v.getTable("select InvoiceNo from sales");
            String invNo = "";
            int c=0;
            while(rs.next()){
                    invNo=String.valueOf(Integer.parseInt(rs.getString(1))+1);
                    System.out.println("hiii");
                    c++;
            }
            if(c==0){
                invNo="1";
            }
            System.out.println(invNo);
        } catch (SQLException ex) {
            Logger.getLogger(tester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
