package practica2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
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

	public static void showCaminosHamiltonianos(int[][] matrizAdyacencia) {
		Hashtable<Set<Integer>, List<Integer>> gtab = new Hashtable<Set<Integer>, List<Integer>>();
		gtab = initGtab(gtab, matrizAdyacencia);
	}

	/**
	 * 
	 * @param gtab
	 * @param matrizAdyacencia
	 * @return
	 */
	private static Hashtable<Set<Integer>, List<Integer>> initGtab(
			Hashtable<Set<Integer>, List<Integer>> gtab,
			int[][] matrizAdyacencia) {

		List<Set<Integer>> sets = initSets(matrizAdyacencia);
		
		for (Set<Integer> set : sets) {
			List<Integer> lista = new ArrayList<Integer>();
			for (int i = 0; i < matrizAdyacencia.length; i++) {
				lista.add(i, i);
			}
			gtab.put(set, lista);
		}

		return null;
	}

	/**
	 * 
	 * @param matrizAdyacencia
	 * @return
	 */
	private static List<Set<Integer>> initSets(int[][] matrizAdyacencia){
		List<Set<Integer>> sets = new LinkedList<Set<Integer>>();
		int[] items = new int[matrizAdyacencia.length];
		for (int i = 0; i < matrizAdyacencia.length; i++) {
			items[i] = i;
		}
		for (int k = 1; k <= items.length; k++) {
			List<Set<Integer>> parcial = new LinkedList<Set<Integer>>();
			sets.addAll(kcomb(items, 0, k, new int[k], parcial));
		}
		
		return sets;
	}

	/**
	 * http://stackoverflow.com/questions/2599499/k-combinations-of-a-set-of-
	 * integers-in-ascending-size-order
	 * 
	 * @param items
	 * @param n
	 * @param k
	 * @param arr
	 * @param parcial
	 * @return
	 */
	private static List<Set<Integer>> kcomb(int[] items, int n, int k,
			int[] arr, List<Set<Integer>> parcial) {
		if (k == 0) {
			System.out.println(Arrays.toString(arr));
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
