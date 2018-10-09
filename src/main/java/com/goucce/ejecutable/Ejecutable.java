package com.goucce.ejecutable;

//importar los modelos de electrodomesticos

import com.goucce.models.Electrodomesticos;
import com.goucce.models.Lavadoras;
import com.goucce.models.Televisiones;


public class Ejecutable {


    //Array de electrodomesticos 10 posiciones, array de una clase
    public static Electrodomesticos[] electrodomesticosArray(){
        Electrodomesticos[] arrayDeElectrodomesticos = new Electrodomesticos[10];
        return arrayDeElectrodomesticos;
    }

    //Asignacion de el array de electrodomesticos
    public static Electrodomesticos[] asignacionElectrodomesticos(Electrodomesticos[] arrayElectrodomesticos){

    arrayElectrodomesticos[0] = new Electrodomesticos(400.0, 9.0,"blanco",'A');
    arrayElectrodomesticos[1] = new Electrodomesticos(40.0, 60.0,"rojo",'C');
    arrayElectrodomesticos[2] = new Electrodomesticos();
    arrayElectrodomesticos[3] = new Lavadoras();
    arrayElectrodomesticos[4] = new Televisiones();
    arrayElectrodomesticos[5] = new Televisiones(500.0, 4.0);
    arrayElectrodomesticos[6] = new Televisiones(600.0, "blanco", 'B',9.0,40,false);
    arrayElectrodomesticos[7] = new Electrodomesticos(100.0, 50.0,"blanco",'B');
    arrayElectrodomesticos[8] = new Lavadoras(500.0,43.0);
    arrayElectrodomesticos[9] = new Lavadoras(500.0,"metal",'B',40.0,5);

    return arrayElectrodomesticos;
    }

    //Mostrar el precio de todoas las clases.
    //Tendremos que recorrer el array y saber a donde pereteneces con el instanceof

    //Curiosidades Java: Operador instanceof. El objetivo del operador instanceof es conocer si un
    // objeto es de un tipo determinado. Por tipo nos referimos a clase o interfaz (interface),
    // es decir si el objeto pasaría el test ES-UN para esa clase o ese interfaz, especificado
    // a la derecha del operador.

    public static double[] precioElectrodomesticos(Electrodomesticos[] arrayElectrodomesticos){

        double precioElectrodometicos = 0.0;
        double precioLavadoras = 0;
        double precioTelevisiones = 0;

        //Aqui crear un array de los precios
        double[] precios = new double[3];

        //Recorrer el array de los diferentes electrodomesticos
        for (int i=0; i<10; i++)
        {
            if (arrayElectrodomesticos[i] instanceof Televisiones){
                //Si pertenece a televisiones
                precioTelevisiones += Electrodomesticos.precioFinal(arrayElectrodomesticos[i]);
            }

            if (arrayElectrodomesticos[i] instanceof Lavadoras){
                //si pertence a Lavadoras
                precioLavadoras += Electrodomesticos.precioFinal(arrayElectrodomesticos[i]);
            }

            if (!(arrayElectrodomesticos[i] instanceof Televisiones) && !(arrayElectrodomesticos[i] instanceof Lavadoras)){
                //Si es un electrodomestico normal.
                precioElectrodometicos += Electrodomesticos.precioFinal(arrayElectrodomesticos[i]);
            }
        }

        //Posiciones donde se guarda el precio acumulado de segun que electrodomestico
        precios[0] = precioElectrodometicos;
        precios[1] = precioLavadoras;
        precios[2] = precioTelevisiones;

        //Devolvemos todos los precios(Array)
        return precios;




    }








}
