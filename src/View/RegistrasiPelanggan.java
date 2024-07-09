package View;

import Koneksi.Koneksi;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class RegistrasiPelanggan extends javax.swing.JPanel {

    private void autonumber() {
        try {
            java.sql.Connection conn = Koneksi.ConfigDB();
            java.sql.Statement statement = conn.createStatement();
            String sql = "SELECT * FROM pelanggan ORDER BY Id_Pelanggan DESC";
            java.sql.ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                String Id_Pelanggan = resultSet.getString("Id_Pelanggan").substring(2);
                String IP = "" + (Integer.parseInt(Id_Pelanggan) + 1);
                String Nol = "";

                if (IP.length() == 1) {
                    Nol = "000";
                } else if (IP.length() == 2) {
                    Nol = "00";
                } else if (IP.length() == 3) {
                    Nol = "";
                }

                tf_Id.setText("IP" + Nol + IP);
            } else {
                tf_Id.setText("IP0001");
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("autonumber error");
        }
    }

    public RegistrasiPelanggan() {
        initComponents();
        View_TB_RegPelanggan();
        reset();
        autonumber();
    }

    void View_TB_RegPelanggan() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id Pelanggan");
        model.addColumn("Nama Pelanggan");
        model.addColumn("No Telepon");
        model.addColumn("Alamat");
        try {
            String sql = "SELECT * FROM pelanggan";
            java.sql.Connection conn = Koneksi.ConfigDB();
            java.sql.Statement statement = conn.createStatement();
            java.sql.ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                model.addRow(new Object[]{resultSet.getString("Id_Pelanggan"), resultSet.getString("Nama_Pelanggan"), resultSet.getString("No_Telepon"), resultSet.getString("Alamat")});
            }
            Tabel_RegistrasiPelanggan.setModel(model);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void reset() {
        tf_Nama.setText("");
        tf_No.setText("");
        tf_Alamat.setText("");
        tf_Id.setEditable(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tf_Nama = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tf_Id = new javax.swing.JTextField();
        tf_No = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tf_Alamat = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabel_RegistrasiPelanggan = new javax.swing.JTable();
        bt_Tambah = new javax.swing.JButton();
        bt_Ubah = new javax.swing.JButton();
        bt_Hapus = new javax.swing.JButton();
        bt_Reset = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Blue"));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registrasi Pelanggan");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
        );

        jLabel2.setText("Id Pelanggan");

        tf_Nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_NamaActionPerformed(evt);
            }
        });

        jLabel3.setText("Nama Pelanggan");

        jLabel4.setText("No. Telepon");

        jLabel5.setText("Alamat");

        tf_Id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_IdActionPerformed(evt);
            }
        });
        tf_Id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_IdKeyTyped(evt);
            }
        });

        tf_No.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_NoActionPerformed(evt);
            }
        });

        tf_Alamat.setColumns(20);
        tf_Alamat.setRows(5);
        jScrollPane1.setViewportView(tf_Alamat);

        Tabel_RegistrasiPelanggan.setModel(new javax.swing.table.DefaultTableModel(
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
        Tabel_RegistrasiPelanggan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabel_RegistrasiPelangganMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Tabel_RegistrasiPelanggan);

        bt_Tambah.setBackground(new java.awt.Color(0, 0, 204));
        bt_Tambah.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bt_Tambah.setForeground(new java.awt.Color(255, 255, 255));
        bt_Tambah.setText("Tambah");
        bt_Tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_TambahActionPerformed(evt);
            }
        });

        bt_Ubah.setBackground(new java.awt.Color(0, 204, 0));
        bt_Ubah.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bt_Ubah.setText("Ubah");
        bt_Ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_UbahActionPerformed(evt);
            }
        });

        bt_Hapus.setBackground(new java.awt.Color(204, 0, 0));
        bt_Hapus.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bt_Hapus.setForeground(new java.awt.Color(255, 255, 255));
        bt_Hapus.setText("Hapus");
        bt_Hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_HapusActionPerformed(evt);
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

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/cccc.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel4))
                                        .addGap(49, 49, 49)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tf_Id, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(tf_No, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                                                    .addComponent(tf_Nama))
                                                .addGap(100, 100, 100)
                                                .addComponent(jLabel5)))))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(430, 430, 430)
                                .addComponent(bt_Tambah)
                                .addGap(18, 18, 18)
                                .addComponent(bt_Ubah)
                                .addGap(18, 18, 18)
                                .addComponent(bt_Hapus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bt_Reset)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 242, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(55, 55, 55))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(tf_Id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(tf_Nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(tf_No, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(141, 141, 141)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt_Tambah)
                            .addComponent(bt_Ubah)
                            .addComponent(bt_Hapus)
                            .addComponent(bt_Reset)))
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void bt_UbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_UbahActionPerformed
        String Id_pelanggan = tf_Id.getText();
        String Nama_Pelanggan = tf_Nama.getText();
        String No_Telepon = tf_No.getText();
        String Alamat = tf_Alamat.getText();

        try {
            String sql = "UPDATE Pelanggan SET Nama_Pelanggan = ?, No_Telepon = ?, Alamat = ? WHERE Id_Pelanggan = ?";
            java.sql.Connection conn = Koneksi.ConfigDB();
            java.sql.PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, Nama_Pelanggan);
            preparedStatement.setString(2, No_Telepon);
            preparedStatement.setString(3, Alamat);
            preparedStatement.setString(4, Id_pelanggan);

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
            } else {
                JOptionPane.showMessageDialog(null, "Data Gagal Diubah atau Id_Pelanggan tidak ditemukan");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        View_TB_RegPelanggan();
        reset();
    reset();    }//GEN-LAST:event_bt_UbahActionPerformed

    private void tf_NamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_NamaActionPerformed
    }//GEN-LAST:event_tf_NamaActionPerformed

    private void tf_IdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_IdActionPerformed
    }//GEN-LAST:event_tf_IdActionPerformed

    private void bt_TambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_TambahActionPerformed
        String Id_Pelanggan = tf_Id.getText();
        String Nama_Pelanggan = tf_Nama.getText();
        String No_Telepon = tf_No.getText();
        String Alamat = tf_Alamat.getText();

        try {
            String sql = "INSERT INTO pelanggan(Id_Pelanggan,Nama_Pelanggan,No_Telepon,Alamat) VALUES('" + Id_Pelanggan + "','" + Nama_Pelanggan + "','" + No_Telepon + "','" + Alamat + "')";
            java.sql.Connection conn = Koneksi.ConfigDB();
            java.sql.Statement statement = conn.createStatement();
            statement.execute(sql);
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        View_TB_RegPelanggan();
        reset();
        autonumber();
    }//GEN-LAST:event_bt_TambahActionPerformed

    private void bt_HapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_HapusActionPerformed
        String Id_Pelanggan = tf_Id.getText();

        try {
            String sql = "DELETE FROM Pelanggan WHERE Id_Pelanggan ='" + Id_Pelanggan + "'";
            java.sql.Connection conn = Koneksi.ConfigDB();
            java.sql.Statement statement = conn.createStatement();
            statement.execute(sql);
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        View_TB_RegPelanggan();
        reset();
    }//GEN-LAST:event_bt_HapusActionPerformed

    private void Tabel_RegistrasiPelangganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabel_RegistrasiPelangganMouseClicked
        int baris = Tabel_RegistrasiPelanggan.rowAtPoint(evt.getPoint());
        String Id_Pelanggan = Tabel_RegistrasiPelanggan.getValueAt(baris, 0).toString();
        String Nama_Pelanggan = Tabel_RegistrasiPelanggan.getValueAt(baris, 1).toString();
        String No_Telepon = Tabel_RegistrasiPelanggan.getValueAt(baris, 2).toString();
        String Alamat = Tabel_RegistrasiPelanggan.getValueAt(baris, 3).toString();
        tf_Id.setText(Id_Pelanggan);
        tf_Nama.setText(Nama_Pelanggan);
        tf_No.setText(No_Telepon);
        tf_Alamat.setText(Alamat);
        tf_Id.setEditable(false);
    }//GEN-LAST:event_Tabel_RegistrasiPelangganMouseClicked

    private void bt_ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ResetActionPerformed
        reset();
        autonumber();
    }//GEN-LAST:event_bt_ResetActionPerformed

    private void tf_IdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_IdKeyTyped
    }//GEN-LAST:event_tf_IdKeyTyped

    private void tf_NoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_NoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_NoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabel_RegistrasiPelanggan;
    private javax.swing.JButton bt_Hapus;
    private javax.swing.JButton bt_Reset;
    private javax.swing.JButton bt_Tambah;
    private javax.swing.JButton bt_Ubah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea tf_Alamat;
    private javax.swing.JTextField tf_Id;
    private javax.swing.JTextField tf_Nama;
    private javax.swing.JTextField tf_No;
    // End of variables declaration//GEN-END:variables
}
