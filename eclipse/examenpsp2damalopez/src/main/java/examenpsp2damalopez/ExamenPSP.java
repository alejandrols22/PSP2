package examenpsp2damalopez;

public class ExamenPSP {

    public static void main(String[] args) {
        // Crea los hilos con sus nombres y asigna tareas a ejecutar
        Thread hilo1 = new Thread(new Descarga("descarga 1", 1), "descarga 1");
        Thread hilo2 = new Thread(new Descarga("descarga 2", 2), "descarga 2");
        Thread hilo3 = new Thread(new Descarga("descarga 3", 3), "descarga 3");

        // Asigna prioridades a los hilos
        hilo1.setPriority(Thread.NORM_PRIORITY); // Prioridad normal para el hilo 1
        hilo2.setPriority(Thread.MIN_PRIORITY);   // Prioridad mínima para el hilo 2
        hilo3.setPriority(Thread.MAX_PRIORITY);   // Prioridad máxima para el hilo 3

        // Inicia los hilos, lo que provoca que se ejecute su método 'run'
        hilo1.start();
        hilo2.start();
        hilo3.start();

        // Bloquea el hilo principal hasta que los otros hilos hayan terminado
        try {
            hilo1.join();
            hilo2.join();
            hilo3.join();
        } catch (InterruptedException e) {
            e.printStackTrace(); // Imprime en consola si hay una interrupción
        }

        // Mensaje que se imprime una vez todos los hilos han terminado
        System.out.println("Las descargas han finalizado");
    }

    // Clase interna que implementa la interfaz Runnable
    static class Descarga implements Runnable {
        private final String nombre; // Nombre de la descarga
        private final int incremento; // Incremento del porcentaje de descarga

        // Constructor para inicializar el nombre y el incremento
        public Descarga(String nombre, int incremento) {
            this.nombre = nombre;
            this.incremento = incremento;
        }

        // Método que se ejecuta cuando el hilo comienza
        @Override
        public void run() {
            int porcentaje = 0; // Inicia el porcentaje de descarga en 0
            while (porcentaje < 100) {
                porcentaje += incremento; // Aumenta el porcentaje de descarga
                System.out.println(nombre + " progreso: " + porcentaje + "%");

                // Hace una pausa para simular el tiempo de descarga
                try {
                    Thread.sleep(100); 
                } catch (InterruptedException e) {
                    e.printStackTrace(); // Imprime en consola si hay una interrupción
                }
            }
            // Mensaje que se imprime una vez la descarga ha alcanzado el 100%
            System.out.println("La " + nombre + " se ha completado");
        }
    }
}
