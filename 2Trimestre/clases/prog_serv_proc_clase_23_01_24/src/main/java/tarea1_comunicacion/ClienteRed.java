package tarea1_comunicacion;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClienteRed {
    
    public static void main(String[] args) {
        Socket cliente = null;

        try {
            cliente = new Socket("localhost", 62000);
            ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
            String mensaje = "HOLA SERVIDOR, SOY UN CLIENTE.";
            oos.writeObject(mensaje);
            System.out.println("Mensaje enviado al servidor: " + mensaje);

            ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
            String respuesta = (String) ois.readObject();
            System.out.println("Respuesta del servidor: " + respuesta);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (cliente != null) cliente.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

