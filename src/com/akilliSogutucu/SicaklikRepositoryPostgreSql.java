package com.akilliSogutucu;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SicaklikRepositoryPostgreSql implements ISicaklikRepository {

    @Override
    public void update(int sicaklik) {
        this.kaydet(sicaklik);
    }

    private Connection baglan() {

        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/akilliSogutucu",
                    "postgres", "projesifresi");
            if (conn == null)
                System.out.println("Sıcaklik server bağlantı girişimi başarısız!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    private void kaydet(int sicaklik) {
        String sql = "INSERT INTO  \"Sicaklik\" (\"sicaklik\",\"saat\") " +
                "VALUES(\'" + sicaklik + "\',\'" + new Timestamp(System.currentTimeMillis()) + "\')";

        Connection conn = this.baglan();

        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            //***** Bağlantı sonlandırma *****
            conn.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public int sonSicaklikGetir() {
        String sql = "SELECT \"sicaklik\" FROM \"Sicaklik\" ORDER BY \"saat\" DESC LIMIT 1";
        int sicaklik = 9999;

        Connection conn = this.baglan();

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            //***** Bağlantı sonlandırma *****
            conn.close();

            while (rs.next()) {
                sicaklik = rs.getInt("sicaklik");
            }

            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sicaklik;
    }
}