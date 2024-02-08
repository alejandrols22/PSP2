package ejercicios;

import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

public class ConversorMonedasServidor {

    // Tasas de cambio estáticas para el ejercicio
    private static final Map<String, Double> TASAS_DE_CAMBIO = new HashMap<>();
    static {
        TASAS_DE_CAMBIO.put("USD", 1.08);
        TASAS_DE_CAMBIO.put("GBP", 0.86);
        TASAS_DE_CAMBIO.put("JPY", 159.78);
    }

    public static void main(String[] args) throws IOException {
        int puerto = 6000;
        ServerSocket servidor = new ServerSocket(puerto);
        System.out.println("Servidor de conversión de monedas iniciado...");

        while (true) {
            try (Socket clienteConectado = servidor.accept();
                 DataInputStream entrada = new DataInputStream(clienteConectado.getInputStream());
                 DataOutputStream salida = new DataOutputStream(clienteConectado.getOutputStream())) {

                // Leer la cantidad de euros enviada por el cliente
                double cantidadEuros = entrada.readDouble();

                // Calcular las conversiones
                double dolares = convertirMoneda(cantidadEuros, "USD");
                double libras = convertirMoneda(cantidadEuros, "GBP");
                double yenes = convertirMoneda(cantidadEuros, "JPY");

                // Enviar las conversiones al cliente
                salida.writeUTF("Cantidad en Euros: " + cantidadEuros + "\n" +
                                "Equivalente en USD: " + dolares + "\n" +
                                "Equivalente en GBP: " + libras + "\n" +
                                "Equivalente en JPY: " + yenes + "\n");
                
                System.out.println("Conversión realizada para " + clienteConectado.getInetAddress());
            } catch (IOException e) {
                System.err.println("Error al manejar la conexión del cliente: " + e.getMessage());
            }
        }
    }

    private static double convertirMoneda(double cantidad, String divisa) {
        return cantidad * TASAS_DE_CAMBIO.getOrDefault(divisa, 0.0);
    }
}
