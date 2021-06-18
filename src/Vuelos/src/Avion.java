package Vuelos.src;

import java.io.IOException;

public class Avion{

    private String type;
    private String size;
    private Boolean retraso;
    //private String tag;  Puede servir para alguna descripcion espec[ifica del avion

    public Avion(String tipo, String tamanno, Boolean estado_retraso) {
        this.type = tipo;
        this.size = tamanno;
        this.retraso = estado_retraso;
        //String tag = desc;

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

    /*public String getTag(){
        return tag;
    } */

}
