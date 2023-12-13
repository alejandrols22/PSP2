package clase_22_11_23_actividades;

public class Actividad1 extends Thread {
	public static class NumerosPares extends Thread {
		public void run() {
			for (int i = 1; i <= 20; i++) {
				if (i % 2 == 0) {
					System.out.println("Par: " + i);
				}
			}
		}
	}

	public static class NumerosImpares extends Thread {
		public void run() {
			for (int i = 1; i <= 20; i++) {
				if (i % 2 != 0) {
					System.out.println("Impar: " + i);
				}
			}
		}
	}

	public static void main(String[] args) {
		NumerosPares hiloPares = new NumerosPares();
		NumerosImpares hiloImpares = new NumerosImpares();

		hiloPares.start(); // Inicia el hilo de números pares
		hiloImpares.start(); // Inicia el hilo de números impares
	}
}
