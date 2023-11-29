package ejercicio2ejecutar;

public class Runnable2 {
    public static void main(String[] args) {
        Hilo task = new Hilo();
        Thread thread = new Thread(task); 
        thread.start();
    }
}