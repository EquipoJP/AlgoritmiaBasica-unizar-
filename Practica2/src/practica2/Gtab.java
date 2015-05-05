package practica2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Gtab {

	private static Hashtable<Set<Integer>, List<Info>> gtab = null;

	public static Hashtable<Set<Integer>, List<Info>> getGtab(){
		return gtab;
	}
	
	/**
	 * 
	 * @param gtab
	 * @param matrizAdyacencia
	 * @return
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
	 * 
	 * @param matrizAdyacencia
	 * @return
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
