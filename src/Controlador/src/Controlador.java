package Controlador.src;

import java.net.*;
import java.io.*;

public class Controlador implements Runnable{

    public boolean running;

    Controlador(){
        Thread hilo = new Thread(this);
        hilo.start();
        running = true;
    }
    

    @Override
    public void run() {
        // TODO Auto-generated method stub

       /* try {
            
            ServerSocket servidor = new ServerSocket(9999);

            while(running){
                Socket miSocket = servidor.accept();
                DataInputStream flujoEntrada = new DataInputStream(miSocket.getInputStream());
                String mensaje = flujoEntrada.readUTF();
                //areaTexto.append("\n" + mensaje);
                miSocket.close();
            }
            

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } */
        
    }

    
}
