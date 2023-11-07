package psp_7_11_23;
//Mi clase principal hereda de Thread
public class Principal extends Thread{
	//Creo una variable entera
	private int id;
	
	public Principal (int id) {
		this.id=id;
	}
	
	//esto es lo que van a ejecutar los hilos
	public void run() {
		System.out.println("Soy el hilo " + id);
		
		
	}
	
	public static void main(String[] args) {
		
		Principal h1 = new Principal (1);
		Principal h2 = new Principal (2);
		Principal h3 = new Principal (3);
		
		
		h1.start();
		h2.start();
		h3.start();
		
		System.out.println("Soy el hilo principal");
	}
}
