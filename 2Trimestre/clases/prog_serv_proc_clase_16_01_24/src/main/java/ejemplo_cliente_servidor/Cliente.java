package ejemplo_cliente_servidor;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Cliente {
	public static void main(String[] args) throws IOException{
		
		String host = "localhost"; //direccion a la que se quiere conectar 
		int puerto = 2025; // puerto al que se quiere conectar
		
		Socket cliente = new Socket (host, puerto);
		
		//aqui ponemos lo que queramos que haha el cliente una vez se conecte.
		
		System.out.println("hola");
		
		cliente.close();//Cerramos cliente
	}
}
