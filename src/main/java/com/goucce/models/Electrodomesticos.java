package com.goucce.models;

import java.util.Arrays;
import java.util.List;

public class Electrodomesticos {

    protected double precioBase = 200;
    protected  color coloR = color.blanco;
    protected  consumoEnergetico consumoEnergeticO = consumoEnergetico.B;
    protected double peso = 5;


    /*Un enumerado (o Enum) es una clase "especial" (tanto en Java como en otros lenguajes) que
    limitan la creación de objetos  a los especificados explícitamente en la implementación de
    la clase. La única limitación que tienen los enumerados respecto a una clase normal es que si
    tiene constructor, este debe de ser privado para que no se puedan crear nuevos objetos.
    https://jarroba.com/enum-enumerados-en-java-con-ejemplos/
    */

    //En este caso las variables tienen que ser protected en vez de privade porque estamos
    //en una superclase y tiene que poder heredarse


    public enum color {
        blanco, metal, rojo, verde, azul;
    }

    public enum consumoEnergetico {
        A,B,C,D,E,F;

    }

    //Métodos getter and setter (El Generate)

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public color getColoR() {
        return coloR;
    }

    public void setColoR(color coloR) {
        this.coloR = coloR;
    }

    public consumoEnergetico getConsumoEnergeticO() {
        return consumoEnergeticO;
    }

    public void setConsumoEnergeticO(consumoEnergetico consumoEnergeticO) {
        this.consumoEnergeticO = consumoEnergeticO;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }


    //Constructores 1.Por defecto, 2.Precio y Peso, resto por defecto, 3.Todos los atributos

    //1
    public Electrodomesticos(){

    }

    //2
    public Electrodomesticos(double precioBase, double peso){
        this.precioBase=precioBase;
        this.peso=peso;

    }

    //3
    public Electrodomesticos(double precioBase, double peso, String color, char consumoEnergetico ){
        this.precioBase = precioBase;
        this.coloR = checkColor(color);;
        this.consumoEnergeticO = checkConsumo(consumoEnergetico);;
        this.peso = peso;
    }

    //Métodos

    //Comprobadores
    //Checkeo de la calificación del consumo energetico,
    public static consumoEnergetico checkConsumo(char letra) {
        List<String> valores = Arrays.asList("A", "B", "C", "D", "E","F");
        if (!(valores).contains(String.valueOf(letra))) {
            return consumoEnergetico.B;
        }
        return consumoEnergetico.valueOf(Character.toString(letra));
    }

    //Checkeo de los colroes
    public static color checkColor(String coloR) {
        List<String> colores = Arrays.asList("blanco", "azul", "verde", "rojo", "metal");
        if (!(colores.contains(coloR))) {
            return color.blanco;
        }
        return color.valueOf(coloR);
    }

    //Precio final
    public static double precioFinal(Electrodomesticos electrodomesticos) {
        //Dependencia por precio de la clasificacion
        switch (electrodomesticos.getConsumoEnergeticO()) {
            case A:
                electrodomesticos.precioBase += 100.00;
                break;
            case B:
                electrodomesticos.precioBase += 85.00;
                break;
            case C:
                electrodomesticos.precioBase += 60.00;
                break;
            case D:
                electrodomesticos.precioBase += 50.00;
                break;
            case E:
                electrodomesticos.precioBase += 30.00;
                break;
            case F:
                electrodomesticos.precioBase += 10.00;
                break;
            default:
                break;
        }

        //Dependencia por peso
        if (0 <= electrodomesticos.peso && electrodomesticos.peso <= 19) {
            electrodomesticos.precioBase += 10.00;
        }
        if (20 <= electrodomesticos.peso && electrodomesticos.peso <= 49) {
            electrodomesticos.precioBase += 50.00;
        }
        if (50 <= electrodomesticos.peso && electrodomesticos.peso <= 79) {
            electrodomesticos.precioBase += 80.00;
        }
        if (electrodomesticos.peso >= 80) {
            electrodomesticos.precioBase += 100.00;
        }


        //Adjuntar Lavadora
        if (electrodomesticos instanceof Lavadoras)
            electrodomesticos.precioBase = Lavadoras.precioFinalLavadora((Lavadoras) electrodomesticos);

        //Adjuntar Television
        if (electrodomesticos instanceof Televisiones)
            electrodomesticos.precioBase = Televisiones.precioFinalTelevision((Televisiones) electrodomesticos);

        return electrodomesticos.precioBase;
    }

}
