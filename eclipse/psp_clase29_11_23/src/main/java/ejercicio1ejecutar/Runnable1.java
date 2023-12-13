package ejercicio1ejecutar;


public class Runnable1 {
    public static void main(String[] args) {
        Hilo task = new Hilo();
        new Thread(task).start();
    }
}