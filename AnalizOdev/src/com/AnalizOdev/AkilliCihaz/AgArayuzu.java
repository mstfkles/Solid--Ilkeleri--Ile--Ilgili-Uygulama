package com.AnalizOdev.AkilliCihaz;

import com.AnalizOdev.AkilliCihaz.Interfaces.Observable;
import com.AnalizOdev.AkilliCihaz.Interfaces.Observer;
import com.AnalizOdev.AkilliCihaz.MerkeziIslemBirimi.MIB;

import java.util.ArrayList;
import java.util.List;

public class AgArayuzu implements Observable {
    private SicaklikAlgilama algilama=SicaklikAlgilama.getInstance();
    private MIB mib =MIB.getInstance();
    private List<Observer> observerList = new ArrayList<>();
    private boolean internetVarMi;
    public int sicaklikGör(){
        algilama.sicaklikOku();
        if(mib.getSicaklik()!=-10000){
            return mib.getSicaklik();
        }else{
            System.out.println("Sıcaklık Algılanamadı. Yeniden Deneyiniz.");
            return mib.getSicaklik();
        }
    }

    public boolean isInternetVarMi() {
        return internetVarMi;
    }

    public void setInternetVarMi(boolean internetVarMi) {
        this.internetVarMi = internetVarMi;
    }

    @Override
    public void observerEkle(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void ObserverSil(Observer observer) {
        observerList.remove(observer);
    }
    @Override
    public boolean SogutucuKapat() {
        if(mib.SogutucuAlgila()==true){
        mib.SogutucuKapat();
            return true;}
        else{ return false;}
    }

    @Override
    public boolean SogutucuAc() {
        if(mib.SogutucuAlgila()==false){
        mib.SogutucuAc();
        return true;
        }else{
            return true;
        }
    }
}
