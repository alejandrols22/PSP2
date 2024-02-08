package ejercicios;

import java.io.*;
import java.net.*;

public class CalculadoraServidor {

    public static void main(String[] args) throws IOException {
        int puerto = 6002;
        ServerSocket servidor = new ServerSocket(puerto);
        System.out.println("Servidor de cálculo iniciado en el puerto " + puerto);

        while (true) {
            try (Socket clienteConectado = servidor.accept();
                 DataInputStream entrada = new DataInputStream(clienteConectado.getInputStream());
                 DataOutputStream salida = new DataOutputStream(clienteConectado.getOutputStream())) {

                // Leer la operación y los dos números enviados por el cliente
                String operacion = entrada.readUTF();
                double numero1 = entrada.readDouble();
                double numero2 = entrada.readDouble();

                // Realizar el cálculo
                double resultado = realizarOperacion(operacion, numero1, numero2);

                // Enviar el resultado de vuelta al cliente
                salida.writeDouble(resultado);
                
                System.out.println("Operación '" + operacion + "' realizada para " + clienteConectado.getInetAddress());
            } catch (IOException e) {
                System.err.println("Error al manejar la conexión del cliente: " + e.getMessage());
            }
        }
    }

    private static double realizarOperacion(String operacion, double num1, double num2) {
        if ("suma".equals(operacion)) {
            return num1 + num2;
        } else if ("resta".equals(operacion)) {
            return num1 - num2;
        } else if ("multiplicacion".equals(operacion)) {
            return num1 * num2;
        } else if ("division".equals(operacion)) {
            return num2 != 0 ? num1 / num2 : Double.POSITIVE_INFINITY;
        } else {
            return Double.NaN; // 
        }
    }

}
