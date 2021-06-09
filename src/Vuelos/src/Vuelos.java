package Vuelos.src;

import java.util.ArrayList;

public class Vuelos {

    public static void main(String[] args) throws Exception {
         /*
         La idea es enviar cada cierto tiempo un avion al servidor
         entonces enviar ya sea en formato String, Json o clase el vuelo con
         sus caracteristicas para procesarr en controlador
         */
        ArrayList lista = new ArrayList();

        Avion AvionPriv = new Avion("privado", "peque", false);
        Avion AvionPasajeros = new Avion("pasajeros", "mediano", true);
        Avion AvionCarga = new Avion("carga", "mediano", false);

        lista.add(AvionPriv);
        lista.add(AvionCarga);
        lista.add(AvionPasajeros);


    }

    //Agregar Hilo
    //Mandar lista al  servidor para que mande los archivos/clases
}