package practica1;

/**
 * @author Jaime Ruiz-Borau Vizarraga (546751)
 * @author Patricia Lazaro Tello (554309)
 * 
 * Clase auxiliar que ofrece metodos de generacion de intervalos, calculo de 
 * conflictos en una lista de intervalos, si una solucion es completable si
 * se introduce un nuevo nodo o el calculo de la utilizacion.
 */

import java.util.LinkedList;
import java.util.Random;

public class Miscelanea {

	/**
	 * Calcula los conflictos que hay en una lista <input>
	 * 
	 * @param input
	 *            : lista de los nodos a examinar
	 * @return la lista <input> con el valor de los conflictos de los nodos
	 *         actualizados
	 */
	public static LinkedList<Nodo> calcularConflictos(LinkedList<Nodo> input) {

		int size = input.size(); // dimension de la lista

		for (int i = 0; i < size; i++) {
			Nodo actual = input.get(i);
			for (int j = i + 1; j < size; j++) {
				Nodo aInvestigar = input.get(j);

				/*
				 * Si los intervalos de los nodos no son compatibles sumamos uno
				 * a los conflictos de ambos
				 */
				if (!actual.getIntervalo().compatible(
						aInvestigar.getIntervalo())) {
					actual.setConflictos(actual.getConflictos() + 1);
					aInvestigar.setConflictos(aInvestigar.getConflictos() + 1);
				}
			}
		}
		return input;
	}

	/**
	 * Genera <n> intervalos entre [<max_start>, <max_start> + <max_length>] y
	 * los almacena en una lista
	 * 
	 * @param n
	 *            : numero de nodos a generar
	 * @param max_start
	 *            : maximo numero para el inicio del intervalo
	 * @param max_length
	 *            : maxima longitud del intervalo
	 * @return una list de nodos cuyos intervalos han sido generados
	 *         aleatoriamente
	 * @throws Exception
	 *             si el intervalo es invalido
	 */
	public static LinkedList<Nodo> generarIntervalos(int n, int max_start,
			int max_length) throws Exception {

		/* Declaracion de variables globales */
		LinkedList<Nodo> resultado = new LinkedList<Nodo>();
		Random g = new Random();

		for (int i = 0; i < n; i++) {
			int inicio = g.nextInt(max_start);
			int fin = inicio + g.nextInt(max_length) + 1;
			Nodo insert = new Nodo(new Intervalo(inicio, fin), 0);
			resultado.add(insert);
		}
		return resultado;
	}

	/**
	 * Devuelve true si, agregando el nodo <aMeter> a la <solucion>, esta sigue
	 * siendo completable
	 * 
	 * @param solucion
	 *            : lista completable de nodos
	 * @param aMeter
	 *            : el nodo candidato a ser parte de la solucion
	 * @return <true> si el nodo se puede agregar y <false> en caso contrario
	 */
	public static boolean completable(LinkedList<Nodo> solucion, Nodo aMeter) {
		boolean esCompatible = true;
		for (Nodo n : solucion) {
			if (!n.getIntervalo().compatible(aMeter.getIntervalo())) {
				esCompatible = false;
			}
		}
		return esCompatible;
	}

	/**
	 * Metodo para calcular la utilizacion total de la solucion
	 * 
	 * @param input
	 *            : lista de nodos que conforman la solucion
	 * @return el valor de utilidad total de la lista de nodos
	 */
	public static int calculoUtilizacion(LinkedList<Nodo> input) {
		int resultado = 0;
		for (Nodo n : input) {
			resultado = resultado + n.getIntervalo().getLongitud();
		}
		return resultado;
	}
	
	public static int maximo (int arg1, int arg2, int arg3, int arg4){
		int max = arg1;
		max = Math.max(max, arg2);
		max = Math.max(max, arg3);
		max = Math.max(max, arg4);
		
		return max;
	}

}
