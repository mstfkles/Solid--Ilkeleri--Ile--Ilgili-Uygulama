package com.AnalizOdev;

import com.AnalizOdev.AkilliCihaz.AgArayuzu;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class CihazKontrol {
    AgArayuzu agArayuzu=new AgArayuzu();

    public AgArayuzu getAgArayuzu() {
        return agArayuzu;
    }

    public boolean internetVarMi() {
        try {
            URL url = new URL("http://www.google.com");
            URLConnection connection = url.openConnection();
            connection.connect();
            agArayuzu.setInternetVarMi(true);
            return true;
        } catch (MalformedURLException e) {
            return false;
        } catch (IOException e) {
            return false;
        }
    }

    public void cihazAc(){
        if(agArayuzu.SogutucuAc()){
            System.out.println("Soğutucu Açılıyor...");
        }else{
            System.out.println("Soğutucu Zaten Açık...");
        }
    }
    public void cihazKapa(){
        if(agArayuzu.SogutucuAc()){
            System.out.println("Soğutucu Kapatılıyor...");
        }else{
            System.out.println("Soğutucu Zaten Kapalı...");
        }
    }
    public void sicaklikGörüntüle(){
            System.out.println("Sıcaklık : "+agArayuzu.sicaklikGör());
    }

}