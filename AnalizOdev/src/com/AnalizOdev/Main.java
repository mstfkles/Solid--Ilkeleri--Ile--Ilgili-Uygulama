package com.AnalizOdev;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CihazKontrol kontrol=new CihazKontrol();
        kontrol.internetVarMi();
        Login login=new Login();
        Scanner sc=new Scanner(System.in);
        String ad;
        String parola;
        int whileKontrol=-1;
        if(kontrol.getAgArayuzu().isInternetVarMi()) {
            System.out.println("Kullanici Adi=");
            ad=sc.nextLine();
            System.out.println("Şifre=");
            parola=sc.nextLine();
            System.out.println("İnternetiniz bağlı durumdadır...");
            if (login.Giris(ad, parola)) {
                System.out.println("Kullanıcı Bulundu...");
                kontrol.sicaklikGörüntüle();
                System.out.println("\n");
                while (whileKontrol != 0) {
                    System.out.println("Soğutucu açmak için             \t->\t1\n" +
                            "Soğutucu kapamak için           \t->\t2\n" +
                            "Sıcaklık görüntülemek için      \t->\t3\n" +
                            "Çıkış için                      \t->\t0\n"
                    );
                    whileKontrol = sc.nextInt();
                    switch (whileKontrol) {
                        case 1:
                            kontrol.cihazAc();
                            break;
                        case 2:
                            kontrol.cihazKapa();
                            break;
                        case 3:
                            kontrol.sicaklikGörüntüle();
                            break;
                    }
                }
            }
            else {
                System.out.println("Kullanıcı bulunamadı.");
            }
        }
        else {
            System.out.println("İNTERNET BAĞLI DEĞİL , LÜTFEN İNTERNETİNİZİ KONTROL EDİNİZ.");
        }
    }
}