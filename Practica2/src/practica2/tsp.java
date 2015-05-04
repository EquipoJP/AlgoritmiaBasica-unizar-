package practica2;

import java.io.FileNotFoundException;

/**
 * @author Jaime Ruiz-Borau Vizarraga (546751)
 * @author Patricia Lazaro Tello (554309)
 * 
 * Clase principal desde la que se lanza la aplicacion
 */

public class tsp {

	public static void main(String[] args) {
		int[][] grafo = null;
		int n = args.length;
		boolean dynamic = false;

		/* comprobacion del numero de argumentos */
		if (n != 2) {
			/* error en los parametros: salida */
			System.out.println("Ejecucion del programa: tsp -[opcion] <fichero>,");
			System.out.println("\t Opcion : [-d | -b],");
			
			System.out.println("\t -d : programacion dinamica");
			System.out.println("\t -b : fuerza bruta");
			
			System.out.println("\t <fichero> : ruta del fichero donde esta almacenado");
			System.out.println("\t             el grafo sobre el que trabajar.");
			
			System.out.println();
			
			System.out.println("El fichero debera tener la siguiente estructura:");
			System.out.println("<numero de vertices>");
			System.out.println("matriz de <numero de vertices x numero de vertices>");
			System.exit(-1);
		}
		
		String arg1 = args[0];
		
		/* comprobacion del primer argumento */
		if(arg1.compareTo("-d") == 0){
			dynamic = true;
		}
		else if(arg1.compareTo("-b") == 0){
			dynamic = false;
		}
		else{
			System.out.println("El primer argumento ha de ser [-d | -b]");
			System.exit(-1);
		}
		
		String arg2 = args[1];
		
		try {
			grafo = Fichero.getGrafo(arg2);
		} catch (FileNotFoundException e) {
			System.err.println("Ha ocurrido un error en el fichero.");
			System.err.println("Por favor, revise la ruta del fichero:");
			System.err.println("\t " +  arg2);
			
			System.exit(-1);
		}
		
		/* parametros correctos */
		
		if (dynamic){
			ProgDinamica.showCaminosHamiltonianos(grafo);
		}
		else{
			FuerzaBruta.showCaminosHamiltonianos(grafo);
		}
	}
}
