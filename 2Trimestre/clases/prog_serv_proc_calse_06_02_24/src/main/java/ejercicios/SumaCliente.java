package ejercicios;

import java.io.*;
import java.net.*;

public class SumaCliente {

    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 6001;
        
        try (Socket socket = new Socket(host, puerto);
             DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
             DataInputStream entrada = new DataInputStream(socket.getInputStream());
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Conectado al servidor de suma.");
            System.out.print("Ingrese el primer número: ");
            double numero1 = Double.parseDouble(bufferedReader.readLine());
            System.out.print("Ingrese el segundo número: ");
            double numero2 = Double.parseDouble(bufferedReader.readLine());
            
            // Enviar los números al servidor
            salida.writeDouble(numero1);
            salida.writeDouble(numero2);
            
            // Recibir y mostrar el resultado de la suma
            double resultadoSuma = entrada.readDouble();
            System.out.println("El resultado de la suma es: " + resultadoSuma);
            
        } catch (IOException e) {
            System.err.println("Cliente: Error al conectar con el servidor: " + e.getMessage());
        }
    }
}
