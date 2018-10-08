package com.goucce.models;

public class Televisiones extends Electrodomesticos {
    int resolucion = 20;
    boolean TDT = false;

    public Televisiones() {
        super();
    }

    public Televisiones(double precioBase, int peso) {
        super();
        this.precioBase = precioBase;
        this.peso = peso;
    }

    public Televisiones(double precioBase, String coloR, char consumo, int peso, int resolucion, boolean TDT) {
        super();
        this.precioBase = precioBase;
        this.coloR = checkColor(coloR);
        this.consumoEnergeticO = checkConsumo(consumo);
        this.peso = peso;
        this.resolucion = resolucion;
        this.TDT = TDT;
    }

    public int getResolucion()    {
        return resolucion;
    }

    public boolean isTDT() {
        return TDT;
    }

    public static double precioFinalTelevision (Televisiones Electrodomesticos)
    {
        if (Electrodomesticos.TDT)
            Electrodomesticos.precioBase += 50.00;

        if (Electrodomesticos.resolucion > 40)
            Electrodomesticos.precioBase *= 1.30;

        return Electrodomesticos.precioBase;
    }
}
