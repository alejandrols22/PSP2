package ejercicio3contar;

public class Runnable3 {
    public static void main(String[] args) {
        for (int j = 0; j < 3; j++) {
            new Thread(new Hilo(), "Hilo " + (j + 1)).start();
        }
    }
}