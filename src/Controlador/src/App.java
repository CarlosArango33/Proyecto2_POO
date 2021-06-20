package Controlador.src;

public class App {
    public static void main(String[] args) throws Exception {
        //Controlador controlador = new Controlador();
        Servidor server = new Servidor();
        server.start();
    }
}
