package Vuelos.src;

import java.util.ArrayList;

public class Vuelos extends Thread{

    public static void main(String[] args) throws Exception {
         /*
         La idea es enviar cada cierto tiempo un avion al servidor
         entonces enviar ya sea en formato String, Json o clase el vuelo con
         sus caracteristicas para procesarr en controlador
         */
        Cliente cl = new Cliente();
        cl.start();


    }

    //Agregar Hilo
    //Mandar lista al  servidor para que mande los archivos/clases
}