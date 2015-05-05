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
	 * 
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		int[][] testingu = Fichero.getGrafo("grafo.txt");
		showCaminosHamiltonianos(testingu);
	}

	/**
	 * 
	 * @param matrizAdyacencia
	 */
	public static void showCaminosHamiltonianos(int[][] matrizAdyacencia) {
		Gtab.initGtab(matrizAdyacencia);
		HashSet<Integer> h = new HashSet<Integer>();
		for (int i = 1; i < matrizAdyacencia.length; i++) {
			h.add(i);
		}

		Info info = g(0, h, matrizAdyacencia);

		System.out.println(info.getCoste());
		System.out.println(info.getRecorrido());
	}

	/**
	 * 
	 * @param i
	 * @param S
	 * @param L
	 * @return
	 */
	public static Info g(int i, Set<Integer> S, int[][] L) {
		if (S.size() == 0) {
			List<Integer> rec = new ArrayList<Integer>();
			rec.add(i);
			rec.add(0);
			Info info = new Info(L[i][0], rec);
//			System.out.println("Caso trivial: " + info.getRecorrido());
			return info;
		} else {
			if (Gtab.getGtab().get(S).get(i).getCoste() >= 0) {
				return Gtab.getGtab().get(S).get(i);
			} else {
				Integer masCorto = Integer.MAX_VALUE;
				List<Integer> rec = new ArrayList<Integer>();
				for (int j : S) {
					HashSet<Integer> temp = new HashSet<Integer>();
					temp.addAll(S);
					temp.remove(j);
					Info info = g(j, temp, L);
					int distancia = L[i][j] + info.getCoste();
					if (distancia < masCorto && distancia > 0) {
						masCorto = distancia;
						rec = info.getRecorrido();
					}
				}
				rec.add(0,i);
				Gtab.getGtab().get(S).set(i, new Info(masCorto, rec));
//				System.out.println("No trivial --> " + rec);
				return new Info(masCorto, rec);
			}
		}
	}
}
