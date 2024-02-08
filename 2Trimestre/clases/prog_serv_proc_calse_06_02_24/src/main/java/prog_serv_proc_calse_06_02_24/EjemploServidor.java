package prog_serv_proc_calse_06_02_24;

import java.io.*;
import java.net.*;

public class EjemploServidor {
	public static void main(String[] args) throws IOException {
		// APERTURA DEL SOCKET
		int numeroPuerto = 6000; // puerto
		// En el programa servidor, se crea un objeto ServerSocket invocando al método
		// ServerSocket()
		// en el que indicamos el número de puerto por el que el servidor escucha las
		// peticiones de conexión de clientes.
		ServerSocket servidor = new ServerSocket(numeroPuerto);

		System.out.println("Esperando al cliente...");

		// Necesitamos también un objeto Socket para aceptar las peticiones clientes.
		Socket clienteConectado = servidor.accept();

		// CREO FLUJO DE ENTRADA DEL CLIENTE
		InputStream entrada = clienteConectado.getInputStream();
		DataInputStream flujoEntrada = new DataInputStream(entrada);

		// EL CLIENTE ENVÍA UN MENSAJE
		System.out.println("Recibiendo del CLIENTE: \n\t" + flujoEntrada.readUTF());

		// CREO FLUJO DE SALIDA AL CLIENTE
		OutputStream salida = clienteConectado.getOutputStream();
		DataOutputStream flujoSalida = new DataOutputStream(salida);

		// ENVÍO UN SALUDO AL CLIENTE
		flujoSalida.writeUTF("Hola, don José.");

		// CERRAR STREAMS Y SOCKETS
		entrada.close();
		flujoEntrada.close();
		salida.close();
		flujoSalida.close();
		clienteConectado.close();
		servidor.close();
	}
}
