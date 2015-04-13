package practica2;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jaime Ruiz-Borau Vizarraga (546751)
 * @author Patricia Lazaro Tello (554309)
 * 
 *         Clase que implementa el algoritmo de fuerza bruta para encontrar el
 *         camino hamiltoniano minimo del grafo
 */

public class FuerzaBruta {

	public static void main(String[] args) throws FileNotFoundException{
		String path = "./data/grafo.txt";
		int[][] matriz = Fichero.getGrafo(path);
		showCaminosHamiltonianos(matriz);
	}
	
	public static void showCaminosHamiltonianos(int[][] matrizAdyacencia) {
		List<Integer> visitados = new ArrayList<Integer>();

		searchCaminosHamiltonianosRec(matrizAdyacencia, visitados, 0, 0);
	}

	private static void searchCaminosHamiltonianosRec(int[][] matrizAdyacencia,
			List<Integer> visitados, int nodoActual, int nodoOrigen) {
		// Caso base. Ya hemos encontrado un camino hamiltoniano
		if (visitados.size() == matrizAdyacencia.length
				&& nodoActual == nodoOrigen) {
			visitados.add(nodoActual);
			System.out.println(visitados.toString());
		} else if (visitados.size() == matrizAdyacencia.length
				&& nodoActual != nodoOrigen) {
			// No hacemos nada. No hemos vuelto al origen, no es un camino
			// hamiltoniano
		} else {
			if (visitados.contains(nodoActual)) {
				// No hacemos nada. Este nodo ya lo hemos mirado
			} else {
				visitados.add(nodoActual);
				for (int i = 0; i < matrizAdyacencia.length; i++) {
					if (i != nodoActual) {
						searchCaminosHamiltonianosRec(matrizAdyacencia,
								visitados, i, nodoOrigen);
					}
				}
			}
		}
	}
}
