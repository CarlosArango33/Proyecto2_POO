package PracticaSocket.ClienteJson.src;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import javax.swing.plaf.DimensionUIResource;

import org.json.simple.JSONObject;

import java.awt.event.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

public class InterfazCliente extends JFrame implements ActionListener{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
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

    public InterfazCliente(){
        super("Cliente");
        this.setPreferredSize(new DimensionUIResource(300, 300));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int height = pantalla.height;
        int width = pantalla.width;
        setSize(width/2, height/2);	
        setLocationRelativeTo(null);

        agregarComponentes();
        
        this.pack();
        this.setVisible(true);
    }

    private void agregarComponentes(){
        panelBoton = new JPanel();
        panelTexto = new JPanel();
        panelTexto2 = new JPanel();
        panelTexto3 = new JPanel();


        etiquetaTexto = new JLabel("Ingrese el mensaje.");
        panelTexto.add(etiquetaTexto, BorderLayout.CENTER);

        panelBoton.setLayout(new GridLayout(10,2));

        boton1 = new JButton("Enviar");
        boton1.addActionListener(this);
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
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource().equals(boton1)){

            try {
                JSONObject json = new JSONObject();
                json.put("Tipo", "Conexion");

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
            
            //System.out.println("Presionado");
        }
    }
}