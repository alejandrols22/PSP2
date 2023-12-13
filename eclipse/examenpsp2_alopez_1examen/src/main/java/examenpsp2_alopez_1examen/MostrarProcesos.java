package examenpsp2_alopez_1examen;

import java.io.IOException;
import java.io.InputStream;

public class MostrarProcesos {

	public static void main(String[] args) {
		

				
				ProcessBuilder pbCMD = new ProcessBuilder("CMD","/C","tasklist");
				Process pCMD = null;
				try {
					pCMD = pbCMD.start();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				
				InputStream is = pCMD.getInputStream();
				
				int c;
				
				try {
					while((c=is.read()) != -1) {
						System.out.print((char) c);
					}
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				try {
					is.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}

		}

