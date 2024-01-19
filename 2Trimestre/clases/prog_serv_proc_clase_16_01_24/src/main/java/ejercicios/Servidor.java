package ejercicios;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.InetAddress;

public class Servidor {

	public static void main(String[] args) throws IOException {
		// Se establece el puerto en el que el servidor escuchará las conexiones
		int puerto = 2027;
		// Se crea el socket del servidor en el puerto especificado
		ServerSocket servidor = new ServerSocket(puerto);

		// Se imprime en consola el puerto en el que el servidor está escuchando
		System.out.println("Servidor escuchando en el puerto: " + servidor.getLocalPort());

		// Bucle para aceptar dos clientes
		for (int i = 0; i < 2; i++) {
			// El servidor espera (bloquea) hasta que un cliente se conecte
			Socket cliente = servidor.accept();

			// Se crea una tarea para manejar al cliente, usando una expresión lambda
			Runnable tarea = () -> {
				try {
					// Obtiene la dirección del cliente conectado
					InetAddress direccionCliente = cliente.getInetAddress();

					// Se imprime información del cliente en la consola
					System.out.println("Cliente conectado en hilo: " + Thread.currentThread().getName());
					System.out.println("\tPuerto local: " + cliente.getLocalPort());
					System.out.println("\tPuerto remoto: " + cliente.getPort());
					System.out.println("\tNombre del host: " + direccionCliente.getHostName());
					System.out.println("\tIP del host: " + direccionCliente.getHostAddress());

					// Se cierra la conexión con el cliente
					cliente.close();
				} catch (IOException e) {
					// Se captura y se imprime cualquier excepción que ocurra
					e.printStackTrace();
				}
			};
			// Se inicia un nuevo hilo con la tarea definida
			new Thread(tarea).start();
		}

		// Se cierra el socket del servidor, ya no se aceptarán más clientes
		servidor.close();
	}
}
