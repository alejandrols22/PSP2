package ejemplo_apertura_socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EjemploServidor {
	
	public static void main(String[] args) throws IOException {
		
		//APERTURA DEL SOCKET
		int numeroPuerto = 6000;
		
		// en el programa servidro se crea un objeto ServerSocket invocando al metodo ServerSocket()
		// en el que indicamos el numero de puerto por el que el servidor escucha las peticiones de conexion de clientes.
		ServerSocket servidor = new ServerSocket(numeroPuerto);
		
		//Necesitamos tambien un objeto Socket para aceptar las peticiones clientes.
		Socket clienteConectado = null;
		System.out.println("Esperando al cliente....");
		clienteConectado = servidor.accept();
	}

}
