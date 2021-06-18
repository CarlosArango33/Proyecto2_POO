import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import javax.swing.plaf.DimensionUIResource;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import netscape.javascript.JSObject;

import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

public class InterfazServidor extends JFrame implements Runnable{
    
    JButton boton1;
    JButton boton2;
    JButton boton3;
    
    JPanel panelBoton;

    JLabel etiquetaTexto;
    JPanel panelTexto;
    JPanel panelTexto2;
    JPanel panelTexto3;

    JTextArea areaTexto;

    int i = 1;

    public InterfazServidor(){
        super("Servidor");
        this.setPreferredSize(new DimensionUIResource(300, 300));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int height = pantalla.height;
        int width = pantalla.width;
        setSize(width/2, height/2);	
        setLocationRelativeTo(null);

        agregarComponentes();

        Thread hilo = new Thread(this);
        hilo.start();
        
        this.pack();
        this.setVisible(true);
    }

    private void agregarComponentes(){
        panelBoton = new JPanel();
        panelTexto = new JPanel();
        panelTexto2 = new JPanel();
        panelTexto3 = new JPanel();


        etiquetaTexto = new JLabel("Recibiendo el mensaje.");
        panelTexto.add(etiquetaTexto, BorderLayout.CENTER);

        panelBoton.setLayout(new GridLayout(10,2));

        boton1 = new JButton("Enviar");
        
        panelBoton.add(boton1);

        panelBoton.setLayout(new GridLayout(10,1));

        areaTexto = new JTextArea("     ");
        panelTexto2.add(areaTexto, BorderLayout.SOUTH);

        this.add(panelBoton, BorderLayout.LINE_END);
        this.add(panelTexto, BorderLayout.NORTH);
        this.add(panelTexto2, BorderLayout.CENTER);
        this.add(panelTexto3, BorderLayout.SOUTH);

    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        
        //System.out.println("Estoy escuchando.");

        try {
            
            ServerSocket servidor = new ServerSocket(9999);

            while(true){
                Socket miSocket = servidor.accept();
                DataInputStream flujoEntrada = new DataInputStream(miSocket.getInputStream());
                String mensaje = flujoEntrada.readUTF();
                JSONParser parser = new JSONParser();
                JSONObject objetin = (JSONObject)parser.parse(mensaje);
                System.out.println(objetin);
                areaTexto.append("\n" + mensaje);
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