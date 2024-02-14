package practicahash2;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class PracticaHash2 {
    
    private static final String SAVED_PASSWORD_HASH = "admin_password";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce tu contraseña:");

        // Leer la contraseña introducida por el usuario
        String inputPassword = scanner.nextLine();

        // Encriptar la contraseña introducida y convertirla a hexadecimal
        String inputPasswordHash = hashPassword(inputPassword);
        
        // Mostrar el hash de la contraseña ingresada
        System.out.println("Hash de la contraseña introducida: " + inputPasswordHash);

        // Comprobar si los hashes coinciden
        if (SAVED_PASSWORD_HASH.equalsIgnoreCase(inputPasswordHash)) {
            System.out.println("Contraseña correcta.");
        } else {
            System.out.println("Nunca acertarás la admin_password, reinstala Odú. 😈");
        }
        
        scanner.close();
    }

    // Método para encriptar la contraseña con SHA-256 y convertirla a hexadecimal
    private static String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes());
            return bytesToHex(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Algoritmo de hashing no encontrado", e);
        }
    }

    // Método auxiliar para convertir bytes a hexadecimal
    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString().toUpperCase();
    }
}
