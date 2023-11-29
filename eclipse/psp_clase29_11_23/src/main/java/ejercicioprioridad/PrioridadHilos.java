package ejercicioprioridad;

public class PrioridadHilos extends Thread {
    private int contador = 0;

    public PrioridadHilos(String nombre) {
        super(nombre);
    }

    @Override
    public void run() {
        long tiempoFin = System.currentTimeMillis() + 3000; // Ejecutar por 3 segundos
        while (System.currentTimeMillis() < tiempoFin) {
            contador++;
        }
        System.out.println(getName() + " se ejecutó " + contador + " veces.");
    }

    public static void main(String[] args) throws InterruptedException {
        PrioridadHilos hilo1 = new PrioridadHilos("Hilo con prioridad máxima");
        PrioridadHilos hilo2 = new PrioridadHilos("Hilo con prioridad media");
        PrioridadHilos hilo3 = new PrioridadHilos("Hilo con prioridad mínima");

        hilo1.setPriority(Thread.MAX_PRIORITY); // Prioridad 10
        hilo2.setPriority(Thread.NORM_PRIORITY); // Prioridad 5
        hilo3.setPriority(Thread.MIN_PRIORITY); // Prioridad 1

        hilo1.start();
        hilo2.start();
        hilo3.start();

        hilo1.join(); // Esperar a que termine hilo1
        hilo2.join(); // Esperar a que termine hilo2
        hilo3.join(); // Esperar a que termine hilo3

        System.out.println("Todos los hilos han terminado de ejecutarse.");
    }
}
