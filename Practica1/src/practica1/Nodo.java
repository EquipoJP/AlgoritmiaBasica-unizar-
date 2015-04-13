package practica1;

/**
 * @author Jaime Ruiz-Borau Vizarraga (546751)
 * @author Patricia Lazaro Tello (554309)
 * 
 * Un nodo se compone del intervalo de tiempo que dura la actividad y el numero
 * de conflictos con el resto de actividades dentro de una lista concreta.
 */

public class Nodo {

	/* Declaracion de variables privadas */
	private Intervalo intervalo;
	private int conflictos;

	/**
	 * Metodo constructor
	 * 
	 * @param intervalo
	 *            : Intervalo
	 * @param conflictos
	 *            : Numero de conflictos
	 */
	
	public Nodo(Intervalo intervalo, int conflictos) {
		this.intervalo = intervalo;
		this.conflictos = conflictos;
	}

	/**
	 * @return el intervalo al que esta asociado el nodo
	 */
	public Intervalo getIntervalo() {
		return intervalo;
	}

	/**
	 * @param intervalo : nuevo intervalo al que referencia el nodo
	 */
	public void setIntervalo(Intervalo intervalo) {
		this.intervalo = intervalo;
	}

	/**
	 * @return numero de conflictos del nodo con otros nodos
	 */
	public int getConflictos() {
		return conflictos;
	}

	/**
	 * @param conflictos : nuevo numero de conflictos
	 */
	public void setConflictos(int conflictos) {
		this.conflictos = conflictos;
	}

	/**
	 * @return la informacion relevante del nodo
	 */
	@Override
	public String toString(){
		return intervalo.toString() + " (" + conflictos + ")";
	}
}
