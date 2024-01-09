package prog_serv_proc_clase_01_09_24;

import java.net.*;

public class PruebaInetAddress2 {
    public static void main(String[] args) {
        // Dirección local
        System.out.println("========================================");
        System.out.println("SALIDA PARA LOCALHOST: ");
        try {
            InetAddress dirLocal = InetAddress.getLocalHost();
            pruebaMetodos(dirLocal);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        // Dirección remota
        System.out.println("========================================");
        System.out.println("SALIDA PARA WWW.CENCEMALAGA.ES: ");
        try {
            InetAddress dirRemota = InetAddress.getByName("www.cenecmalaga.es");
            pruebaMetodos(dirRemota);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    private static void pruebaMetodos(InetAddress dir) {
        System.out.println("Metodo getLocalHost(): " + dir);
        System.out.println("Metodo getHostName(): " + dir.getHostName());
        System.out.println("Metodo getHostAddress(): " + dir.getHostAddress());
        System.out.println("Metodo getCanonicalHostName(): " + dir.getCanonicalHostName());
    }
}

