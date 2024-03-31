package com.proiectfinal;

import java.util.Objects;

public class Produs {

    private String numeProdus;
    private double pretProdus;
    private int cantitateProdus;


    public void setPretProdus(double pretProdus) {
        this.pretProdus = pretProdus;
    }

    public double getPretProdus() {
        return pretProdus;
    }

    public void setNumeProdus(String numeProdus) {
        this.numeProdus = numeProdus;
    }

    public String getNumeProdus() {
        return numeProdus;
    }

    public void setCantitateProdus(int cantitateProdus) {
        this.cantitateProdus = cantitateProdus;
    }

    public int getCantitateProdus() {
        return cantitateProdus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produs produs = (Produs) o;
        return pretProdus == produs.pretProdus && cantitateProdus == produs.cantitateProdus && Objects.equals(numeProdus, produs.numeProdus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeProdus, pretProdus, cantitateProdus);
    }

    @Override
    public String toString() {
        return "Produs{" +
                "numeProdus='" + numeProdus + '\'' +
                ", pretProdus=" + pretProdus +
                ", cantitateProdus=" + cantitateProdus +
                '}';
    }
}

