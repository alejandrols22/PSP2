package ejercicios;

import java.io.*;
import java.net.*;

public class CalculadoraCliente {

    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 6002;
        
        try (Socket socket = new Socket(host, puerto);
             DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
             DataInputStream entrada = new DataInputStream(socket.getInputStream());
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Conectado al servidor de cálculo.");
            System.out.print("Ingrese la operación (suma, resta, multiplicacion, division): ");
            String operacion = bufferedReader.readLine();
            System.out.print("Ingrese el primer número: ");
            double numero1 = Double.parseDouble(bufferedReader.readLine());
            System.out.print("Ingrese el segundo número: ");
            double numero2 = Double.parseDouble(bufferedReader.readLine());
            
            // Enviar la operación y los números al servidor
            salida.writeUTF(operacion);
            salida.writeDouble(numero1);
            salida.writeDouble(numero2);
            
            // Recibir y mostrar el resultado del cálculo
            double resultado = entrada.readDouble();
            System.out.println("El resultado de la " + operacion + " es: " + resultado);
            
        } catch (IOException e) {
            System.err.println("Cliente: Error al conectar con el servidor: " + e.getMessage());
        }
    }
}
