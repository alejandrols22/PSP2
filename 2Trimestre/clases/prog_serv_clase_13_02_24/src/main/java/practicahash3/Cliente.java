package practicahash3;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Cliente {
    public static void main(String[] args) {
        String mensaje = "El cuco está en el nido.";
        System.out.println("Cliente: El mensaje original es: '" + mensaje + "'");
        
        String hashMensaje = encriptarSHA256(mensaje);
        System.out.println("Cliente: El hash SHA-256 del mensaje es: " + hashMensaje);
        
        Servidor.recibirMensaje(mensaje, hashMensaje);
    }

    public static String encriptarSHA256(String mensaje) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(mensaje.getBytes());
            return bytesToHex(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("No se pudo encontrar el algoritmo SHA-256", e);
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString().toUpperCase();
    }
}
