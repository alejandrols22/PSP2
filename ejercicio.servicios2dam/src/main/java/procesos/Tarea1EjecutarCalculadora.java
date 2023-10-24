package procesos;

import java.io.IOException;

public class Tarea1EjecutarCalculadora {

	public static void main(String[] args) throws IOException {
		
		// Tarea 1
		ProcessBuilder pb=new ProcessBuilder("Notepad");
		Process p=pb.start();

		ProcessBuilder pb2=new ProcessBuilder("Calc");
		Process p2=pb2.start();
		
		ProcessBuilder pb3=new ProcessBuilder("\"C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe\"");
		Process p3=pb3.start();
		
		//Leer la consola desde eclipse
		
		
	}

}
