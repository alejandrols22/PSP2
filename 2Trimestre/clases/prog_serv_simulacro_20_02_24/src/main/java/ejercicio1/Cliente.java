package ejercicio1;

import java.io.*;
import java.net.*;

public class Cliente {
    public static void main(String[] args) {
        final String HOST = "localhost";
        final int PUERTO = 6400;

        try (Socket socket = new Socket(HOST, PUERTO);
             PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println(entrada.readLine()); // Mensaje del servidor pidiendo la contraseña
            System.out.print("Ingrese la contraseña: ");
            String contraseña = teclado.readLine(); // Leer contraseña del teclado

            salida.println(contraseña); // Enviar contraseña al servidor

            // Esperar respuesta del servidor
            System.out.println(entrada.readLine());

        } catch (IOException e) {
            System.out.println("Error al conectar con el servidor: " + e.getMessage());
        }
    }
}


