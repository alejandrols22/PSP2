package procesos;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class Tarea5GetOutputStream {

	/*
	 * getOutputStream() es un método de Java que se utiliza para obtener un flujo
	 * de salida desde un objeto de proceso. Este flujo de salida se puede utilizar
	 * para enviar datos a otro proceso. Por ejemplo, si tienes dos programas, P1 y
	 * P2, y quieres que P1 envíe una cadena de texto a P2, puedes utilizar
	 * getOutputStream() para obtener el flujo de salida de P1 y enviar la cadena a
	 * través del flujo. Luego, en P2, puedes utilizar getInputStream() para obtener
	 * el flujo de entrada y recibir la cadena.
	 * 
	 * 
	 */
	public static void main(String[] args) throws IOException {
		ProcessBuilder pbCMD = new ProcessBuilder("CMD");
		pbCMD.redirectErrorStream(true); // Redirige el error a la salida estándar
		Process pCMD = pbCMD.start();

		try (OutputStream os = pCMD.getOutputStream();
				PrintWriter writer = new PrintWriter(os);
				InputStream is = pCMD.getInputStream()) {

			// Utiliza getOutputStream() para enviar comandos al proceso CMD
			writer.println("date 10/24/2023"); // Cambia la fecha a 24 de Octubre de 2023
			writer.println("exit"); // Sale del CMD
			writer.flush(); // Asegura que todos los comandos se envíen

			// Lee y muestra la salida del proceso
			int c;
			while ((c = is.read()) != -1) {
				System.out.print((char) c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}