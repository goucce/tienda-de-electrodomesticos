package com.goucce.models;



//HEREDACIÓN
//Esto es debido a que los
// constructores no se heredan entre jerarquías de clases.
// Por lo tanto la palabra super() siempre es la primera línea
// de un constructor e invoca al constructor de la clase superior
// que comparta el mismo tipo de parametrización.
//https://www.arquitecturajava.com/java-constructores-y-super/

public class Lavadoras extends Electrodomesticos {

    protected int carga=5;

    public Lavadoras() {
        super();
    }

    public Lavadoras(double precioBase, double peso) {
        super();
        this.precioBase = precioBase;
        this.peso = peso;
    }

    public Lavadoras(double precioBase, String coloR, char consumo, double peso, int carga) {
        this.precioBase = precioBase;
        this.coloR = checkColor(coloR);
        this.consumoEnergeticO = checkConsumo(consumo);
        this.peso = peso;
        this.carga = carga;
    }


    public int getload() {
        return carga;
    }

    public static double precioFinalLavadora (Lavadoras Electrodomesticos)
    {
        if (Electrodomesticos.carga > 30)
        {
            Electrodomesticos.precioBase += 50.00;
        }
        return Electrodomesticos.precioBase;
    }
}