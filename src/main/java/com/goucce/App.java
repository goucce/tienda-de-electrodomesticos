package com.goucce;

//Importamos las clases que vamos a ver en la aplicación.

import com.goucce.models.Electrodomesticos;
import com.goucce.ejecutable.Ejecutable;


public class App{

    //Prueba testeable comprobar que todo_ ha ido bien
    public static void main( String[] args ){
        //Movemos el array de electrodomesticos
        Electrodomesticos[] electrodomesticos = Ejecutable.electrodomesticosArray();
        //Haciendo las comprobaciones
        electrodomesticos = Ejecutable.asignacionElectrodomesticos(electrodomesticos);
        //Seleccion del array precio
        double precioFinal[] = Ejecutable.precioElectrodomesticos(electrodomesticos);
        System.out.println();
        System.out.println("Los diferentes gastos se podrian dividir en estas categorias:");
        System.out.println();
        System.out.println("Televisores, con un precio total de: " + precioFinal[2]);
        System.out.println("Lavadoras:  con un precio total de:  " + precioFinal[1]);
        System.out.println("Otro tipo de electrodomésticos, con un precio total de: " + precioFinal[0]);
        System.out.println();
        System.out.println("Si sumamos los diferentes costes: "+precioFinal[0]+" + "+precioFinal[1] + " + " +precioFinal[2] + " tenemos como resultado total: " + (precioFinal[0]+precioFinal[1]+precioFinal[2]) );
    }
}
