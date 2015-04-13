package practica1;

/**
 * @author Jaime Ruiz-Borau Vizarraga (546751)
 * @author Patricia Lazaro Tello (554309)
 * 
 *         La clase representa el intervalo de tiempo que dura una actividad
 */

public class Intervalo {

	/* Declaracion de atributos privados */
	private int inicio;
	private int fin;
	private int longitud;

	/**
	 * Metodo constructor
	 * 
	 * @param inicio
	 *            : Inicio del intervalo
	 * @param fin
	 *            : Fin del intervalo
	 * @throws Exception
	 *             : Si el intervalo es invalido lanza una excepcion
	 */
	public Intervalo(int inicio, int fin) throws Exception {
		if (fin <= inicio) {
			throw new Exception("Intervalo invalido");
		} else {
			this.inicio = inicio;
			this.fin = fin;
			this.longitud = fin - inicio;
		}
	}

	/**
	 * @return el inicio del intervalo
	 */
	public int getInicio() {
		return inicio;
	}

	/**
	 * @param inicio
	 *            : nuevo inicio del intervalo
	 */
	public void setInicio(int inicio) {
		this.inicio = inicio;
		this.longitud = (this.fin - this.inicio);
	}

	/**
	 * @return el fin del intervalo
	 */
	public int getFin() {
		return fin;
	}

	/**
	 * @param fin
	 *            : nuevo fin del intervalo
	 */
	public void setFin(int fin) {
		this.fin = fin;
		this.longitud = (this.fin - this.inicio);
	}

	/**
	 * @return la longitud del intervalo
	 */
	public int getLongitud() {
		return longitud;
	}

	/**
	 * Se considera que dos intervalos son compatibles si uno termina antes de
	 * que el siguiente inicie
	 * 
	 * @param intervalo
	 *            : intervalo con el que realizar la comparacion
	 * @return <true> si ambos intervalos son compatibles, o <false> en caso
	 *         contrario.
	 * 
	 */
	public boolean compatible(Intervalo intervalo) {
		return (inicio >= intervalo.getFin() || intervalo.getInicio() >= fin);
	}

	/**
	 * @return la informacion mas relevante dle intervalo
	 */
	@Override
	public String toString() {
		return "[" + inicio + ", " + fin + "]";
	}
}
