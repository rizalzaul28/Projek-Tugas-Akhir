package View;

import Koneksi.Koneksi;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class List_Jenis extends javax.swing.JFrame {

    public List_Jenis() {
        initComponents();
        reset();
        View_TabelJenis();
        autonumber();
        cari();

    }

    void View_TabelJenis() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id Jenis");
        model.addColumn("Jenis Laundry");
        model.addColumn("Harga");
        try {
            String sql = "SELECT * FROM List_Jenis";
            java.sql.Connection conn = Koneksi.ConfigDB();
            java.sql.Statement statement = conn.createStatement();
            java.sql.ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                model.addRow(new Object[]{resultSet.getString("Id_Jenis"), resultSet.getString("Jenis_Laundry"), resultSet.getString("Harga")});
            }
            Tabel_List.setModel(model);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void reset() {
        tf_Jenis.setText("");
        tf_harga.setText("");
        tf_Id.setEditable(true);
    }

    private void autonumber() {
        try {
            java.sql.Connection conn = Koneksi.ConfigDB();
            java.sql.Statement statement = conn.createStatement();
            String sql = "SELECT * FROM List_Jenis ORDER BY Id_Jenis DESC";
            java.sql.ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                String Id_Jenis = resultSet.getString("Id_Jenis").substring(2);
                String IJ = "" + (Integer.parseInt(Id_Jenis) + 1);
                String Nol = "";

                if (IJ.length() == 1) {
                    Nol = "000";
                } else if (IJ.length() == 2) {
                    Nol = "00";
                } else if (IJ.length() == 3) {
                    Nol = "";
                }

                tf_Id.setText("IJ" + Nol + IJ);
            } else {
                tf_Id.setText("IJ0001");
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("autonumber error");
        }
    }

    public void cari() {
        DefaultTableModel tabel = new DefaultTableModel();

        tabel.addColumn("Id Jenis");
        tabel.addColumn("Jenis Laundry");
        tabel.addColumn("Harga");

        try {
            java.sql.Connection conn = Koneksi.ConfigDB();
            String sql = "SELECT * FROM list_jenis WHERE Id_Jenis LIKE '%" + tf_Cari.getText() + "%' "
                    + "OR Jenis_Laundry LIKE '%" + tf_Cari.getText() + "%'";
            java.sql.Statement statement = conn.createStatement();
            java.sql.ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                tabel.addRow(new Object[]{
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),});
            }
            Tabel_List.setModel(tabel);

            Tabel_List.getColumnModel().getColumn(0).setPreferredWidth(60);
            Tabel_List.getColumnModel().getColumn(1).setPreferredWidth(100);
            Tabel_List.getColumnModel().getColumn(2).setPreferredWidth(100);

        } catch (Exception e) {
            System.out.println("Cari Data Error: " + e.getMessage());
        } finally {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tf_Cari = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tf_Id = new javax.swing.JTextField();
        tf_Jenis = new javax.swing.JTextField();
        tf_harga = new javax.swing.JTextField();
        bt_Tambah = new javax.swing.JButton();
        bt_Reset = new javax.swing.JButton();
        bt_Ubah = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabel_List = new javax.swing.JTable();
        bt_Pilih = new javax.swing.JButton();
        bt_Batal = new javax.swing.JButton();
        bt_Hapus = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 0, 153));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("List Jenis Laundry");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
        );

        jLabel2.setText("Cari");

        tf_Cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_CariActionPerformed(evt);
            }
        });
        tf_Cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_CariKeyTyped(evt);
            }
        });

        jLabel3.setText("Id jenis");

        jLabel4.setText("Jenis Laundry");

        jLabel5.setText("Harga");

        bt_Tambah.setBackground(new java.awt.Color(0, 0, 204));
        bt_Tambah.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bt_Tambah.setForeground(new java.awt.Color(255, 255, 255));
        bt_Tambah.setText("Tambah");
        bt_Tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_TambahActionPerformed(evt);
            }
        });

        bt_Reset.setBackground(new java.awt.Color(255, 0, 0));
        bt_Reset.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bt_Reset.setText("Reset");
        bt_Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ResetActionPerformed(evt);
            }
        });

        bt_Ubah.setBackground(new java.awt.Color(0, 255, 0));
        bt_Ubah.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bt_Ubah.setForeground(new java.awt.Color(255, 255, 255));
        bt_Ubah.setText("Ubah");
        bt_Ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_UbahActionPerformed(evt);
            }
        });

        Tabel_List.setModel(new javax.swing.table.DefaultTableModel(
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
        Tabel_List.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabel_ListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabel_List);

        bt_Pilih.setBackground(new java.awt.Color(153, 153, 255));
        bt_Pilih.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bt_Pilih.setForeground(new java.awt.Color(255, 255, 255));
        bt_Pilih.setText("Pilih");
        bt_Pilih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_PilihActionPerformed(evt);
            }
        });

        bt_Batal.setBackground(new java.awt.Color(255, 51, 51));
        bt_Batal.setText("Batal");
        bt_Batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_BatalActionPerformed(evt);
            }
        });

        bt_Hapus.setBackground(new java.awt.Color(255, 0, 0));
        bt_Hapus.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bt_Hapus.setText("Hapus");
        bt_Hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_HapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(tf_Cari, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tf_Id)
                                    .addComponent(tf_Jenis)
                                    .addComponent(tf_harga))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_Tambah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_Ubah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_Hapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_Reset)
                        .addGap(0, 33, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(bt_Pilih)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_Batal)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tf_Cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tf_Id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tf_Jenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tf_harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_Tambah)
                    .addComponent(bt_Ubah)
                    .addComponent(bt_Hapus)
                    .addComponent(bt_Reset))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_Pilih)
                    .addComponent(bt_Batal))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_BatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_BatalActionPerformed
        this.dispose();
    }//GEN-LAST:event_bt_BatalActionPerformed

    private void bt_TambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_TambahActionPerformed
        String Id_Jenis = tf_Id.getText();
        String Jenis_Laundry = tf_Jenis.getText();
        String Harga = tf_harga.getText();

        try {
            String sql = "INSERT INTO List_Jenis (Id_Jenis,Jenis_Laundry,Harga) VALUES('" + Id_Jenis + "','" + Jenis_Laundry + "','" + Harga + "')";
            java.sql.Connection conn = Koneksi.ConfigDB();
            java.sql.Statement statement = conn.createStatement();
            statement.execute(sql);
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        View_TabelJenis();
        reset();
        autonumber();
    }//GEN-LAST:event_bt_TambahActionPerformed

    private void bt_HapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_HapusActionPerformed
        String Id_Jenis = tf_Id.getText();

        try {
            String sql = "DELETE FROM List_Jenis WHERE Id_Jenis ='" + Id_Jenis + "'";
            java.sql.Connection conn = Koneksi.ConfigDB();
            java.sql.Statement statement = conn.createStatement();
            statement.execute(sql);
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        View_TabelJenis();
        reset();
        autonumber();
    }//GEN-LAST:event_bt_HapusActionPerformed

    private void Tabel_ListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabel_ListMouseClicked
        int baris = Tabel_List.rowAtPoint(evt.getPoint());
        String Id_Jenis = Tabel_List.getValueAt(baris, 0).toString();
        String Jenis_Laundry = Tabel_List.getValueAt(baris, 1).toString();
        String Harga = Tabel_List.getValueAt(baris, 2).toString();
        tf_Id.setText(Id_Jenis);
        tf_Jenis.setText(Jenis_Laundry);
        tf_harga.setText(Harga);
        tf_Id.setEditable(false);
    }//GEN-LAST:event_Tabel_ListMouseClicked

    private void bt_ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ResetActionPerformed
        reset();
        autonumber();
    }//GEN-LAST:event_bt_ResetActionPerformed

    private void bt_UbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_UbahActionPerformed
        String Id_Jenis = tf_Id.getText();
        String Jenis_Laundry = tf_Jenis.getText();
        String Harga = tf_harga.getText();

        try {
            String sql = "UPDATE List_Jenis SET Jenis_Laundry = ?, Harga = ? WHERE Id_Jenis = ?";
            java.sql.Connection conn = Koneksi.ConfigDB();
            java.sql.PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, Jenis_Laundry);
            preparedStatement.setString(2, Harga);
            preparedStatement.setString(3, Id_Jenis);

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
            } else {
                JOptionPane.showMessageDialog(null, "Data Gagal Diubah atau Id_Jenis tidak ditemukan");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        View_TabelJenis();
        reset();
        autonumber();
    }//GEN-LAST:event_bt_UbahActionPerformed

    private void bt_PilihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_PilihActionPerformed
        int i = Tabel_List.getSelectedRow();

        String kode_jenis = Tabel_List.getValueAt(i, 0).toString();
        String jenis_laundry = Tabel_List.getValueAt(i, 1).toString();
        String harga = Tabel_List.getValueAt(i, 2).toString();

        Transaksi.tf_IdJenis.setText(kode_jenis);
        Transaksi.tf_JenisLaundry.setText(jenis_laundry);
        Transaksi.tf_HargaLaundry.setText(harga);

        dispose();
    }//GEN-LAST:event_bt_PilihActionPerformed

    private void tf_CariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_CariActionPerformed
        cari();
    }//GEN-LAST:event_tf_CariActionPerformed

    private void tf_CariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_CariKeyTyped
        cari();
    }//GEN-LAST:event_tf_CariKeyTyped

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
            java.util.logging.Logger.getLogger(List_Jenis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(List_Jenis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(List_Jenis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(List_Jenis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new List_Jenis().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabel_List;
    private javax.swing.JButton bt_Batal;
    private javax.swing.JButton bt_Hapus;
    private javax.swing.JButton bt_Pilih;
    private javax.swing.JButton bt_Reset;
    private javax.swing.JButton bt_Tambah;
    private javax.swing.JButton bt_Ubah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextField tf_Cari;
    private javax.swing.JTextField tf_Id;
    private javax.swing.JTextField tf_Jenis;
    private javax.swing.JTextField tf_harga;
    // End of variables declaration//GEN-END:variables
}
