package ejercicios;

import java.io.*;
import java.net.*;

public class SumaServidor {

    public static void main(String[] args) throws IOException {
        int puerto = 6001;
        ServerSocket servidor = new ServerSocket(puerto);
        System.out.println("Servidor de suma iniciado en el puerto " + puerto);

        while (true) {
            try (Socket clienteConectado = servidor.accept();
                 DataInputStream entrada = new DataInputStream(clienteConectado.getInputStream());
                 DataOutputStream salida = new DataOutputStream(clienteConectado.getOutputStream())) {

                // Leer los dos números enviados por el cliente
                double numero1 = entrada.readDouble();
                double numero2 = entrada.readDouble();

                // Realizar la suma
                double suma = numero1 + numero2;

                // Enviar el resultado de vuelta al cliente
                salida.writeDouble(suma);
                
                System.out.println("Suma realizada para " + clienteConectado.getInetAddress());
            } catch (IOException e) {
                System.err.println("Error al manejar la conexión del cliente: " + e.getMessage());
            }
        }
    }
}
