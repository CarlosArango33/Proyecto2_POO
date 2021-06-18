package Sockets2.servidor.src;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.*;

public class Servidor implements Runnable{

    @Override
    public void run() {
        try {
            
            ServerSocket servidor = new ServerSocket(9999);

            while(true){
                Socket miSocket = servidor.accept();
                DataInputStream flujoEntrada = new DataInputStream(miSocket.getInputStream());
                String mensaje = flujoEntrada.readUTF();
                JSONParser parser = new JSONParser();
                JSONObject objetin = (JSONObject)parser.parse(mensaje);
                System.out.println(objetin);
                //reaTexto.append("\n" + mensaje);
                miSocket.close();
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
