package ejemplo_cliente_servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) throws IOException {//IOException para dejar el codigo mas limpio
		int puerto = 2025;// asigno el puerto de escucha
		
		ServerSocket servidor = new ServerSocket(puerto);// creamos la clase servidor y le damos el parametro puerto
		
		System.out.println("Escuchando en el puerto: " + servidor.getLocalPort());// probamos el metodo
		
		
		Socket cliente = servidor.accept(); // metodo de espera de aceptar cliente1
		
		Socket cliente2 = servidor.accept();// metodo de espera de aceptar cliente2
		
		servidor.close(); // cierra el servidor
	}

}
