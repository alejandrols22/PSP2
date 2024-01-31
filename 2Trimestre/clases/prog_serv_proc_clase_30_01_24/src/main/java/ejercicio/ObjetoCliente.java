package ejercicio;


import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ObjetoCliente {
    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 6000;
        try {
            Socket cliente = new Socket(host, puerto);
            System.out.println("Conectado con Servidor en el puerto: " + cliente.getPort());

            Pokemon miPokemon = new Pokemon("Pikachu", 100, 5); // Crear un Pokemon

            // Enviar Pokemon al servidor
            ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
            oos.writeObject(miPokemon);

            // Recibir desafío del servidor
            ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
            System.out.println((String) ois.readObject()); // Mostrar desafío

            // Responder al desafío
            Scanner scanner = new Scanner(System.in);
            String respuesta = scanner.nextLine();
            oos.writeObject(respuesta);

            // Recibir resultado del combate o mensaje "Eres un cagao."
            Object resultado = ois.readObject();
            if (resultado instanceof Pokemon) {
                miPokemon = (Pokemon) resultado;
                if (miPokemon.getVida() == 0) {
                    System.out.println("Has perdido. " + miPokemon.getNombre() + " vida = 0");
                } else {
                    System.out.println("Has ganado. " + miPokemon.getNombre() + " nivel " + miPokemon.getNivel());
                }
            } else if (resultado instanceof String) {
                System.out.println((String) resultado);
            }

            // Cerrar conexiones
            ois.close();
            oos.close();
            cliente.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

