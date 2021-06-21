package com.AnalizOdev.AkilliCihaz;

import com.AnalizOdev.AkilliCihaz.Interfaces.Observer;
import com.AnalizOdev.AkilliCihaz.MerkeziIslemBirimi.MIB;

public class Eyleyici implements Observer {
    private static Eyleyici instance;
    private SicaklikAlgilama algilama;
    private MIB mib;
    private Eyleyici(){}

    public static Eyleyici getInstance(){

        if (instance == null){
            instance = new Eyleyici();
        }

        return instance;
    }
    @Override
    public void SogutucuKapat() {
        System.out.println("Soğutucu Kapatılıyor...");
        mib.SogutucuKapat();
    }

    @Override
    public void SogutucuAc() {
        System.out.println("Soğutucu Açılıyor...");
        mib.SogutucuAc();
    }
}
