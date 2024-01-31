package ejercicio;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class ObjetoServidor {
    public static void main(String[] args) {
        int puerto = 6000;
        try {
            ServerSocket servidor = new ServerSocket(puerto);
            System.out.println("Esperando al cliente en el puerto: " + servidor.getLocalPort());
            Socket cliente = servidor.accept();

            // Recibir Pokemon del cliente
            ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
            Pokemon pokemonRecibido = (Pokemon) ois.readObject();

            // Enviar desafío al cliente
            ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
            oos.writeObject("Entrenador Gary quiere luchar (Y/N)");

            // Recibir respuesta del cliente
            String respuesta = (String) ois.readObject();
            if ("N".equalsIgnoreCase(respuesta)) {
                oos.writeObject("Eres un cagao.");
            } else {
                // Lógica del juego
                Random random = new Random();
                int resultado = random.nextInt(100) + 1;
                if (resultado < 50) {
                    pokemonRecibido.setVida(0);
                    oos.writeObject(pokemonRecibido);
                } else {
                    pokemonRecibido.setNivel(pokemonRecibido.getNivel() + 1);
                    oos.writeObject(pokemonRecibido);
                }
            }

            // Cerrar conexiones
            ois.close();
            oos.close();
            cliente.close();
            servidor.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
