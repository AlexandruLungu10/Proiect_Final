package com.proiectfinal;

import java.util.List;

public interface GestionareProduse {
    void afisareProduse(List<Produs> listaProduse);
    void updateFile(List<Produs> listaProduse);

    List<Produs> adaugaProdus(List<Produs> listaProduse);

    List<Produs> stergeProdus(List<Produs> listaProduse);

    List<Produs> modificaPret(List<Produs> listaProduse);

    List<Produs> modificaCantitate(List<Produs> listaProduse);
}

