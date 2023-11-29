package ejercicio1contar;

public class Runnable1 {
    public static void main(String[] args) {
        for (int j = 0; j < 3; j++) {
            Thread thread = new Thread(new Hilo(), "Hilo " + (j + 1));
            thread.start();
        }
    }
}