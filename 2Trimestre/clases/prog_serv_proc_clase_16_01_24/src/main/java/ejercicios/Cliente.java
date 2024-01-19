package ejercicios;

import java.io.IOException;
import java.net.Socket;

public class Cliente {
	public static void main(String[] args) throws IOException {
		String host = "127.0.0.1"; // Usamos la dirección IP de localhost
		int puerto = 2027;

		String host2 = "127.0.0.1";

		Socket cliente = new Socket(host, puerto);
		System.out.println("Cliente conectado.");
		cliente.close();

		Socket cliente2 = new Socket(host2, puerto);
		System.out.println("Cliente 2 conectado.");
		cliente.close();
	}
}
