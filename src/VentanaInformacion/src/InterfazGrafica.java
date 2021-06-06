package VentanaInformacion.src;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import javax.swing.plaf.DimensionUIResource;
import java.awt.event.*;

public class InterfazGrafica extends JFrame implements ActionListener{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    JButton boton1;
    
    JPanel panelBoton;

    JLabel etiquetaTexto;
    JPanel panelTexto;
    JPanel panelTexto2;
    JPanel panelTexto3;

    JTextArea areaTexto;

    int i = 1;

    public InterfazGrafica(){
        super("Ventana De Informacion");
        this.setPreferredSize(new DimensionUIResource(700, 500));
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


        etiquetaTexto = new JLabel("Los Vuelos son: ");
        panelTexto.add(etiquetaTexto, BorderLayout.CENTER);

        panelBoton.setLayout(new GridLayout(10,2));

        boton1 = new JButton("Mostrar");
        boton1.addActionListener(this);
        panelBoton.add(boton1);

        panelBoton.setLayout(new GridLayout(10,1));

        areaTexto = new JTextArea(" ");
        panelTexto2.add(areaTexto, BorderLayout.SOUTH);

        this.add(panelBoton, BorderLayout.LINE_END);
        this.add(panelTexto, BorderLayout.NORTH);
        this.add(panelTexto2, BorderLayout.CENTER);
        this.add(panelTexto3, BorderLayout.SOUTH);

    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource().equals(boton1)){
            areaTexto.setText("Vuelos :)");
        }

    }
}