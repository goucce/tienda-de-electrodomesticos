package com.goucce.models;

public class Televisiones extends Electrodomesticos {
    //Atributos
    int resolucion = 20;
    boolean TDT = false;

    //Constructores
    //1: Por defecto, unicamente heredamos lo del padre, gracias a super
    public Televisiones() {
        super();
    }

    //2: Precio y Peso, resto con super los de herencia
    public Televisiones(double precioBase, double peso) {
        super();
        this.precioBase = precioBase;
        this.peso = peso;
    }

    //3: Resolucion + TDT, resto con super los de herencia
    public Televisiones(double precioBase, String coloR, char consumo, double peso, int resolucion, boolean TDT) {
        super();
        this.precioBase = precioBase;
        this.coloR = checkColor(coloR);
        this.consumoEnergeticO = checkConsumo(consumo);
        this.peso = peso;
        this.resolucion = resolucion;
        this.TDT = TDT;
    }

    //Metodos

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
