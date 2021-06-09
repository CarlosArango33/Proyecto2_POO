package Vuelos.src;

import java.io.IOException;

public class Avion extends Thread{

    private String type;
    private String size;
    private Boolean retraso;

    public Avion(String tipo, String tamanno, Boolean estado_retraso) {
        String type = tipo;
        String size = tamanno;
        Boolean retraso = estado_retraso;

    }

    public String getType(){
        return type;
    }

    public String getSize(){
        return size;
    }

    public Boolean getRetraso(){
        return retraso;
    }


}
