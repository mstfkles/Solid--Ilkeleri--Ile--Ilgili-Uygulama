package com.AnalizOdev.AkilliCihaz;

import com.AnalizOdev.AkilliCihaz.MerkeziIslemBirimi.MIB;

import java.util.Random;

public class SicaklikAlgilama {
    private static SicaklikAlgilama instance;
    private MIB mib;
    private  Random random = new Random();
    private  static final int MAX=100;
    private  static final int MIN=-20;


    public void sicaklikOku() {
        int derece = random.nextInt(MAX-MIN)+MIN;
        mib.setSicaklik(derece);
    }

    public static SicaklikAlgilama getInstance(){

        if (instance == null){
            instance = new SicaklikAlgilama();
        }

        return instance;
    }
}
