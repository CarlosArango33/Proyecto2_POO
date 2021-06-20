package Vuelos.src;

import org.json.simple.JSONObject;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.List;



public class Cliente extends Thread{
    //private ArrayList lista_aviones= new ArrayList();
    //Avion lista_aviones[] = new Avion[3];
    List<Avion> lista_aviones = new ArrayList<Avion>();


    private Avion AvionPriv = new Avion("privado", "peque", false);
    private Avion AvionPasajeros = new Avion("pasajeros", "mediano", true);
    private Avion AvionCarga = new Avion("carga", "mediano", false);

    public Cliente(){
        lista_aviones.add(AvionPriv);
        lista_aviones.add(AvionCarga);
        lista_aviones.add(AvionPasajeros);
    }
    void enviar(String tipo, String size, Boolean retraso){
        try {
            JSONObject json = new JSONObject();
            json.put("Tipo", tipo);
            json.put("Tamanno", size);
            json.put("Retraso", retraso);


            Socket miSocket = new Socket("localhost",9999);

            DataOutputStream flujoSalida = new DataOutputStream(miSocket.getOutputStream());

            //flujoSalida.writeUTF(areaTexto.getText());
            flujoSalida.writeUTF(json.toString());

            flujoSalida.close();

        } catch (UnknownHostException e1) {
            e1.printStackTrace();
            System.out.println("[Vuelos.Cliente] Error conectando");
        } catch (IOException e1) {
            e1.printStackTrace();
            System.out.println("[Vuelos.Clientes ]Hubo un error en la conexion.");

        }
    }

    @Override
    public void run(){
        int contador = 0;
        while (contador != lista_aviones.size()){
            System.out.println(lista_aviones.get(contador).getType());
            enviar(lista_aviones.get(contador).getType(), lista_aviones.get(contador).getSize(), lista_aviones.get(contador).getRetraso());
            try {
                Cliente.sleep(15000);
            }
            catch (InterruptedException e){
                System.out.println("Problema en Cliente[Try]");
            }

        }
    }
}