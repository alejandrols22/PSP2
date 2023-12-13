package clase_22_11_23_actividades;

public class Actividad2 {

	public static void main(String[] args) {
		while (true) { // Bucle infinito
			try {
				System.out.println("Tic");
				Thread.sleep(500);
				System.out.println("Tac");
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
