package Koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {

    public static Connection mysqlconfig;

    public static Connection ConfigDB() throws SQLException {
        try {
            String url = "jdbc:mysql://localhost:3306/Laundry_Cahaya";
            String user = "root";
            String password = "";
            mysqlconfig = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.err.println("Koneksi Gagal " + e.getMessage());
        }
        return mysqlconfig;
    }
}
