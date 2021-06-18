package Sockets2.servidor.src;

public class App {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");
        Servidor server = new Servidor();
        server.run();
    }
}
