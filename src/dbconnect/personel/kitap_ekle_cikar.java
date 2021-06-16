/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbconnect.personel;

import dbconnect.dbconnection;
import dbconnect.uye_giris;
import dbconnect.uye_kayit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class kitap_ekle_cikar extends javax.swing.JFrame {

    DefaultTableModel dtm = new DefaultTableModel();
    String[] satirlar = new String[5];

    /**
     * Creates new form kitap_ekle_cikar
     */
    public kitap_ekle_cikar() {
        initComponents();
        setResizable(false);
        jTable1.setModel(dtm);
        dtm.setColumnIdentifiers(new String[]{"Kitabın Adı", "ISBN", "Yayın Evi", "Kategori", "Yazar"});
        Connection connect = null;
        dbconnection dbc = new dbconnection();
        PreparedStatement statement = null;
        ResultSet myRs = null;
        try {
            connect = dbc.getConnection();
            String sql = "SELECT * FROM kitaplar";
            statement = connect.prepareStatement(sql);
            myRs = statement.executeQuery();

            while (myRs.next()) {
                satirlar[0] = myRs.getString("kitapAd");
                satirlar[1] = myRs.getString("ISBN");
                satirlar[2] = myRs.getString("yayinEvi");
                satirlar[3] = myRs.getString("kategori");
                satirlar[4] = myRs.getString("yazar");
                dtm.addRow(satirlar);
            }

        } catch (SQLException ex) {
            Logger.getLogger(uye_islemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertAmasya() throws SQLException {
        String kitapAd = jTextField_adi.getText();
        String ISBN = jTextField_isbn1.getText();
        String yayinEvi = jTextField_yayinevi.getText();
        String kategori = jTextField_kategori.getText();
        String yazar = jTextField_yazar.getText();

        if (kitapAd.isEmpty() || ISBN.isEmpty() || yayinEvi.isEmpty() || kategori.isEmpty() || yazar.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Lütfen alanları eksiksiz ve tam doldurun!");
            return;
        }

        Connection connect = null;
        dbconnection dbc = new dbconnection();
        PreparedStatement statement = null;
        try {
            connect = dbc.getConnection();
            String sql = "INSERT INTO `amasya`(`kitapAd`, `ISBN`, `yayinEvi`, `kategori`, `yazar`) VALUES (?,?,?,?,?)";

            statement = connect.prepareStatement(sql);
            statement.setString(1, jTextField_adi.getText());
            statement.setString(2, jTextField_isbn1.getText());
            statement.setString(3, jTextField_yayinevi.getText());
            statement.setString(4, jTextField_kategori.getText());
            statement.setString(5, jTextField_yazar.getText());

            statement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Seçtiğiniz kitap Amasya kütüphanesinin sistemine eklendi!");
        } catch (SQLException e) {
            dbc.ShowError(e);
        } finally {
            statement.close();
            connect.close();
        }
    }

    public void insertKayseri() throws SQLException {
        String kitapAd = jTextField_adi.getText();
        String ISBN = jTextField_isbn1.getText();
        String yayinEvi = jTextField_yayinevi.getText();
        String kategori = jTextField_kategori.getText();
        String yazar = jTextField_yazar.getText();

        if (kitapAd.isEmpty() || ISBN.isEmpty() || yayinEvi.isEmpty() || kategori.isEmpty() || yazar.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Lütfen alanları eksiksiz ve tam doldurun!");
            return;
        }

        Connection connect = null;
        dbconnection dbc = new dbconnection();
        PreparedStatement statement = null;
        try {
            connect = dbc.getConnection();
            String sql = "INSERT INTO `kayseri`(`kitapAd`, `ISBN`, `yayinEvi`, `kategori`, `yazar`) VALUES (?,?,?,?,?)";

            statement = connect.prepareStatement(sql);
            statement.setString(1, jTextField_adi.getText());
            statement.setString(2, jTextField_isbn1.getText());
            statement.setString(3, jTextField_yayinevi.getText());
            statement.setString(4, jTextField_kategori.getText());
            statement.setString(5, jTextField_yazar.getText());

            statement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Seçtiğiniz kitap Amasya kütüphanesinin sistemine eklendi!");
        } catch (SQLException e) {
            dbc.ShowError(e);
        } finally {
            statement.close();
            connect.close();
        }
    }

    public void insertKonya() throws SQLException {
        String kitapAd = jTextField_adi.getText();
        String ISBN = jTextField_isbn1.getText();
        String yayinEvi = jTextField_yayinevi.getText();
        String kategori = jTextField_kategori.getText();
        String yazar = jTextField_yazar.getText();

        if (kitapAd.isEmpty() || ISBN.isEmpty() || yayinEvi.isEmpty() || kategori.isEmpty() || yazar.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Lütfen alanları eksiksiz ve tam doldurun!");
            return;
        }

        Connection connect = null;
        dbconnection dbc = new dbconnection();
        PreparedStatement statement = null;
        try {
            connect = dbc.getConnection();
            String sql = "INSERT INTO `konya`(`kitapAd`, `ISBN`, `yayinEvi`, `kategori`, `yazar`) VALUES (?,?,?,?,?)";

            statement = connect.prepareStatement(sql);
            statement.setString(1, jTextField_adi.getText());
            statement.setString(2, jTextField_isbn1.getText());
            statement.setString(3, jTextField_yayinevi.getText());
            statement.setString(4, jTextField_kategori.getText());
            statement.setString(5, jTextField_yazar.getText());

            statement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Seçtiğiniz kitap Amasya kütüphanesinin sistemine eklendi!");
        } catch (SQLException e) {
            dbc.ShowError(e);
        } finally {
            statement.close();
            connect.close();
        }
    }

    public void deleteKonya() throws SQLException {
        String ISBN = jTextField_isbn2.getText();

        if (ISBN.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Lütfen ISBN kısmını doldurun!");
            return;
        }

        Connection connect = null;
        dbconnection dbc = new dbconnection();
        PreparedStatement statement = null;
        try {
            connect = dbc.getConnection();
            String sql = "DELETE FROM konya WHERE ISBN=?";

            statement = connect.prepareStatement(sql);
            statement.setString(1, jTextField_isbn2.getText());

            statement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Kitap Konya Kütüphanesinden çıkarıldı!");
        } catch (SQLException e) {
            dbc.ShowError(e);
        } finally {
            statement.close();
            connect.close();
        }
    }

    public void deleteAmasya() throws SQLException {
        String ISBN = jTextField_isbn2.getText();

        if (ISBN.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Lütfen ISBN kısmını doldurun!");
            return;
        }

        Connection connect = null;
        dbconnection dbc = new dbconnection();
        PreparedStatement statement = null;
        try {
            connect = dbc.getConnection();
            String sql = "DELETE FROM amasya WHERE ISBN=?";

            statement = connect.prepareStatement(sql);
            statement.setString(1, jTextField_isbn2.getText());

            statement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Kitap Amasya Kütüphanesinden çıkarıldı!");
        } catch (SQLException e) {
            dbc.ShowError(e);
        } finally {
            statement.close();
            connect.close();
        }
    }

    public void deleteKayseri() throws SQLException {
        String ISBN = jTextField_isbn2.getText();

        if (ISBN.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Lütfen ISBN kısmını doldurun!");
            return;
        }

        Connection connect = null;
        dbconnection dbc = new dbconnection();
        PreparedStatement statement = null;
        try {
            connect = dbc.getConnection();
            String sql = "DELETE FROM kayseri WHERE ISBN=?";

            statement = connect.prepareStatement(sql);
            statement.setString(1, jTextField_isbn2.getText());

            statement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Kitap Kayseri Kütüphanesinden çıkarıldı!");
        } catch (SQLException e) {
            dbc.ShowError(e);
        } finally {
            statement.close();
            connect.close();
        }
    }

    public void delete() throws SQLException {
        String ISBN = jTextField_isbn2.getText();

        if (ISBN.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Lütfen ISBN kısmını doldurun!");
            return;
        }

        Connection connect = null;
        dbconnection dbc = new dbconnection();
        PreparedStatement statement = null;
        try {
            connect = dbc.getConnection();
            String sql = "DELETE FROM kitaplar WHERE ISBN=?";

            statement = connect.prepareStatement(sql);
            statement.setString(1, jTextField_isbn2.getText());

            statement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Kitap Çıkarıldı!");
        } catch (SQLException e) {
            dbc.ShowError(e);
        } finally {
            statement.close();
            connect.close();
        }
    }

    public void insert() throws SQLException {
        String kitapAd = jTextField_adi.getText();
        String ISBN = jTextField_isbn1.getText();
        String yayinEvi = jTextField_yayinevi.getText();
        String kategori = jTextField_kategori.getText();
        String yazar = jTextField_yazar.getText();

        if (kitapAd.isEmpty() || ISBN.isEmpty() || yayinEvi.isEmpty() || kategori.isEmpty() || yazar.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Lütfen alanları eksiksiz ve tam doldurun!");
            return;
        }

        Connection connect = null;
        dbconnection dbc = new dbconnection();
        PreparedStatement statement = null;
        try {
            connect = dbc.getConnection();
            String sql = "INSERT INTO `kitaplar`(`kitapAd`, `ISBN`, `yayinEvi`, `kategori`, `yazar`) VALUES (?,?,?,?,?)";

            statement = connect.prepareStatement(sql);
            statement.setString(1, jTextField_adi.getText());
            statement.setString(2, jTextField_isbn1.getText());
            statement.setString(3, jTextField_yayinevi.getText());
            statement.setString(4, jTextField_kategori.getText());
            statement.setString(5, jTextField_yazar.getText());

            statement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Kaydınız tamamlandı!");
        } catch (SQLException e) {
            dbc.ShowError(e);
        } finally {
            statement.close();
            connect.close();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton_ekle = new javax.swing.JButton();
        jButton_cikar = new javax.swing.JButton();
        jTextField_adi = new javax.swing.JTextField();
        jTextField_isbn1 = new javax.swing.JTextField();
        jTextField_yayinevi = new javax.swing.JTextField();
        jTextField_kategori = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTextField_isbn2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton_pie = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextField_yazar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jRadioButton_amasya = new javax.swing.JRadioButton();
        jRadioButton_kayseri = new javax.swing.JRadioButton();
        jRadioButton_konya = new javax.swing.JRadioButton();
        jRadioButton_konyadelete = new javax.swing.JRadioButton();
        jRadioButton_kayseridelete = new javax.swing.JRadioButton();
        jRadioButton_amasyadelete = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));

        jPanel1.setBackground(new java.awt.Color(153, 148, 208));

        jButton_ekle.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton_ekle.setText("Ekle");
        jButton_ekle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ekleActionPerformed(evt);
            }
        });

        jButton_cikar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton_cikar.setText("Çıkar");
        jButton_cikar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cikarActionPerformed(evt);
            }
        });

        jTextField_adi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_adiActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Adı");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("ISBN");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("Yayın Evi");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(240, 240, 240));
        jLabel4.setText("Kategorisi");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 168, Short.MAX_VALUE)
        );

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(240, 240, 240));
        jLabel5.setText("ISBN");

        jButton_pie.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton_pie.setText("Personel İşlem Ekranı");
        jButton_pie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_pieActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setText("Yazar");

        jButton1.setText("Temizle");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Temizle");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jRadioButton_amasya.setBackground(new java.awt.Color(153, 148, 208));
        jRadioButton_amasya.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton_amasya.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton_amasya.setText("Amasya");
        jRadioButton_amasya.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_amasyaActionPerformed(evt);
            }
        });

        jRadioButton_kayseri.setBackground(new java.awt.Color(153, 148, 208));
        jRadioButton_kayseri.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton_kayseri.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton_kayseri.setText("Kayseri");
        jRadioButton_kayseri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_kayseriActionPerformed(evt);
            }
        });

        jRadioButton_konya.setBackground(new java.awt.Color(153, 148, 208));
        jRadioButton_konya.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton_konya.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton_konya.setText("Konya");
        jRadioButton_konya.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_konyaActionPerformed(evt);
            }
        });

        jRadioButton_konyadelete.setBackground(new java.awt.Color(153, 148, 208));
        jRadioButton_konyadelete.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton_konyadelete.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton_konyadelete.setText("Konya");
        jRadioButton_konyadelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_konyadeleteActionPerformed(evt);
            }
        });

        jRadioButton_kayseridelete.setBackground(new java.awt.Color(153, 148, 208));
        jRadioButton_kayseridelete.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton_kayseridelete.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton_kayseridelete.setText("Kayseri");
        jRadioButton_kayseridelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_kayserideleteActionPerformed(evt);
            }
        });

        jRadioButton_amasyadelete.setBackground(new java.awt.Color(153, 148, 208));
        jRadioButton_amasyadelete.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton_amasyadelete.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton_amasyadelete.setText("Amasya");
        jRadioButton_amasyadelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_amasyadeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jTextField_adi, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(12, 12, 12))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jTextField_isbn1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGap(8, 8, 8)))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextField_yayinevi, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                            .addComponent(jTextField_kategori)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addComponent(jButton_ekle, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jRadioButton_amasya)
                                                .addGap(104, 104, 104)))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jRadioButton_konya)
                                            .addComponent(jButton1)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(149, 149, 149)
                                .addComponent(jRadioButton_kayseri))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(109, 109, 109)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_yazar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(29, 29, 29)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_isbn2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jRadioButton_amasyadelete)
                                        .addGap(104, 104, 104)
                                        .addComponent(jRadioButton_konyadelete))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(84, 84, 84)
                                        .addComponent(jRadioButton_kayseridelete)))
                                .addContainerGap(12, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton_cikar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2)
                                .addGap(48, 48, 48))))))
            .addComponent(jButton_pie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField_adi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_yayinevi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField_kategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(jTextField_isbn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(jTextField_isbn2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(jTextField_yazar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jRadioButton_konya)
                                    .addComponent(jRadioButton_kayseri)
                                    .addComponent(jRadioButton_amasya))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton_ekle, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jRadioButton_konyadelete)
                                    .addComponent(jRadioButton_kayseridelete)
                                    .addComponent(jRadioButton_amasyadelete))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton_cikar)
                                    .addComponent(jButton2)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton_pie, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_cikarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cikarActionPerformed
        try {
            delete();
        } catch (SQLException ex) {
            Logger.getLogger(kitap_ekle_cikar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton_cikarActionPerformed

    private void jButton_ekleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ekleActionPerformed
        try {
            insert();
        } catch (SQLException ex) {
            Logger.getLogger(uye_kayit.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButton_ekleActionPerformed

    private void jTextField_adiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_adiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_adiActionPerformed

    private void jButton_pieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_pieActionPerformed
        personel_islem_ekrani pie = new personel_islem_ekrani();
        pie.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton_pieActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jTextField_adi.setText("");
        jTextField_isbn1.setText("");
        jTextField_kategori.setText("");
        jTextField_yayinevi.setText("");
        jTextField_yazar.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jTextField_isbn2.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jRadioButton_kayseriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_kayseriActionPerformed
        try {
            insertKayseri();
        } catch (SQLException ex) {
            Logger.getLogger(kitap_ekle_cikar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jRadioButton_kayseriActionPerformed

    private void jRadioButton_kayserideleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_kayserideleteActionPerformed
        try {
            deleteKayseri();
        } catch (SQLException ex) {
            Logger.getLogger(kitap_ekle_cikar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jRadioButton_kayserideleteActionPerformed

    private void jRadioButton_amasyaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_amasyaActionPerformed
        try {
            insertAmasya();
            // TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(kitap_ekle_cikar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jRadioButton_amasyaActionPerformed

    private void jRadioButton_konyaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_konyaActionPerformed
        try {
            insertKonya();
        } catch (SQLException ex) {
            Logger.getLogger(kitap_ekle_cikar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jRadioButton_konyaActionPerformed

    private void jRadioButton_amasyadeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_amasyadeleteActionPerformed
        try {
            deleteAmasya();
        } catch (SQLException ex) {
            Logger.getLogger(kitap_ekle_cikar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jRadioButton_amasyadeleteActionPerformed

    private void jRadioButton_konyadeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_konyadeleteActionPerformed
        try {
            deleteKonya();
        } catch (SQLException ex) {
            Logger.getLogger(kitap_ekle_cikar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jRadioButton_konyadeleteActionPerformed

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
            java.util.logging.Logger.getLogger(kitap_ekle_cikar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(kitap_ekle_cikar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(kitap_ekle_cikar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(kitap_ekle_cikar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new kitap_ekle_cikar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton_cikar;
    private javax.swing.JButton jButton_ekle;
    private javax.swing.JButton jButton_pie;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton_amasya;
    private javax.swing.JRadioButton jRadioButton_amasyadelete;
    private javax.swing.JRadioButton jRadioButton_kayseri;
    private javax.swing.JRadioButton jRadioButton_kayseridelete;
    private javax.swing.JRadioButton jRadioButton_konya;
    private javax.swing.JRadioButton jRadioButton_konyadelete;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField_adi;
    private javax.swing.JTextField jTextField_isbn1;
    private javax.swing.JTextField jTextField_isbn2;
    private javax.swing.JTextField jTextField_kategori;
    private javax.swing.JTextField jTextField_yayinevi;
    private javax.swing.JTextField jTextField_yazar;
    // End of variables declaration//GEN-END:variables
}
