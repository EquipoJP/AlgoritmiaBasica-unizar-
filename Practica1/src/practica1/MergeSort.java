package practica1;

/**
 * @author Jaime Ruiz-Borau Vizarraga (546751)
 * @author Patricia Lazaro Tello (554309)
 * 
 * Clase auxiliar que ofrece el metodo de mergeSort, para ordenar una 
 * lista utilizando 'divide y venceras' 
 */

import java.util.Comparator;
import java.util.LinkedList;

public class MergeSort {

	/**
	 * Algoritmo de ordenacion por mezcla o mergesort
	 * 
	 * @param input
	 *            : lista de nodos de entrada (a ordenar)
	 * @param comparator
	 *            : comparador
	 * @return una lista de nodos ordenada segun el critero del comparador
	 */
	public static LinkedList<Nodo> mergeSort(LinkedList<Nodo> input,
			Comparator<Nodo> comparator) {
		if (input.size() <= 1) {
			// caso base
			return input;
		} else {
			// recursion
			LinkedList<Nodo> izquierdo = new LinkedList<Nodo>();
			LinkedList<Nodo> derecho = new LinkedList<Nodo>();

			int medio = input.size() / 2;

			for (int i = 0; i < medio; i++) {
				izquierdo.add(input.get(i));
			}

			for (int i = medio; i < input.size(); i++) {
				derecho.add(input.get(i));
			}

			izquierdo = mergeSort(izquierdo, comparator);
			derecho = mergeSort(derecho, comparator);

			if (comparator.compare(izquierdo.getLast(), derecho.getFirst()) <= 0) {
				izquierdo.addAll(derecho);
				return izquierdo;
			}

			LinkedList<Nodo> resultado = new LinkedList<Nodo>();
			resultado = merge(izquierdo, derecho, comparator);

			return resultado;
		}
	}

	/**
	 * Algoritmo auxiliar para ordenar segun mergesort
	 * 
	 * @param izquierdo
	 *            : lista que se une por la izquierda
	 * @param derecho
	 *            : lista que se une por la derecha
	 * @param comparator
	 *            : estrategia a usar
	 * @return lista de nodos ordenada
	 */
	private static LinkedList<Nodo> merge(LinkedList<Nodo> izquierdo,
			LinkedList<Nodo> derecho, Comparator<Nodo> comparator) {

		LinkedList<Nodo> resultado = new LinkedList<Nodo>();

		while (izquierdo.size() > 0 && derecho.size() > 0) {
			if (comparator.compare(izquierdo.getFirst(), derecho.getFirst()) <= 0) {
				resultado.add(izquierdo.pollFirst());
			} else {
				resultado.add(derecho.pollFirst());
			}
		}

		if (izquierdo.size() > 0) {
			resultado.addAll(izquierdo);
		}

		if (derecho.size() > 0) {
			resultado.addAll(derecho);
		}

		return resultado;
	}
}
