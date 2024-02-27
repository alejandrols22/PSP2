package ejercicio2;

import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) {
        final int PUERTO = 61000;

        try (ServerSocket servidor = new ServerSocket(PUERTO)) {
            System.out.println("Servidor esperando conexiones en el puerto " + PUERTO);

            try (Socket socketCliente = servidor.accept();
                 ObjectOutputStream salida = new ObjectOutputStream(socketCliente.getOutputStream());
                 ObjectInputStream entrada = new ObjectInputStream(socketCliente.getInputStream())) {

                System.out.println("Cliente conectado.");

                Pikachu pikachu = (Pikachu) entrada.readObject();
                System.out.println("Objeto Pikachu recibido con nombre: " + pikachu.getNombre());

                salida.writeObject("¿Quieres usar piedratrueno en tu " + pikachu.getNombre() + "? (Y/N)");
                salida.flush();

                String respuesta = (String) entrada.readObject();
                if ("Y".equalsIgnoreCase(respuesta)) {
                    pikachu.setNombre("Raichu");
                    salida.writeObject("Felicidades, tu Pikachu ha evolucionado a Raichu");
                    salida.writeObject(pikachu);
                    salida.flush();
                } else {
                    salida.writeObject("Qué lástima.");
                    salida.flush();
                }
            } catch (ClassNotFoundException e) {
                System.out.println("Error al leer el objeto Pikachu: " + e.getMessage());
            }
        } catch (IOException e) {
            System.out.println("Error al iniciar el servidor: " + e.getMessage());
        }
    }
}


