package practica1;

/**
 * @author Jaime Ruiz-Borau Vizarraga (546751)
 * @author Patricia Lazaro Tello (554309)
 * 
 * Clase auxiliar que ofrece el metodo del algoritmo voraz 
 */

import java.util.LinkedList;

public class AlgoritmoVoraz {

	/**
	 * Aplica el algoritmo voraz sobre una lista de nodos. Los nodos estan
	 * ordenados de mas prometedores a menos prometedores, de forma que el
	 * algoritmo solo tiene que sacar el primer nodo de la lista para conseguir
	 * el mejor nodo.
	 * 
	 * @param input
	 *            : lista de entrada de nodos
	 * @return una lista con los nodos del conjunto resultado
	 */
	public static LinkedList<Nodo> algoritmoVoraz(LinkedList<Nodo> input) {
		LinkedList<Nodo> resultado = new LinkedList<Nodo>();
		while (!input.isEmpty()) {
			/* saca el primer nodo y lo elimina de la lista */
			Nodo primero = input.pollFirst();
			if (Miscelanea.completable(resultado, primero)) {
				resultado.add(primero);
			}
		}
		return resultado;
	}
}
