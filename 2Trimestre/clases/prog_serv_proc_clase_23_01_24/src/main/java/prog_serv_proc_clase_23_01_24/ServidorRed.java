package prog_serv_proc_clase_23_01_24;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorRed {

	public static void main(String[] args) {
		
		ServerSocket servidor = null;
		Socket cliente = null;
		int puerto = 62000;
		try {
			servidor = new ServerSocket(puerto);
			System.out.println("Esperando cliente en el puerto: " + puerto);
			cliente = servidor.accept(); // el main se detiene aqui hasta aceptar a un cliente,
			
			InputStream input = cliente.getInputStream();// recibe entrada de bajo nivel
			ObjectInputStream ois = new ObjectInputStream(input);// transforma ese bajo nivel a objetos
			String cadenaLeida = (ois.readObject()).toString();// transforma el objeto en una cadena de texto y lo lee.
			System.out.println("El servidor dice: " + cadenaLeida);// muestra por consola el dato recibido.

			ObjectOutputStream oos=new ObjectOutputStream(cliente.getOutputStream());
			oos.writeObject("Hola, servidor. Soy un cliente.");
			System.out.println("Fin del mensaje");

			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			cliente.close();
			servidor.close();
		}catch(IOException e1) {
			e1.printStackTrace();
		}
	}
}
