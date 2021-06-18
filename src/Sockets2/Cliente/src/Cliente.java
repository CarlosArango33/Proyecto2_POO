package Sockets2.Cliente.src;

import org.json.simple.JSONObject;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

public class Cliente {
    void enviar(){
        try {
            JSONObject json = new JSONObject();
            json.put("Tipo", "Conexion");
            json.put("Color", "Verde");

            Socket miSocket = new Socket("localhost",9999);

            DataOutputStream flujoSalida = new DataOutputStream(miSocket.getOutputStream());

            //flujoSalida.writeUTF(areaTexto.getText());
            flujoSalida.writeUTF(json.toString());

            flujoSalida.close();

        } catch (UnknownHostException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
            System.out.println("Hubo un error en la conexion.");

        }
    }
}
