package Controlador.src;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.*;

public class Servidor extends Thread{
    public String infoJason;

    public void getInfoJson(){
        System.out.println();
    }

    @Override
    public void run() {
        try {
            
            ServerSocket servidor = new ServerSocket(9999);
            Boolean correr = true;
            while(correr){
                Socket miSocket = servidor.accept();
                DataInputStream flujoEntrada = new DataInputStream(miSocket.getInputStream());
                String mensaje = flujoEntrada.readUTF();
                JSONParser parser = new JSONParser();
                JSONObject objetin = (JSONObject)parser.parse(mensaje);
                objetin.toString();
                System.out.println(objetin);

                System.out.println("Informacion recibida[Vuelos-Controlador]");
                miSocket.close();
                correr = false;

                //Se supone que si llega al final  del codigo sin ningun error es  porque recibi[o algo
              

            }
            

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        
    }
    
}
