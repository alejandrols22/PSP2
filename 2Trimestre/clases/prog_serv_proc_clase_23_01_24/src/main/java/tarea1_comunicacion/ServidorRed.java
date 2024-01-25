package tarea1_comunicacion;



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

            cliente = servidor.accept();
            System.out.println("Cliente conectado.");

            ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
            String mensajeRecibido = (String) ois.readObject();
            System.out.println("Mensaje recibido del cliente: " + mensajeRecibido);

            // Convertir el mensaje a minúsculas
            String respuesta = mensajeRecibido.toLowerCase();
            
            ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
            oos.writeObject(respuesta); // Enviar respuesta al cliente
            System.out.println("Respuesta enviada al cliente.");

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (cliente != null) cliente.close();
                if (servidor != null) servidor.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

