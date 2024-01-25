package tarea2_comunicacion;


import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClienteRed {

    public static void main(String[] args) {

        Socket cliente = null;
        Scanner scanner = new Scanner(System.in);

        try {
            cliente = new Socket("localhost", 62000);
            ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());

            System.out.print("Introduce un número entero: ");
            int numero = scanner.nextInt();
            oos.writeObject(numero); // Envía el número al servidor

            ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
            int respuesta = (int) ois.readObject(); // Recibe la respuesta del servidor
            System.out.println("El cuadrado del número es: " + respuesta); // Muestra el cuadrado

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (cliente != null) cliente.close();
                scanner.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
