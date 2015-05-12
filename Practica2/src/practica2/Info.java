package practica2;

import java.util.List;

/**
 * @author Jaime Ruiz-Borau Vizarraga (546751)
 * @author Patricia Lazaro Tello (554309)
 * 
 *         Clase auxiliar para el tratamiento de tuplas del tipo
 *         {coste,recorrido}. La definicion de "coste" y "recorrido" se
 *         encuentra en el constructor
 */

public class Info {

	/* Atributos privados */
	private int coste;
	private List<Integer> recorrido;

	/**
	 * Constructor de un objeto tipo Info. El objeto representa un camino
	 * mediante una lista (recorrido) cuyo nodo de indice mas bajo es el nodo
	 * origen y el de indice mas alto es el nodo destino; y al mismo tiempo
	 * posee un entero (coste) que representa el coste de recorrer ese camino
	 * 
	 * @param coste
	 *            : entero que representa el coste de recorrer "recorrido"
	 * @param recorrido
	 *            : lista que representa el camino que se recorre
	 */
	public Info(int coste, List<Integer> recorrido) {
		super();
		this.coste = coste;
		this.recorrido = recorrido;
	}

	/**
	 * Devuelve el coste de este objeto Info
	 * 
	 * @return el coste
	 */
	public int getCoste() {
		return coste;
	}

	/**
	 * Establece un nuevo coste de este objeto Info
	 * 
	 * @param coste
	 *            el coste a establecer
	 */
	public void setCoste(int coste) {
		this.coste = coste;
	}

	/**
	 * Devuelve el recorrido de este objeto Info
	 * 
	 * @return el recorrido
	 */
	public List<Integer> getRecorrido() {
		return recorrido;
	}

	/**
	 * Establece un nuevo recorrido de este objeto Info
	 * 
	 * @param recorrido
	 *            el recorrido a establecer
	 */
	public void setRecorrido(List<Integer> recorrido) {
		this.recorrido = recorrido;
	}

}
