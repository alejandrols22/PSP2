package ejercicio1ejecutar;

public class Hilo implements Runnable {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hola, soy un hilo ejecutándose con Runnable " + (i + 1));
            try {
                Thread.sleep((long)(Math.random() * 100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}