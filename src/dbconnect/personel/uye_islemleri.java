/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbconnect.personel;

import dbconnect.dbconnection;
import dbconnect.kutuphane_secim_1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class uye_islemleri extends javax.swing.JFrame {

    DefaultTableModel dtm = new DefaultTableModel();
    String[] satirlar = new String[4];

    public uye_islemleri() {
        initComponents();
        setResizable(false);
        jTable.setModel(dtm);
        dtm.setColumnIdentifiers(new String[]{"Ad Soyad", "E-Posta", "Telefon", "Adres"});
        Connection connect = null;
        dbconnection dbc = new dbconnection();
        PreparedStatement statement = null;
        ResultSet myRs = null;
        try {
            connect = dbc.getConnection();
            String sql = "SELECT * FROM uyeler";
            statement = connect.prepareStatement(sql);
            myRs = statement.executeQuery();
            while (myRs.next()) {
                satirlar[0] = myRs.getString("adSoyad");
                satirlar[1] = myRs.getString("ePosta");
                satirlar[2] = myRs.getString("telefon");
                satirlar[3] = myRs.getString("uyeAdres");
                dtm.addRow(satirlar);
            }

        } catch (SQLException ex) {
            Logger.getLogger(uye_islemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void delete() throws SQLException {
        String adSoyad = JTextField_adSoyad2.getText();

        if (adSoyad.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Lütfen 'Ad Soyad' kısmını doldurun!");
            return;
        }

        Connection connect = null;
        dbconnection dbc = new dbconnection();
        PreparedStatement statement = null;
        try {
            connect = dbc.getConnection();
            String sql = "DELETE FROM uyeler WHERE adSoyad=?";

            statement = connect.prepareStatement(sql);
            statement.setString(1, JTextField_adSoyad2.getText());

            statement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Üyenin Kaydı Silindi!");
        } catch (SQLException e) {
            dbc.ShowError(e);
        } finally {
            statement.close();
            connect.close();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        uyeCikar2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        JTextField_adSoyad2 = new javax.swing.JTextField();
        jButton_pie = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));

        jPanel1.setBackground(new java.awt.Color(153, 148, 208));

        uyeCikar2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        uyeCikar2.setText("SİL");
        uyeCikar2.setToolTipText("");
        uyeCikar2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        uyeCikar2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        uyeCikar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uyeCikar2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Adı Soyadı:");

        jButton_pie.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton_pie.setText("Personel İşlem Ekranı");
        jButton_pie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_pieActionPerformed(evt);
            }
        });

        jTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(jLabel4)
                .addGap(30, 30, 30)
                .addComponent(JTextField_adSoyad2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(uyeCikar2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addComponent(jButton_pie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JTextField_adSoyad2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addComponent(uyeCikar2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_pie, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_pieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_pieActionPerformed
        personel_islem_ekrani pie = new personel_islem_ekrani();
        pie.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton_pieActionPerformed

    private void uyeCikar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uyeCikar2ActionPerformed
        try {
            delete();
        } catch (SQLException ex) {
            Logger.getLogger(uye_islemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_uyeCikar2ActionPerformed

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
            java.util.logging.Logger.getLogger(uye_islemleri.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(uye_islemleri.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(uye_islemleri.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(uye_islemleri.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new uye_islemleri().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JTextField_adSoyad2;
    private javax.swing.JButton jButton_pie;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTable;
    private javax.swing.JButton uyeCikar2;
    // End of variables declaration//GEN-END:variables

}
