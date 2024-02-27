package ejercicio1;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Servidor {
    // Método para convertir de byte a hexadecimal
    static String hexadecimal(byte[] resumen) {
        String hex = "";
        for (int i = 0; i < resumen.length; i++) {
            String h = Integer.toHexString(resumen[i] & 0xFF);
            if (h.length() == 1)
                hex += "0";
            hex += h;
        }
        return hex.toUpperCase();
    }

    // Método para encriptar la contraseña en SHA-256
    static String encriptarSHA256(String contraseña) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(contraseña.getBytes(StandardCharsets.UTF_8));
            return hexadecimal(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        final int PUERTO = 6400;
        final String CONTRASEÑA_ENCRIPTADA = encriptarSHA256("cenec");

        try (ServerSocket servidor = new ServerSocket(PUERTO)) {
            System.out.println("Servidor iniciado, esperando por cliente...");
            try (Socket cliente = servidor.accept();
                 PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);
                 BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()))) {

                System.out.println("Cliente conectado. Pidiendo contraseña...");
                salida.println("Por favor, ingrese la contraseña:");

                String contraseñaCliente = entrada.readLine();
                String contraseñaClienteEncriptada = encriptarSHA256(contraseñaCliente);

                if (CONTRASEÑA_ENCRIPTADA.equals(contraseñaClienteEncriptada)) {
                    salida.println("Acceso permitido");
                } else {
                    salida.println("Acceso denegado");
                }
            }
        } catch (IOException e) {
            System.out.println("Error al iniciar el servidor: " + e.getMessage());
        }
    }
}


