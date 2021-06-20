public class Main {

    public static void main(String[] args) throws Exception {

        Hilo1 hiloA = new Hilo1();
        Hilo2 hiloB = new Hilo2();

        hiloA.start();
        hiloB.start();


    }
}
