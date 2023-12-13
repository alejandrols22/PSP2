package examenpsp2_alopez_1examen;

import java.io.IOException;

/*
 * Alejandro López Sepúlveda
 */
public class AbrirChrome {

	

	
	    public static void main(String[] args) {

	        try {
	           
	        	ProcessBuilder pb = new ProcessBuilder("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
	            Process p = pb.start();
	        } catch (IOException e) {
	            System.out.println("No se puedo abrir Google Chrome.");
	            e.printStackTrace();
	        }
	    }
	}

