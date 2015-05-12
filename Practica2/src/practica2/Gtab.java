package practica2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author Jaime Ruiz-Borau Vizarraga (546751)
 * @author Patricia Lazaro Tello (554309)
 * 
 * Clase auxiliar para el tratamiento de la tabla auxiliar
 * para programacion dinamica Gtab
 */

public class Gtab {

	/* Atributos privados */
	private static Hashtable<Set<Integer>, List<Info>> gtab = null;
	
	/**
	 * Metodo que inicializa la tabla gtab. Requiere de una matriz
	 * de adyacencia para ello, y rellena la gtab con pares clave-valor,
	 * donde la clave es un conjunto de nodos restantes a emplear (set de
	 * integer) y el valor es una lista de Info.
	 * Esta lista representa mediante sus indices el siguiente nodo que 
	 * se escoge para el camino; y mediante el objeto info se representa el 
	 * coste y el recorrido del camino que se tomara si se sigue el nodo 
	 * representado por el indice de la lista
	 * 
	 * @param matrizAdyacencia:
	 * 				la matriz de adyacencia que se usara para inicializar
	 * 				la gtab
	 */
	public static void initGtab(int[][] matrizAdyacencia) {
		gtab = new Hashtable<Set<Integer>, List<Info>>();
		List<Set<Integer>> sets = initSets(matrizAdyacencia);

		for (Set<Integer> set : sets) {
			List<Info> lista = new ArrayList<Info>();
			for (int i = 0; i < matrizAdyacencia.length; i++) {
				Info info = new Info(-1, null);
				lista.add(i, info);
			}
			gtab.put(set, lista);
		}
	}

	/**
	 * Metodo que devuelve la gtab actual
	 * 
	 * @return: la gtab actual
	 */
	public static Hashtable<Set<Integer>, List<Info>> getGtab(){
		return gtab;
	}
	
	/**
	 * Metodo que inicializa todas las combinaciones de sets posibles
	 * de la gtab dada una matriz de adyacencia
	 * 
	 * @param matrizAdyacencia:
	 * 				la matriz de adyacencia que se usara para inicializar
	 * 				la lista de sets
	 * @return: la lista de sets con todas las combinaciones posibles de nodos
	 */
	private static List<Set<Integer>> initSets(int[][] matrizAdyacencia) {
		List<Set<Integer>> sets = new LinkedList<Set<Integer>>();
		int[] items = new int[matrizAdyacencia.length];
		for (int i = 0; i < matrizAdyacencia.length; i++) {
			items[i] = i;
		}
		for (int k = 1; k <= items.length; k++) {
			List<Set<Integer>> parcial = new LinkedList<Set<Integer>>();
			sets.addAll(kcomb(items, 0, k, new int[k], parcial));
		}

		Set<Integer> set = new HashSet<Integer>();
		sets.add(set);
		return sets;
	}

	/**
	 * Metodo para calcular todas las combinaciones de sets posibles para
	 * la tabla Gtab
	 * 
	 * Este metodo no es original, se ha obtenido del siguiente enlace:
	 * http://stackoverflow.com/questions/2599499/k-combinations-of-a-set-of-
	 * integers-in-ascending-size-order
	 */
	private static List<Set<Integer>> kcomb(int[] items, int n, int k,
			int[] arr, List<Set<Integer>> parcial) {
		if (k == 0) {
			Set<Integer> set = new HashSet<Integer>();
			for (int i = 0; i < arr.length; i++) {
				set.add(arr[i]);
			}
			parcial.add(set);
			return parcial;
		} else {
			List<Set<Integer>> new_parcial = new LinkedList<Set<Integer>>();
			for (int i = n; i <= items.length - k; i++) {
				arr[arr.length - k] = items[i];
				List<Set<Integer>> aux = kcomb(items, i + 1, k - 1, arr,
						parcial);
				new_parcial.addAll(aux);
			}
			return new_parcial;
		}
	}
}
