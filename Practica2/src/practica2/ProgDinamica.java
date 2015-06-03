package practica2;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Jaime Ruiz-Borau Vizarraga (546751)
 * @author Patricia Lazaro Tello (554309)
 * 
 *         Clase que implementa el algoritmo de programacion dinamica para
 *         encontrar el camino hamiltoniano minimo del grafo
 */

public class ProgDinamica {

	/**
	 * Basandose en un fichero llamado "grafo.txt" muestra los caminos
	 * hamiltonianos empleando programacion dinamica. Usado para testeo.
	 * 
	 * @param args
	 *            : No empleado
	 * @throws FileNotFoundException
	 *             : Si el fichero no existe
	 */
	public static void main(String[] args) throws FileNotFoundException {
		int[][] testingu = Fichero.getGrafo("grafo.txt");
		showCaminosHamiltonianos(testingu);
	}

	/**
	 * 
	 * @param matrizAdyacencia
	 * @return
	 */
	public static HashSet<Integer> inicializar(int[][] matrizAdyacencia) {
		Gtab.initGtab(matrizAdyacencia);
		HashSet<Integer> h = new HashSet<Integer>();
		for (int i = 1; i < matrizAdyacencia.length; i++) {
			h.add(i);
		}
		return h;
	}

	/**
	 * Realiza la busqueda por Programacion Dinamica del camino hamiltoniano de
	 * minimo coste en un grafo y muestra los resultados por pantalla
	 * 
	 * @param matrizAdyacencia
	 *            : matriz de adyacencia que representa un grafo
	 */
	public static void showCaminosHamiltonianos(int[][] matrizAdyacencia) {
		HashSet<Integer> h = inicializar(matrizAdyacencia);
		Info info = searchCaminosHamiltonianos(matrizAdyacencia, h);

		System.out.println("Coste: " + info.getCoste());
		System.out.println("Recorrido: " + info.getRecorrido());
	}

	/**
	 * Aplica el metodo de programacion dinamica para resolver el problema de
	 * caminos hamiltonianos en un grafo representado por su matriz de
	 * adyacencia
	 * 
	 * @param matrizAdyacencia
	 *            : matriz de adyacencia que representa un grafo
	 * @param h
	 *            : set con los vertices iniciales
	 */
	public static Info searchCaminosHamiltonianos(int[][] matrizAdyacencia,
			HashSet<Integer> h) {
		Info info = g(0, h, matrizAdyacencia);
		return info;
	}

	/**
	 * Funcion con memoria "g" que ejecuta el algoritmo de programacion dinamica
	 * y emplea la tabla gtab para encontrar el camino hamiltoniano de menor
	 * coste
	 * 
	 * @param i
	 *            : Nodo actual
	 * @param S
	 *            : Conjunto de nodos restantes
	 * @param L
	 *            : Matriz de adyacencia con los costes de cada camino
	 * @return el objeto Info con el recorrido m�s corto para recorrer el set de
	 *         nodos S y el coste de recorrer ese camino
	 */
	public static Info g(int i, Set<Integer> S, int[][] L) {
		if (S.size() == 0) {
			List<Integer> rec = new ArrayList<Integer>();
			rec.add(i);
			rec.add(0);
			Info info = new Info(L[i][0], rec);
			return info;
		} else {
			if (Gtab.getGtab().get(S).get(i).getCoste() >= 0) {
				return Gtab.getGtab().get(S).get(i);
			} else {
				Integer masCorto = Integer.MAX_VALUE;
				List<Integer> rec = new ArrayList<Integer>();
				List<Integer> rectemp = new ArrayList<Integer>();
				for (int j : S) {
					HashSet<Integer> temp = new HashSet<Integer>();
					temp.addAll(S);
					temp.remove(j);
					Info info = g(j, temp, L);
					int distancia = L[i][j] + info.getCoste();
					if (distancia < masCorto && distancia > 0) {
						masCorto = distancia;
						rectemp = info.getRecorrido();
					}
				}
				rec.add(i);
				for(int a = 0; a < rectemp.size(); a++){
					rec.add(rectemp.get(a));
				}
				Gtab.getGtab().get(S).set(i, new Info(masCorto, rec));
				return new Info(masCorto, rec);
			}
		}
	}
}
