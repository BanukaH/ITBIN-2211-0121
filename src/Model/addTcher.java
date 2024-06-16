/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Control.DBconnect;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author 94751
 */
public class addTcher {
    
    Connection con = null;
    PreparedStatement pst = null;
    
    public void addProduct(String name,  String sub, String nic, int age){
   con = DBconnect.connect();
        
        try {
            String sqlquery = "INSERT INTO teacher(name, subject, nic, age) VALUES (?, ?, ?, ?)";
            pst = con.prepareStatement(sqlquery);
           
            pst.setString(1, name);
            pst.setString(2, sub);
            pst.setString(3, nic);
            pst.setInt(4, age);
           
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data Insert SUCCESSFULY");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
}
}
    
}
