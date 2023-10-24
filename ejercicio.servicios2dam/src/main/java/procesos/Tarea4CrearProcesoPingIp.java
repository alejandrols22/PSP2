package procesos;

import java.io.File;
import java.io.IOException;

public class Tarea4CrearProcesoPingIp {

	public static void main(String[] args) {
	        // Crear el comando para hacer ping
	        String os = System.getProperty("os.name").toLowerCase();

	        String[] command;

	        if (os.contains("win")) {
	            command = new String[]{"cmd", "/c", "ping", "192.168.0.1"};
	        } else {
	            command = new String[]{"ping", "-c", "4", "192.168.0.1"};
	        }

	        // Crear el archivo de salida
	        File outputFile = new File("pingResults.txt");

	        // Crear el proceso
	        ProcessBuilder pb = new ProcessBuilder(command);
	        pb.redirectOutput(outputFile);

	        try {
	            pb.start().waitFor();
	            System.out.println("Ping realizado y resultados guardados en pingResults.txt");
	        } catch (IOException | InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	
	}


