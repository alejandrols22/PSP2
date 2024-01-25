package tarea2_comunicacion;


import java.io.*;
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

            ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
            int numero = (int) ois.readObject(); // Lee el número enviado por el cliente
            int cuadrado = numero * numero; // Calcula el cuadrado

            ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
            oos.writeObject(cuadrado); // Envía el cuadrado al cliente

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
