package practicahash1;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PracticaHash {
	public static void main(String[] args) {
		String texto = "Se dice Odú porque lo dice Estiik";
		try {
			// Crear instancias de MessageDigest para SHA-1 y MD5
			MessageDigest sha1Digest = MessageDigest.getInstance("SHA-1");
			MessageDigest md5Digest = MessageDigest.getInstance("MD5");

			// Actualizar los MessageDigest con el texto convertido a bytes
			sha1Digest.update(texto.getBytes());
			md5Digest.update(texto.getBytes());

			// Obtener los resúmenes de mensaje
			byte[] sha1Bytes = sha1Digest.digest();
			byte[] md5Bytes = md5Digest.digest();

			// Imprimir los resúmenes y el número de bytes
			System.out.println("Resumen SHA-1: " + bytesToHex(sha1Bytes) + " | Número de bytes: " + sha1Bytes.length);
			System.out.println("Resumen MD5: " + bytesToHex(md5Bytes) + " | Número de bytes: " + md5Bytes.length);
		} catch (NoSuchAlgorithmException e) {
			System.err.println("Algoritmo de Hash no encontrado: " + e.getMessage());
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

/*
 * 
 * 
 * La familia de cifrado SHA-2 es generalmente más segura que su predecesora
 * SHA-1 debido a sus resúmenes de mensaje más largos y su mayor resistencia a
 * los ataques de colisión. Dentro de SHA-2, SHA-256 es ampliamente utilizado y
 * considerado seguro para la mayoría de las aplicaciones. SHA-512/256 o SHA-512
 * son más seguros debido a su mayor longitud de bit y son utilizados cuando se
 * requieren niveles de seguridad aún más altos
 * 
 * 
 * 
 * 
 * 
 */

