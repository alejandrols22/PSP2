package procesos;

import java.io.IOException;
import java.io.InputStream;

public class Tarea2MostrarProcesos {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

				// Abrir la consola de comandos de Windows (CMD)
				ProcessBuilder pbCMD = new ProcessBuilder("CMD","/C","tasklist");
				Process pCMD = pbCMD.start();
				
				InputStream is = pCMD.getInputStream();
				
				int c;
				
				while((c=is.read()) != -1) {
					System.out.print((char) c);
				}
				is.close();
			}

		}

