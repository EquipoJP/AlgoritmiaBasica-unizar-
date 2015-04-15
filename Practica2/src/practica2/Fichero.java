package practica2;

/**
 * @author Jaime Ruiz-Borau Vizarraga (546751)
 * @author Patricia Lazaro Tello (554309)
 * 
 * Clase auxiliar para el tratamiento de ficheros
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Fichero {

	/**
	 * @param path
	 *            : ruta del fichero
	 * @return el grafo almacenado en dicho fichero
	 * @throws FileNotFoundException
	 *             si el fichero no existe o la ruta es invalida
	 */
	public static int[][] getGrafo(String path) throws FileNotFoundException {
		int[][] grafo;

		File f = new File(path);
		Scanner s = new Scanner(f);

		int n = s.nextInt();
		s.nextLine();

		grafo = new int[n][n];

		for (int i = 0; i < n; i++) {

			for (int j = 0; j < n; j++) {
				int elem = s.nextInt();
				if(elem == 0)
					elem = Integer.MAX_VALUE;
				grafo[i][j] = elem;
			}
			s.nextLine();
		}

		s.close();
		return grafo;
	}
}
