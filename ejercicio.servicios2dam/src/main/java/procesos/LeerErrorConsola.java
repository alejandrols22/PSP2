package procesos;

import java.io.IOException;
import java.io.InputStream;

public class LeerErrorConsola {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//L4 ∩ E2 ≠ Ø

				// Abrir la consola de comandos de Windows (CMD)
				ProcessBuilder pbCMD = new ProcessBuilder("CMD","/C","ipcon");
				Process pCMD = pbCMD.start();
				
				InputStream is = pCMD.getInputStream();
				
				int c;
				
				while((c=is.read()) != -1) {
					System.out.print((char) c);
				}
				is.close();
				
				InputStream isError = pCMD.getErrorStream();
				int cError;
				while((cError=isError.read()) != -1) {
						System.out.print((char) cError);
				}
				isError.close();
			}

		}
