package practica2;

import java.util.List;

public class Info {

	private int coste;
	private List<Integer> recorrido;

	/**
	 * 
	 * @param coste
	 * @param recorrido
	 */
	public Info(int coste, List<Integer> recorrido) {
		super();
		this.coste = coste;
		this.recorrido = recorrido;
	}

	/**
	 * @return the coste
	 */
	public int getCoste() {
		return coste;
	}

	/**
	 * @param coste
	 *            the coste to set
	 */
	public void setCoste(int coste) {
		this.coste = coste;
	}

	/**
	 * @return the recorrido
	 */
	public List<Integer> getRecorrido() {
		return recorrido;
	}

	/**
	 * @param recorrido
	 *            the recorrido to set
	 */
	public void setRecorrido(List<Integer> recorrido) {
		this.recorrido = recorrido;
	}

}
