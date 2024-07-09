package View;

import Koneksi.Koneksi;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class Transaksi extends javax.swing.JPanel {

    public Transaksi() {
        initComponents();
        View_TabelPelanggan();
        View_Tabeltransaksi();
        reset();
        autonumber();
        cari();
    }

    void View_TabelPelanggan() {
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
                model.addRow(new Object[]{
                    resultSet.getString("Id_Pelanggan"),
                    resultSet.getString("Nama_Pelanggan"),
                    resultSet.getString("No_Telepon"),
                    resultSet.getString("Alamat")
                });
            }
            Tabel_DaftarPelanggan.setModel(model);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void reset() {
        tf_Id.setText("");
        tf_Nama.setText("");
        tf_No.setText("");
        tf_Alamat.setText("");

        tf_Id.setEditable(true);
        tf_IdT.setEditable(true);
        tf_IdJenis.setEditable(true);

        tf_tgl.setCalendar(null);

        tf_IdJenis.setText("");
        tf_JenisLaundry.setText("");
        tf_HargaLaundry.setText("");
        tf_Berat.setText("");
        tf_Total.setText("");
    }

    void View_Tabeltransaksi() {
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Tanggal");
        model.addColumn("Id Transaksi");
        model.addColumn("Nama Pelanggan");
        model.addColumn("No Telepon");
        model.addColumn("Alamat");
        model.addColumn("Jenis Laundry");
        model.addColumn("Harga");
        model.addColumn("Berat");
        model.addColumn("Total");

        try {
            String sql = "SELECT * FROM transaksi";
            java.sql.Connection conn = Koneksi.ConfigDB();
            java.sql.Statement statement = conn.createStatement();
            java.sql.ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                model.addRow(new Object[]{
                    resultSet.getString("Tanggal"),
                    resultSet.getString("Id_Transaksi"),
                    resultSet.getString("Nama_Pelanggan"),
                    resultSet.getString("No_Telepon"),
                    resultSet.getString("Alamat"),
                    resultSet.getString("Jenis_Laundry"),
                    resultSet.getString("Harga"),
                    resultSet.getString("Berat"),
                    resultSet.getString("Total")
                });
            }
            Tabel_Transaksi.setModel(model);

            Tabel_Transaksi.getColumnModel().getColumn(0).setPreferredWidth(60);
            Tabel_Transaksi.getColumnModel().getColumn(1).setPreferredWidth(65);
            Tabel_Transaksi.getColumnModel().getColumn(2).setPreferredWidth(250);
            Tabel_Transaksi.getColumnModel().getColumn(3).setPreferredWidth(150);
            Tabel_Transaksi.getColumnModel().getColumn(4).setPreferredWidth(130);
            Tabel_Transaksi.getColumnModel().getColumn(5).setPreferredWidth(80);
            Tabel_Transaksi.getColumnModel().getColumn(6).setPreferredWidth(70);
            Tabel_Transaksi.getColumnModel().getColumn(7).setPreferredWidth(30);
            Tabel_Transaksi.getColumnModel().getColumn(8).setPreferredWidth(70);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void autonumber() {
        try {
            java.sql.Connection conn = Koneksi.ConfigDB();
            java.sql.Statement statement = conn.createStatement();
            String sql = "SELECT * FROM transaksi ORDER BY Id_Transaksi DESC";
            java.sql.ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                String Id_Transaksi = resultSet.getString("Id_Transaksi").substring(2);
                String IT = "" + (Integer.parseInt(Id_Transaksi) + 1);
                String Nol = "";

                if (IT.length() == 1) {
                    Nol = "000";
                } else if (IT.length() == 2) {
                    Nol = "00";
                } else if (IT.length() == 3) {
                    Nol = "";
                }

                tf_IdT.setText("IT" + Nol + IT);
            } else {
                tf_IdT.setText("IT0001");
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("autonumber error");
        }
    }

    public void cari() {
        DefaultTableModel tabel = new DefaultTableModel();

        tabel.addColumn("Id Pelanggan");
        tabel.addColumn("Nama Pelanggan");
        tabel.addColumn("No Telepon");
        tabel.addColumn("Alamat");

        try {
            java.sql.Connection conn = Koneksi.ConfigDB();
            String sql = "SELECT * FROM Pelanggan WHERE Id_Pelanggan LIKE '%" + tf_Cari.getText() + "%' "
                    + "OR Nama_Pelanggan LIKE '%" + tf_Cari.getText() + "%'";
            java.sql.Statement statement = conn.createStatement();
            java.sql.ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                tabel.addRow(new Object[]{
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),});
            }
            Tabel_DaftarPelanggan.setModel(tabel);
        } catch (Exception e) {
            System.out.println("Cari Data Error: " + e.getMessage());
        } finally {

        }
    }

    public int Total_Harga;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tf_IdT = new javax.swing.JTextField();
        tf_IdJenis = new javax.swing.JTextField();
        tf_JenisLaundry = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabel_Transaksi = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        Tabel_DaftarPelanggan = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tf_Id = new javax.swing.JTextField();
        tf_Nama = new javax.swing.JTextField();
        tf_No = new javax.swing.JTextField();
        Scrol = new javax.swing.JScrollPane();
        tf_Alamat = new javax.swing.JTextArea();
        bt_Tambah = new javax.swing.JButton();
        bt_Ubah = new javax.swing.JButton();
        bt_Hapus = new javax.swing.JButton();
        bt_Reset = new javax.swing.JButton();
        bt_Cetak = new javax.swing.JButton();
        tf_tgl = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        tf_Cari = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        tf_HargaLaundry = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        tf_Berat = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        tf_Total = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 102, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Transaksi Pelanggan");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
        );

        jLabel2.setText("Id Transaksi");

        jLabel3.setText("Tanggal Transaksi");

        jLabel4.setText("Id Jenis");

        jLabel5.setText("Jenis Laundry");

        tf_IdT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_IdTActionPerformed(evt);
            }
        });

        tf_IdJenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_IdJenisActionPerformed(evt);
            }
        });

        tf_JenisLaundry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_JenisLaundryActionPerformed(evt);
            }
        });

        Tabel_Transaksi.setModel(new javax.swing.table.DefaultTableModel(
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
        Tabel_Transaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabel_TransaksiMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Tabel_Transaksi);

        Tabel_DaftarPelanggan.setModel(new javax.swing.table.DefaultTableModel(
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
        Tabel_DaftarPelanggan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabel_DaftarPelangganMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(Tabel_DaftarPelanggan);

        jLabel8.setText("Id Pelanggan");

        jLabel9.setText("Nama Pelanggan");

        jLabel10.setText("No. Telepon");

        jLabel11.setText("Alamat");

        tf_Id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_IdActionPerformed(evt);
            }
        });

        tf_Nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_NamaActionPerformed(evt);
            }
        });

        tf_No.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_NoActionPerformed(evt);
            }
        });

        tf_Alamat.setColumns(20);
        tf_Alamat.setRows(5);
        Scrol.setViewportView(tf_Alamat);

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
        bt_Ubah.setForeground(new java.awt.Color(255, 255, 255));
        bt_Ubah.setText("Ubah");
        bt_Ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_UbahActionPerformed(evt);
            }
        });

        bt_Hapus.setBackground(new java.awt.Color(255, 0, 0));
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

        bt_Cetak.setBackground(new java.awt.Color(153, 0, 153));
        bt_Cetak.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bt_Cetak.setForeground(new java.awt.Color(255, 255, 255));
        bt_Cetak.setText("Cetak");
        bt_Cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_CetakActionPerformed(evt);
            }
        });

        jLabel7.setText("Cari Pelangan");

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

        jLabel12.setText("Harga");

        jLabel13.setText("Berat/Satuan");

        tf_Berat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_BeratActionPerformed(evt);
            }
        });
        tf_Berat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_BeratKeyReleased(evt);
            }
        });

        jLabel14.setText("Total");

        tf_Total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_TotalActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Search2.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(bt_Tambah)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt_Ubah)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                                .addComponent(bt_Hapus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt_Reset)
                                .addGap(14, 14, 14))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14))
                                .addGap(52, 52, 52)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tf_JenisLaundry)
                                    .addComponent(tf_IdT, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tf_tgl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(tf_IdJenis, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton1))
                                    .addComponent(tf_HargaLaundry)
                                    .addComponent(tf_Berat)
                                    .addComponent(tf_Total))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_Id, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Scrol, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                            .addComponent(tf_No, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                            .addComponent(tf_Nama, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                            .addComponent(tf_Cari)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bt_Cetak, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(tf_IdT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tf_Cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(tf_tgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tf_IdJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tf_JenisLaundry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tf_HargaLaundry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tf_Berat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tf_Total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(bt_Tambah)
                                    .addComponent(bt_Ubah)
                                    .addComponent(bt_Hapus)
                                    .addComponent(bt_Reset))
                                .addGap(30, 30, 30))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(tf_Id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(tf_Nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tf_No, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Scrol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_Cetak))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 404, Short.MAX_VALUE)))
                .addContainerGap())
        );

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void tf_IdTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_IdTActionPerformed

    }//GEN-LAST:event_tf_IdTActionPerformed

    private void tf_IdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_IdActionPerformed

    }//GEN-LAST:event_tf_IdActionPerformed

    private void bt_UbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_UbahActionPerformed

        try {
            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
            String Tanggal = String.valueOf(sd.format(tf_tgl.getDate()));

            String Id_Transaksi = tf_IdT.getText();
            String Nama_Pelanggan = tf_Nama.getText();
            String No_Telepon = tf_No.getText();
            String Alamat = tf_Alamat.getText();
            String Jenis_Laundry = tf_JenisLaundry.getText();
            String Harga = tf_HargaLaundry.getText();
            String Berat = tf_Berat.getText();
            String Total = tf_Total.getText();

            String sql = "UPDATE Transaksi SET Tanggal = ?, Nama_Pelanggan = ?, No_Telepon = ?, Alamat = ?, Jenis_Laundry = ?, Harga = ?, Berat = ?, Total = ? WHERE Id_Transaksi = ?";
            java.sql.Connection conn = Koneksi.ConfigDB();
            java.sql.PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, Tanggal);
            preparedStatement.setString(2, Nama_Pelanggan);
            preparedStatement.setString(3, No_Telepon);
            preparedStatement.setString(4, Alamat);
            preparedStatement.setString(5, Jenis_Laundry);
            preparedStatement.setString(6, Harga);
            preparedStatement.setString(7, Berat);
            preparedStatement.setString(8, Total);
            preparedStatement.setString(9, Id_Transaksi);

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
            } else {
                JOptionPane.showMessageDialog(null, "Data Gagal Diubah atau Id_Transaksi tidak ditemukan");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

        View_Tabeltransaksi();
        reset();
        autonumber();
    }//GEN-LAST:event_bt_UbahActionPerformed

    private void Tabel_DaftarPelangganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabel_DaftarPelangganMouseClicked
        int baris = Tabel_DaftarPelanggan.rowAtPoint(evt.getPoint());
        String Id_Pelanggan = Tabel_DaftarPelanggan.getValueAt(baris, 0).toString();
        String Nama_Pelanggan = Tabel_DaftarPelanggan.getValueAt(baris, 1).toString();
        String No_Telepon = Tabel_DaftarPelanggan.getValueAt(baris, 2).toString();
        String Alamat = Tabel_DaftarPelanggan.getValueAt(baris, 3).toString();
        tf_Id.setText(Id_Pelanggan);
        tf_Nama.setText(Nama_Pelanggan);
        tf_No.setText(No_Telepon);
        tf_Alamat.setText(Alamat);
        tf_Id.setEditable(false);
    }//GEN-LAST:event_Tabel_DaftarPelangganMouseClicked

    private void Tabel_TransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabel_TransaksiMouseClicked
        int baris = Tabel_Transaksi.rowAtPoint(evt.getPoint());
        if (baris == -1) {
            JOptionPane.showMessageDialog(null, "Pilih baris terlebih dahulu");
            return;
        }

        String Tanggal = Tabel_Transaksi.getValueAt(baris, 0).toString();
        String Id_Transaksi = Tabel_Transaksi.getValueAt(baris, 1).toString();
        String Nama_Pelanggan = Tabel_Transaksi.getValueAt(baris, 2).toString();
        String No_Telepon = Tabel_Transaksi.getValueAt(baris, 3).toString();
        String Alamat = Tabel_Transaksi.getValueAt(baris, 4).toString();
        String Jenis_Laundry = Tabel_Transaksi.getValueAt(baris, 5).toString();
        String Harga = Tabel_Transaksi.getValueAt(baris, 6).toString();
        String Berat = Tabel_Transaksi.getValueAt(baris, 7).toString();
        String Total = Tabel_Transaksi.getValueAt(baris, 8).toString();

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(Tanggal);
            tf_tgl.setDate(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        tf_IdT.setText(Id_Transaksi);
        tf_Nama.setText(Nama_Pelanggan);
        tf_No.setText(No_Telepon);
        tf_Alamat.setText(Alamat);
        tf_JenisLaundry.setText(Jenis_Laundry);
        tf_HargaLaundry.setText(Harga);
        tf_Berat.setText(Berat);
        tf_Total.setText(Total);
        tf_IdT.setEditable(false);
    }//GEN-LAST:event_Tabel_TransaksiMouseClicked

    private void tf_IdJenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_IdJenisActionPerformed

    }//GEN-LAST:event_tf_IdJenisActionPerformed

    private void tf_JenisLaundryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_JenisLaundryActionPerformed

    }//GEN-LAST:event_tf_JenisLaundryActionPerformed

    private void tf_NamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_NamaActionPerformed

    }//GEN-LAST:event_tf_NamaActionPerformed

    private void bt_TambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_TambahActionPerformed
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        String Tanggal = String.valueOf(sd.format(tf_tgl.getDate()));

        String Id_Transaksi = tf_IdT.getText();
        String Nama_Pelanggan = tf_Nama.getText();
        String No_Telepon = tf_No.getText();
        String Alamat = tf_Alamat.getText();
        String Jenis_Laundry = tf_JenisLaundry.getText();
        String Harga = tf_HargaLaundry.getText();
        String Berat = tf_Berat.getText();
        String Total = tf_Total.getText();

        try {
            String sql = "INSERT INTO transaksi (Tanggal,Id_Transaksi,Nama_Pelanggan,No_Telepon,Alamat,Jenis_Laundry,Harga,Berat,Total) VALUES('" + Tanggal + "','" + Id_Transaksi + "','" + Nama_Pelanggan + "','" + No_Telepon + "','" + Alamat + "','" + Jenis_Laundry + "','" + Harga + "','" + Berat + "','" + Total + "')";
            java.sql.Connection conn = Koneksi.ConfigDB();
            java.sql.Statement statement = conn.createStatement();
            statement.execute(sql);
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        View_Tabeltransaksi();
        reset();
        autonumber();
    }//GEN-LAST:event_bt_TambahActionPerformed

    private void bt_HapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_HapusActionPerformed
        String Id_Transaksi = tf_IdT.getText();

        try {
            String sql = "DELETE FROM transaksi WHERE Id_Transaksi ='" + Id_Transaksi + "'";
            java.sql.Connection conn = Koneksi.ConfigDB();
            java.sql.Statement statement = conn.createStatement();
            statement.execute(sql);
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        View_Tabeltransaksi();
        reset();
        autonumber();
    }//GEN-LAST:event_bt_HapusActionPerformed

    private void tf_NoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_NoActionPerformed
    }//GEN-LAST:event_tf_NoActionPerformed

    private void tf_BeratActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_BeratActionPerformed
    }//GEN-LAST:event_tf_BeratActionPerformed

    private void tf_TotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_TotalActionPerformed
    }//GEN-LAST:event_tf_TotalActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        List_Jenis a = new List_Jenis();
        a.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bt_ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ResetActionPerformed
        reset();
        autonumber();
    }//GEN-LAST:event_bt_ResetActionPerformed

    private void tf_BeratKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_BeratKeyReleased
        if (tf_Berat.getText().equals("")) {
            tf_HargaLaundry.setText("0");
        } else {
            int Harga = Integer.parseInt(tf_HargaLaundry.getText());
            int Berat = Integer.parseInt(tf_Berat.getText());
            Total_Harga = Harga * Berat;
            tf_Total.setText(String.valueOf(Total_Harga));
        }
    }//GEN-LAST:event_tf_BeratKeyReleased

    private void tf_CariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_CariActionPerformed
        cari();
    }//GEN-LAST:event_tf_CariActionPerformed

    private void tf_CariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_CariKeyTyped
        cari();
    }//GEN-LAST:event_tf_CariKeyTyped

    private void bt_CetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_CetakActionPerformed
        int row = Tabel_Transaksi.getSelectedRow();

        if (row >= 0) {
            String id = Tabel_Transaksi.getValueAt(row, 1).toString();

            try {
                String reportPath = "src/iReport/Nota_Pelanggan.jasper";

                HashMap<String, Object> parameters = new HashMap<>();
                parameters.put("id", id);

                JasperPrint print = JasperFillManager.fillReport(reportPath, parameters, Koneksi.ConfigDB());
                JasperViewer viewer = new JasperViewer(print, false);
                viewer.setExtendedState(JasperViewer.MAXIMIZED_BOTH);
                viewer.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Gagal mencetak laporan: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Pilih data transaksi terlebih dahulu!");
        }
    }//GEN-LAST:event_bt_CetakActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane Scrol;
    private javax.swing.JTable Tabel_DaftarPelanggan;
    private javax.swing.JTable Tabel_Transaksi;
    private javax.swing.JButton bt_Cetak;
    private javax.swing.JButton bt_Hapus;
    private javax.swing.JButton bt_Reset;
    private javax.swing.JButton bt_Tambah;
    private javax.swing.JButton bt_Ubah;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea tf_Alamat;
    private javax.swing.JTextField tf_Berat;
    public static javax.swing.JTextField tf_Cari;
    public static javax.swing.JTextField tf_HargaLaundry;
    private javax.swing.JTextField tf_Id;
    public static javax.swing.JTextField tf_IdJenis;
    private javax.swing.JTextField tf_IdT;
    public static javax.swing.JTextField tf_JenisLaundry;
    private javax.swing.JTextField tf_Nama;
    private javax.swing.JTextField tf_No;
    private javax.swing.JTextField tf_Total;
    private com.toedter.calendar.JDateChooser tf_tgl;
    // End of variables declaration//GEN-END:variables
}
