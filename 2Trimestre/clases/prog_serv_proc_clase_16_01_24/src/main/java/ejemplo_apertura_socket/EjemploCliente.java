package ejemplo_apertura_socket;

import java.io.IOException;
import java.net.Socket;

public class EjemploCliente {
	public static void main(String[] args) throws IOException {
		String host = "localhost";
		int puerto = 6000;// puerto remoto
		
		System.out.println("PROGRAMA CLIENTE INICIADO......");
		//En el programa cliente es necesario crear un objeto Socket, donde aparece
		//el nombre del equipo y el puerto donde nos queremos conectar.
		Socket Cliente = new Socket(host, puerto);
	}
}
