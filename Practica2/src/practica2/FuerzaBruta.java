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

	private static List<String> resultados = new ArrayList<String>();

	/**
	 * Basandose en un fichero llamado "grafo.txt" muestra los caminos
	 * hamiltonianos empleando fuerza bruta. Usado para testeo.
	 * 
	 * @param args
	 *            : No empleado
	 * @throws FileNotFoundException
	 *             : Si el fichero no existe
	 */

	public static void main(String[] args) throws FileNotFoundException {
		String path = "./data/grafo.txt";
		int[][] matriz = Fichero.getGrafo(path);
		showCaminosHamiltonianos(matriz);
	}

	/**
	 * Realiza la busqueda por fuerza bruta de todos los caminos hamiltonianos
	 * en un grafo y muestra los resultados por pantalla
	 * 
	 * @param matrizAdyacencia
	 *            : matriz de adyacencia que representa un grafo
	 */
	public static void showCaminosHamiltonianos(int[][] matrizAdyacencia) {
		searchCaminosHamiltonianos(matrizAdyacencia);
		for (String res : resultados) {
			System.out.println(res);
		}
	}

	/**
	 * Aplica el algoritmo de fuerza bruta para resolver el problema de caminos
	 * hamiltonianos en un grafo representado por su matriz de adyacencia
	 * 
	 * @param matrizAdyacencia
	 *            : matriz de adyacencia que representa un grafo
	 */
	public static void searchCaminosHamiltonianos(int[][] matrizAdyacencia) {
		resultados = new ArrayList<String>();
		List<Integer> visitados = new ArrayList<Integer>();
		searchCaminosHamiltonianosRec(matrizAdyacencia, visitados, 0, 0, 0);
	}

	/**
	 * Aplica el algoritmo de fuerza bruta para resolver el problema de caminos
	 * hamiltonianos en un grafo representado por su matriz de adyacencia,
	 * considerando que se han visitado ya los vertices de <visitados>, que el
	 * vertice a explorar es <nodoActual> y que se ha de volver al vertice
	 * <nodoOrigen>
	 * 
	 * @param matrizAdyacencia
	 *            : matriz de adyacencia que representa un grafo
	 * @param visitados
	 *            : lista que representa los nodos ya visitados (en el orden en
	 *            que se visitaron)
	 * @param nodoActual
	 *            : vertice desde el cual exploramos soluciones
	 * @param nodoOrigen
	 *            : vertice de finalizacion tras recorrer el resto de vertices
	 */
	private static void searchCaminosHamiltonianosRec(int[][] matrizAdyacencia,
			List<Integer> visitados, int nodoActual, int nodoOrigen, int coste) {
		// Caso base. Ya se ha encontrado un camino hamiltoniano
		if (visitados.size() == matrizAdyacencia.length
				&& nodoActual == nodoOrigen) {
			visitados.add(nodoActual);
			String res = visitados.toString() + " -- " + coste;
			resultados.add(res);
			// System.out.println(visitados.toString() + " -- " + coste);
		} else if (visitados.size() == matrizAdyacencia.length
				&& nodoActual != nodoOrigen) {
			// Se han recorrido los vertices pero no se ha llegado al vertice
			// inicial
		} else {
			if (visitados.contains(nodoActual)) {
				// Ya se ha explorado dicho vertice
			} else {
				visitados.add(nodoActual);
				for (int i = 0; i < matrizAdyacencia.length; i++) {
					if (i != nodoActual
							&& matrizAdyacencia[nodoActual][i] < Integer.MAX_VALUE) {
						List<Integer> vis = new ArrayList<Integer>();
						vis.addAll(visitados);
						searchCaminosHamiltonianosRec(matrizAdyacencia, vis, i,
								nodoOrigen, coste
										+ matrizAdyacencia[nodoActual][i]);
					}
				}
			}
		}
	}
}
