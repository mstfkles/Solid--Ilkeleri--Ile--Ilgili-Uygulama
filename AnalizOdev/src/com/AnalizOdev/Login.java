package com.AnalizOdev;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Login {
    private Connection connection=null;
    PreparedStatement stmt= null;
    private  String sorgu="Select * from kullanici where kullaniciad=? and parola=?";
    private int sayac=0;
    private void Baglan(){
        try {
            Class.forName("org.postgresql.Driver");
            connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/analız_odev","postgres", "Mustafa");
        }catch (Exception e){
            System.out.println("Veritabanına Bağlanılamadı...");
            sayac=1;
        }
        if (sayac==0) {
            System.out.println("Veritabanına Bağlanıldı...");
        }
    }
    public boolean Giris(String ad,String parola){
        this.Baglan();
        ResultSet rs=null;
        List<Kullanici> kullanicilar=new ArrayList<>();
        try {
            stmt= connection.prepareStatement(sorgu);
            stmt.setString(1,ad);
            stmt.setString(2,parola);
            rs =stmt.executeQuery();
            while (rs.next()){
                kullanicilar.add(new Kullanici(
                               rs.getString("kullaniciad"),
                               rs.getString("parola")
                ));
            }
            rs.close();
            stmt.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }finally {
            try { rs.close(); } catch (Exception e) { /* ignored */ }
            try { stmt.close(); } catch (Exception e) { /* ignored */ }
            try { connection.close(); } catch (Exception e) { /* ignored */ }
        }
        if(kullanicilar.isEmpty() || kullanicilar.size()>1){
            return false;
        }else {
            return true;
        }

    }

    private class Kullanici{
        private String kullaniciAd;
        private String parola;

        public Kullanici() {
        }

        public Kullanici(String kullaniciAd, String parola) {
            this.kullaniciAd = kullaniciAd;
            this.parola = parola;
        }

        public String getKullaniciAd() {
            return kullaniciAd;
        }

        public void setKullaniciAd(String kullaniciAd) {
            this.kullaniciAd = kullaniciAd;
        }

        public String getParola() {
            return parola;
        }

        public void setParola(String parola) {
            this.parola = parola;
        }

    }
}
