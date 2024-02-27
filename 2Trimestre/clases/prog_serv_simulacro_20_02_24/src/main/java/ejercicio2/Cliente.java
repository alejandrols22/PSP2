package ejercicio2;

import java.io.*;
import java.net.*;

public class Cliente {
    public static void main(String[] args) {
        final String HOST = "localhost";
        final int PUERTO = 61000;

        try (Socket socket = new Socket(HOST, PUERTO);
             ObjectOutputStream salida = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());
             BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in))) {

            Pikachu pikachu = new Pikachu();
            salida.writeObject(pikachu);
            salida.flush();
            System.out.println("Objeto Pikachu enviado.");

            String mensajeServidor = (String) entrada.readObject();
            System.out.println(mensajeServidor);

            String respuesta = teclado.readLine();
            salida.writeObject(respuesta);
            salida.flush();

            mensajeServidor = (String) entrada.readObject();
            System.out.println(mensajeServidor);

            if ("Y".equalsIgnoreCase(respuesta)) {
                Pikachu pikachuEvolucionado = (Pikachu) entrada.readObject();
                System.out.println("Ahora tu Pikachu es: " + pikachuEvolucionado.getNombre());
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error en el cliente: " + e.getMessage());
        }
    }
}

