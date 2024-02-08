package ejercicios;

import java.io.*;
import java.net.*;

public class ConservadorMonedasCliente {

    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 6000;
        
        try (Socket socket = new Socket(host, puerto);
             DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
             DataInputStream entrada = new DataInputStream(socket.getInputStream());
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Conectado al servidor de conversión de monedas.");
            System.out.print("Ingrese la cantidad en Euros para convertir: ");
            double cantidadEuros = Double.parseDouble(bufferedReader.readLine());
            
            // Enviar la cantidad de euros al servidor
            salida.writeDouble(cantidadEuros);
            
            // Recibir y mostrar los resultados de la conversión
            String resultadoConversion = entrada.readUTF();
            System.out.println(resultadoConversion);
            
        } catch (IOException e) {
            System.err.println("Cliente: Error al conectar con el servidor: " + e.getMessage());
        }
    }
}
