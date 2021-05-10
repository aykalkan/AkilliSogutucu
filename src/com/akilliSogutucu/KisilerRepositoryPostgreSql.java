package com.akilliSogutucu;

import sun.security.krb5.internal.crypto.KeyUsage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class KisilerRepositoryPostgreSql {

    private Connection baglan() {

        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/akilliSogutucu",
                    "postgres", "projesifresi");
            if (conn != null)
                System.out.println("Veritabanına bağlandı!");
            else
                System.out.println("Bağlantı girişimi başarısız!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public Kullanici ara(int id) {
        System.out.println("Kullanıcı aranıyor...");
        Kullanici kullanici = null;

        String sql = "SELECT *  FROM \"Kullanicilar\" WHERE \"id\"=" + id;

        Connection conn = this.baglan();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            //***** Bağlantı sonlandırma *****
            conn.close();

            String isim;
            String sifre;
            int yas;

            while (rs.next()) {
                isim = rs.getString("isim");
                sifre = rs.getString("sifre");
                yas = rs.getInt("yas");

                kullanici = new Kullanici.Builder(isim, sifre)
                        .setId(id)
                        .setYas(yas)
                        .build();
            }

            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return kullanici;
    }

    public boolean kullaniciDogrula(Kullanici kullanici) {
        System.out.println("Kullanıcı doğrulanıyor...");

        boolean sonuc = false;

        String sql = "SELECT * FROM \"Kullanicilar\" WHERE isim = \'" + kullanici.getIsim() +
                "\' AND sifre = \'" + kullanici.getSifre() + "\'" ;

        Connection conn = this.baglan();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            //***** Bağlantı sonlandırma *****
            conn.close();

            sonuc = rs.next();

            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sonuc;
    }

    public List<Kullanici> tumKullanicilar() {

        System.out.println("Kullanıcılar getiriyor...");
        List<Kullanici> kullanicilar = new ArrayList<Kullanici>();
        String sql = "SELECT *  FROM \"Kullanicilar\"";

        Connection conn = this.baglan();

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            //***** Bağlantı sonlandırma *****
            conn.close();

            int id;
            String isim;
            String sifre;
            int yas;

            while (rs.next()) {
                id = rs.getInt("id");
                isim = rs.getString("isim");
                sifre = rs.getString("sifre");
                yas = rs.getInt("yas");

                kullanicilar.add(new Kullanici.Builder(isim, sifre).setId(id).setYas(yas).build());
            }

            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kullanicilar;
    }


    public void kaydet(Kullanici kullanici) {
        String sql = "INSERT INTO  \"Kullanicilar\" (\"isim\",\"sifre\",\"yas\") " +
                "VALUES(\'" + kullanici.getIsim() + "\'," + kullanici.getSifre() + "," + kullanici.getYas() + ")";

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

    public void sil(int id) {
        System.out.println("Kullanici siliniyor...");

        String sql = "DELETE FROM \"Kullanicilar\" WHERE \"id\"=" + id;

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

    public void degistir(Kullanici kullanici) {

        String sql = "UPDATE \"Kullanicilar\" SET " +
                "\"isim\"=" + kullanici.getIsim() +
                "\"birimFiyati\"=" + kullanici.getSifre() +
                ",\"stokMiktari\"=" + kullanici.getYas() +
                " WHERE \"id\"=" + kullanici.getId();

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
}