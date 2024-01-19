package prog_serv_proc_clase_09_01_24;

import java.net.*;

public class PruebaInetAddress {
    public static void main(String[] args) {
        // Creo una variable dir que almacenará la dirección de la máquina local
        InetAddress dir;
        System.out.println("========================================");
        System.out.println("SALIDA PARA LOCALHOST: ");
        try {
            // Almaceno el nombre de mi máquina local en dir
            dir = InetAddress.getLocalHost();
            pruebaMetodos(dir); // Llama al método pruebaMetodos
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    private static void pruebaMetodos(InetAddress dir) {
        System.out.println("\nMetodo getLocalHost(): " + dir);
        System.out.println("\nMetodo getHostName(): " + dir.getHostName());
        System.out.println("\nMetodo getHostAddress(): " + dir.getHostAddress());
        System.out.println("\nMetodo getCanonicalHostName(): " + dir.getCanonicalHostName());
    }
}

