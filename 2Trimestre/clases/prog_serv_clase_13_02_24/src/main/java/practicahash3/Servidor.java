package practicahash3;


public class Servidor {

    public static void recibirMensaje(String mensaje, String hashEnviado) {
        System.out.println("Servidor: Mensaje recibido del cliente.");
        String hashCalculado = Cliente.encriptarSHA256(mensaje);
        System.out.println("Servidor: El hash SHA-256 del mensaje recibido es: " + hashCalculado);
        
        if (hashCalculado.equalsIgnoreCase(hashEnviado)) {
            System.out.println("Servidor: Los hash coinciden. Mensaje recibido.");
        } else {
            System.out.println("Servidor: Los hash no coinciden. El mensaje ha sido interceptado.");
        }
    }
}
