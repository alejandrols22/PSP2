package ejercicio2contar;

public class Runnable2 {
    public static void main(String[] args) {
        for (int j = 0; j < 3; j++) {
            Hilo task = new Hilo();
            Thread thread = new Thread(task, "Hilo " + (j + 1));
            thread.start();
        }
    }
}