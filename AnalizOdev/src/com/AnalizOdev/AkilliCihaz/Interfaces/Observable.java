package com.AnalizOdev.AkilliCihaz.Interfaces;

public interface Observable {
    void observerEkle(Observer observer);
    void ObserverSil(Observer observer);
    boolean SogutucuKapat();
    boolean SogutucuAc();

}
