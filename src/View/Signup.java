
package View;

import Control.DBconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;


public class Signup extends javax.swing.JFrame {

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        
    public Signup() {
        initComponents();
        conn = DBconnect.connect();
        tableload();
    }
    
    

    public void tableload(){
        
        try {
            String sql= "SELECT id as ID,sname as NAME,sage as AGE,sgrade as GRADE FROM student";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            Table1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    public void tabledata(){
        
        int r = Table1.getSelectedRow();
        
        String id = Table1.getValueAt(r, 0).toString();
        String name = Table1.getValueAt(r, 1).toString();
        String age = Table1.getValueAt(r, 2).toString();
        String grade = Table1.getValueAt(r, 3).toString();
        
        IDbox.setText(id);
        Namebox.setText(name);
        Agebox.setText(age);
        Gradebox.setSelectedItem(grade);
        
    }
    
    
    public void search(){
        String srch = Searchbox.getText();
        
        try {
            String sql = "SELECT * FROM student WHERE sname LIKE '%"+srch+"%' OR id LIKE '"+srch+"'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            Table1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
   public void update(){
       
       String id = IDbox.getText();
       String name = Namebox.getText();
       String age = Agebox.getText();
       String grade = Gradebox.getSelectedItem().toString();
       
       try {
           String sql = "UPDATE student SET sname='"+name+"',sage='"+age+"',sgrade='"+grade+"' WHERE id='"+id+"' ";
           pst = conn.prepareStatement(sql);
           pst.execute();
           JOptionPane.showMessageDialog(null, "Updated!");
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Can't update1");
       }
   }
   
   
    public void clear(){
        
        Searchbox.setText("");
        IDbox.setText("");
        Namebox.setText("");
        Agebox.setText("");
        Gradebox.setSelectedItem(0);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        Searchbox = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Namebox = new javax.swing.JTextField();
        Agebox = new javax.swing.JTextField();
        Gradebox = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        Insertbtn = new javax.swing.JButton();
        Updatebtn = new javax.swing.JButton();
        Deletebtn = new javax.swing.JButton();
        Clearbtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        IDbox = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 51, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(204, 204, 0));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Search"));

        Searchbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchboxKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Searchbox, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 10, Short.MAX_VALUE)
                .addComponent(Searchbox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 330, 70));

        jPanel6.setBackground(new java.awt.Color(0, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Name");
        jPanel6.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Age");
        jPanel6.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Grade");
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        Namebox.setToolTipText("enter your name");
        jPanel6.add(Namebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 160, -1));
        jPanel6.add(Agebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 160, -1));

        Gradebox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        jPanel6.add(Gradebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 100, -1));

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 330, 280));

        jPanel7.setBackground(new java.awt.Color(255, 0, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Insertbtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Insertbtn.setText("Insert");
        Insertbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertbtnActionPerformed(evt);
            }
        });
        jPanel7.add(Insertbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 100, -1));

        Updatebtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Updatebtn.setText("Update");
        Updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdatebtnActionPerformed(evt);
            }
        });
        jPanel7.add(Updatebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 100, -1));

        Deletebtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Deletebtn.setText("Delete");
        Deletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeletebtnActionPerformed(evt);
            }
        });
        jPanel7.add(Deletebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 100, -1));

        Clearbtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Clearbtn.setText("Clear");
        Clearbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearbtnActionPerformed(evt);
            }
        });
        jPanel7.add(Clearbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 100, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Exit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 100, 20));

        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 330, 180));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("ID");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 20, 20));

        IDbox.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        IDbox.setText("ID");
        jPanel3.add(IDbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        jLabel1.setBackground(new java.awt.Color(255, 0, 102));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("                    Signup");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 10, 260, 50));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton2.setText("NEXT PAGE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, -1, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 680));

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Table1.setBackground(new java.awt.Color(255, 102, 102));
        Table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table1MouseClicked(evt);
            }
        });
        Table1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Table1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(Table1);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 520, 590));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Students Details Table");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 230, 60));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 550, 680));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void InsertbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertbtnActionPerformed
       
        String name;
        int age;
        int grade;
        
        name = Namebox.getText();
        age = Integer.parseInt(Agebox.getText());
        grade = Integer.parseInt(Gradebox.getSelectedItem().toString());
        
        try {
            String sql = "INSERT INTO student(sname,sage,sgrade)VALUES ('"+name+"','"+age+"','"+grade+"')";
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"INSERTED!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
            
        }
        
        tableload();
        
        
    }//GEN-LAST:event_InsertbtnActionPerformed

    private void Table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table1MouseClicked
        // TODO add your handling code here:
        tabledata();
    }//GEN-LAST:event_Table1MouseClicked

    private void Table1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Table1KeyReleased
        // TODO add your handling code here:
        tabledata();
    }//GEN-LAST:event_Table1KeyReleased

    private void SearchboxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchboxKeyReleased
        // TODO add your handling code here:
        search();
    }//GEN-LAST:event_SearchboxKeyReleased

    private void UpdatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdatebtnActionPerformed
        // TODO add your handling code here:
        update();
        tableload();
        
    }//GEN-LAST:event_UpdatebtnActionPerformed

    private void DeletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeletebtnActionPerformed
        // TODO add your handling code here:
        int check = JOptionPane.showConfirmDialog(null, "Do you want to delete ?");
        
        if(check==0){
            
             String id = IDbox.getText();
            
            try {
               String sql = "DELETE FROM student WHERE ID='"+id+"'";
               pst = conn.prepareStatement(sql);
               pst.execute();
               JOptionPane.showMessageDialog(null, "DELETED!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "NOT DELETE!");
            }
        }
        
            tableload();
            clear();
        
    }//GEN-LAST:event_DeletebtnActionPerformed

    private void ClearbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearbtnActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_ClearbtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        teachersDetails obj = new  teachersDetails();
        obj.setVisible(true );
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Signup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Agebox;
    private javax.swing.JButton Clearbtn;
    private javax.swing.JButton Deletebtn;
    private javax.swing.JComboBox<String> Gradebox;
    private javax.swing.JLabel IDbox;
    private javax.swing.JButton Insertbtn;
    private javax.swing.JTextField Namebox;
    private javax.swing.JTextField Searchbox;
    private javax.swing.JTable Table1;
    private javax.swing.JButton Updatebtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
