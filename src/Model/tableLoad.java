/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Control.DBconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author 94751
 */
public class tableLoad {
    
    
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public ResultSet fetchTableData() {
        con = DBconnect.connect();
        try {
            String sql = "SELECT name, subject, nic, age FROM teacher";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rs;
    }
    

    
    
}
