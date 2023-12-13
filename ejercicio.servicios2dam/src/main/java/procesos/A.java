package procesos;

import java.io.InputStream;

public class A {
/*
	1. Escribe alguna característica de un programa concurrenteUn programa concurrente es aquel que permite la ejecución de dos o más tareas ohilos de ejecución al mismo tiempo. Esto significa que las tareas pueden avanzar
	simultáneamente intercalando su ejecución en un único procesador, o en paralelosi
	se dispone de múltiples procesadores. Una característica importante de la
	concurrencia es la necesidad de sincronizar los recursos compartidos para evitar
	condiciones de carrera y otros problemas relacionados con el estado compartido. 2. ¿Cual es la ventaja de la concurrencia en los sistemas
	monoprocesador?
	Incluso en un sistema con un solo procesador, la concurrencia puede mejorar el
	rendimiento percibido al permitir que el sistema responda a eventos simultáneos. Por ejemplo, un servidor web puede manejar múltiples solicitudes de clientes al
	mismo tiempo. La concurrencia posibilita la multiplexación del tiempo del CPUentrediferentes tareas, lo que puede aumentar la eficiencia y la capacidad de respuestadel sistema, dando la ilusión de que se procesan simultáneamente al compartir el
	tiempo de CPU entre ellas. 3. ¿Cuales son las diferencias entre multiprogramacionymultiproceso?
	Mientras la multiprogramación permite que varios programas residan en la memoriapara ser procesados de forma alternativa, maximizando la utilización del CPUal
	pasar a otro programa cuando uno está esperando por E/S, el multiproceso posibilitala ejecución real y simultánea de múltiples procesos, ya sea en paralelo en distintos
	núcleos o de manera concurrente en un solo núcleo. En la multiprogramación, la concurrencia se logra por la administración del tiempode CPU que el sistema operativo asigna a cada programa, rotando entre ellos paraevitar tiempo ocioso; por otro lado, en el multiproceso, cada proceso puede
	ejecutarse realmente al mismo tiempo en su propio núcleo, haciendo un uso
	paralelo de los recursos del sistema. 4. ¿Cuales son los dos problemas principales inherentes alaprogramación concurrente?
	Condición de carrera: Ocurre cuando dos o más hilos o procesos acceden a un
	recurso compartido simultáneamente y al menos uno de los accesos es para escribir, y el resultado final depende del orden en que se accede al recurso. Esto puede llevar
	a resultados inconsistentes o impredecibles. Deadlock (interbloqueo): Sucede cuando dos o más hilos o procesos se bloqueanindefinidamente, esperando que el otro libere un recurso. Cada uno posee un
	recurso que el otro necesita para continuar, y ninguno está dispuesto a ceder loqueya tiene
	
	
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
	
	// Tarea 1
	ProcessBuilder pb=new ProcessBuilder("Notepad");
	Process p=pb.start();

	ProcessBuilder pb2=new ProcessBuilder("Calc");
	Process p2=pb2.start();
	
	ProcessBuilder pb3=new ProcessBuilder("\"C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe\"");
	Process p3=pb3.start();
	
	//Leer la consola desde eclipse
	
	// TODO Auto-generated method stub

			// Abrir la consola de comandos de Windows (CMD)
			ProcessBuilder pbCMD = new ProcessBuilder("CMD","/C","ipconfig");
			Process pCMD = pbCMD.start();
			
			InputStream is = pCMD.getInputStream();
			
			int c;
			
			while((c=is.read()) != -1) {
				System.out.print((char) c);
			}
			is.close();
		}
*/
	
}
