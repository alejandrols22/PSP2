package ejercicio3;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    private static final String HOST = "localhost";
    private static final int PUERTO = 6200;

    public static void main(String[] args) {
        try (Socket socket = new Socket(HOST, PUERTO);
             ObjectOutputStream salida = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());
             Scanner scanner = new Scanner(System.in)) {

            // Recibir mensaje del servidor y solicitar contraseña
            String mensajeDelServidor = (String) entrada.readObject();
            System.out.println(mensajeDelServidor);

            // Enviar contraseña al servidor
            System.out.print("Contraseña: ");
            String contraseña = scanner.nextLine();
            salida.writeObject(contraseña);

            // Recibir respuesta del servidor sobre la contraseña
            mensajeDelServidor = (String) entrada.readObject();
            System.out.println(mensajeDelServidor);

            if ("Acceso permitido".equals(mensajeDelServidor)) {
                // Crear y enviar objeto Pikachu al servidor
                Pikachu pikachu = new Pikachu();
                salida.writeObject(pikachu);
                System.out.println("Objeto Pikachu enviado.");

                // Recibir pregunta del servidor sobre la evolución de Pikachu
                mensajeDelServidor = (String) entrada.readObject();
                System.out.println(mensajeDelServidor);

                // Enviar respuesta sobre la evolución de Pikachu
                String respuestaEvolucion = scanner.nextLine();
                salida.writeObject(respuestaEvolucion);

                // Recibir mensaje final del servidor
                mensajeDelServidor = (String) entrada.readObject();
                System.out.println(mensajeDelServidor);

                if ("Felicidades, tu Pikachu ha evolucionado a Raichu".equals(mensajeDelServidor)) {
                    // Recibir Pikachu evolucionado de vuelta
                    Pikachu pikachuEvolucionado = (Pikachu) entrada.readObject();
                    System.out.println("Ahora tu Pikachu es: " + pikachuEvolucionado.getNombre());
                }
            } else {
                System.out.println("El acceso ha sido denegado. No se puede continuar con el proceso.");
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error en el cliente: " + e.getMessage());
        }
    }
}

