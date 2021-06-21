package com.AnalizOdev.AkilliCihaz.MerkeziIslemBirimi;

import com.AnalizOdev.AkilliCihaz.Interfaces.Observable;
import com.AnalizOdev.AkilliCihaz.Interfaces.Observer;

import java.util.ArrayList;
import java.util.List;

public class MIB {
    private static MIB instance;

    private static int sicaklik = -10000;
    private boolean sogutucudurum;

    private MIB() {
    }

    public static MIB getInstance() {

        if (instance == null) {
            instance = new MIB();
        }

        return instance;
    }

    public static int getSicaklik() {
        return sicaklik;
    }

    public static void setSicaklik(int sicaklik) {
        MIB.sicaklik = sicaklik;
    }

    public void SogutucuKapat() {
        this.sogutucudurum = false;
    }

    public void SogutucuAc() {
        this.sogutucudurum = true;
    }

    public boolean SogutucuAlgila() {
        return this.sogutucudurum;
    }
}