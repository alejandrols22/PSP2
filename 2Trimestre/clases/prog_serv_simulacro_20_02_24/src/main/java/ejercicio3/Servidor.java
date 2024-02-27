package ejercicio3;

import java.io.*;
import java.net.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;

public class Servidor {
    private static final int PUERTO = 6200;
    private static final String CONTRASEÑA = "cenec"; // Contraseña original
    private static String CONTRASEÑA_ALMACENADA; // Contraseña almacenada encriptada

    static {
        try {
            CONTRASEÑA_ALMACENADA = encriptarSHA256(CONTRASEÑA);
            System.out.println("Contraseña almacenada (encriptada): " + CONTRASEÑA_ALMACENADA);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para convertir de byte a hexadecimal
    static String hexadecimal(byte[] resumen) {
        StringBuilder hex = new StringBuilder();
        for (byte b : resumen) {
            String h = Integer.toHexString(255 & b);
            if (h.length() == 1) hex.append("0");
            hex.append(h);
        }
        return hex.toString().toUpperCase();
    }

    // Método para encriptar la contraseña en SHA-256
    static String encriptarSHA256(String contraseña) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(contraseña.getBytes(StandardCharsets.UTF_8));
        return hexadecimal(hash);
    }

    public static void main(String[] args) {
        System.out.println("Servidor iniciando...");
        try (ServerSocket servidor = new ServerSocket(PUERTO)) {
            System.out.println("Servidor esperando en el puerto " + PUERTO);

            try (Socket socketCliente = servidor.accept();
                 ObjectOutputStream salida = new ObjectOutputStream(socketCliente.getOutputStream());
                 ObjectInputStream entrada = new ObjectInputStream(socketCliente.getInputStream())) {

                System.out.println("Cliente conectado.");

                // Solicitar contraseña
                salida.writeObject("Ingrese la contraseña: ");
                String contraseñaCliente = (String) entrada.readObject();
                System.out.println("Contraseña recibida: " + contraseñaCliente);

                // Encriptar y comparar contraseña
                String contraseñaEncriptadaCliente = encriptarSHA256(contraseñaCliente);
                System.out.println("Contraseña encriptada recibida: " + contraseñaEncriptadaCliente);

                if (CONTRASEÑA_ALMACENADA.equals(contraseñaEncriptadaCliente)) {
                    System.out.println("Acceso permitido.");
                    salida.writeObject("Acceso permitido");

                    // Recibir objeto Pikachu del cliente
                    Pikachu pikachu = (Pikachu) entrada.readObject();
                    System.out.println("Objeto Pikachu recibido con nombre: " + pikachu.getNombre());

                    // Preguntar si desea evolucionar a Pikachu
                    salida.writeObject("¿Quieres usar piedratrueno en tu " + pikachu.getNombre() + "? (Y/N)");
                    String respuesta = (String) entrada.readObject();
                    if ("Y".equalsIgnoreCase(respuesta)) {
                        pikachu.setNombre("Raichu");
                        salida.writeObject("Felicidades, tu Pikachu ha evolucionado a Raichu");
                        salida.writeObject(pikachu); // Enviar Pikachu evolucionado de vuelta al cliente
                    } else {
                        salida.writeObject("Qué lástima.");
                    }
                } else {
                    System.out.println("Acceso denegado.");
                    salida.writeObject("Acceso denegado");
                }
            } catch (ClassNotFoundException e) {
                System.out.println("Error al leer el objeto: " + e.getMessage());
            }
        } catch (IOException e) {
            System.out.println("Error al iniciar el servidor: " + e.getMessage());
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error con el algoritmo de encriptación: " + e.getMessage());
        }
    }
}
