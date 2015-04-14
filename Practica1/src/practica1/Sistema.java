package practica1;

/**
 * @author Jaime Ruiz-Borau Vizarraga (546751)
 * @author Patricia Lazaro Tello (554309)
 * 
 * Clase principal desde la que se invocaran al resto de metodos
 */

import java.util.LinkedList;

public class Sistema {

	public static final int MAX_INTERVAL_START = 1000;
	public static final int MAX_INTERVAL_LENGTH = 100;

	/**
	 * @param args
	 *            [0] = n
	 * @param args
	 *            [1] = Maximo numero de intervalo o MAX_INTERVAL_START si no
	 *            especifica nada
	 * @param args
	 *            [2] = Longitud del intervalo o MAX_INTERVAL_LENGTH si no
	 *            especifica nada
	 * 
	 * Precondicion: (args[0] > 0), (args[1] > 0), (args[2] > 0)
	 */

	public static void main(String[] args) {
		/*
		 * Declaracion de variables globales de ejecucion
		 */

		int n = 0;
		int max_interval_start = 0;
		int max_interval_length = 0;

		/* Tratamiento de parametros */

		try {
			if (args.length == 0) {
				// No hay parametros
				System.err
						.println("Ejecucion incorrecta del programa."
								+ "\nComo minimo se ha de especificar los n intervalos");
			} else if (args.length == 1) {
				// Solo hay un parametro
				n = Integer.parseInt(args[0]);
				max_interval_start = MAX_INTERVAL_START;
				max_interval_length = MAX_INTERVAL_LENGTH;
			} else if (args.length == 2) {
				// Hay dos parametros
				n = Integer.parseInt(args[0]);
				max_interval_start = Integer.parseInt(args[1]);
				max_interval_length = MAX_INTERVAL_LENGTH;
			} else {
				// Mas de dos parametros
				n = Integer.parseInt(args[0]);
				max_interval_start = Integer.parseInt(args[1]);
				max_interval_length = Integer.parseInt(args[2]);
			}
		} catch (NumberFormatException e) {
			System.err.println("Error en los parametros. No son numeros");
		}

		/* Generar n intervalos */

		LinkedList<Nodo> intervalos = null;

		try {
			intervalos = Miscelanea.generarIntervalos(n, max_interval_start,
					max_interval_length);
		} catch (Exception e) {
			System.err.println("Error al generar el intervalo");
		}

		intervalos = Miscelanea.calcularConflictos(intervalos);

		/* Obtener la solucion con las 4 estrategias del algoritmo voraz */
		System.out.println("n = " + n + " \tMax Interval Start = "
				+ max_interval_start + " \tMax interval length = "
				+ max_interval_length);
		System.out.println(intervalos.toString());

		// Obtencion e informe con la estrategia "Primero el mejor"
		/************************************************************/
		System.out
				.println("\n+++ Lista 1: primero la tarea que empieza primero");
		LinkedList<Nodo> resultadoMerge = MergeSort.mergeSort(intervalos,
				new EstrategiaPrimeroMejor());
		System.out.println(resultadoMerge.toString());

		LinkedList<Nodo> resultadoPrimeroMejor = AlgoritmoVoraz
				.algoritmoVoraz(resultadoMerge);

		System.out.println("\n--- Numero total de intervalos seleccionado = "
				+ resultadoPrimeroMejor.size());
		System.out.println(resultadoPrimeroMejor.toString());
		System.out.println("\nUtilizacion total = "
				+ Miscelanea.calculoUtilizacion(resultadoPrimeroMejor));
		/***************************************************************/

		// Obtencion e informe con la estrategia "Ultimo mejor"
		/***************************************************************/
		System.out
				.println("\n+++ Lista 2: primero la tarea que termina primero");
		resultadoMerge = MergeSort.mergeSort(intervalos,
				new EstrategiaUltimoMejor());
		System.out.println(resultadoMerge.toString());

		LinkedList<Nodo> resultadoUltimoMejor = AlgoritmoVoraz
				.algoritmoVoraz(resultadoMerge);

		System.out.println("\n--- Numero total de intervalos seleccionado = "
				+ resultadoUltimoMejor.size());
		System.out.println(resultadoUltimoMejor.toString());
		System.out.println("\nUtilizacion total = "
				+ Miscelanea.calculoUtilizacion(resultadoUltimoMejor));
		/*************************************************************/

		// Obtencion e informe con la estrategia "Corto mejor"
		/************************************************************/
		System.out.println("\n+++ Lista 3: primero la tarea mas corta");
		resultadoMerge = MergeSort.mergeSort(intervalos,
				new EstrategiaCortoMejor());
		System.out.println(resultadoMerge.toString());

		LinkedList<Nodo> resultadoCortoMejor = AlgoritmoVoraz
				.algoritmoVoraz(resultadoMerge);

		System.out.println("\n--- Numero total de intervalos seleccionado = "
				+ resultadoCortoMejor.size());
		System.out.println(resultadoCortoMejor.toString());
		System.out.println("\nUtilizacion total = "
				+ Miscelanea.calculoUtilizacion(resultadoCortoMejor));
		/***************************************************************/

		// Obtencion e informe con la estrategia "Compatible mejor"
		/**************************************************************/
		System.out.println("\n+++ Lista 4: primero la tarea menos conflictiva");
		resultadoMerge = MergeSort.mergeSort(intervalos,
				new EstrategiaCompatibleMejor());
		System.out.println(resultadoMerge.toString());

		LinkedList<Nodo> resultadoCompatibleMejor = AlgoritmoVoraz
				.algoritmoVoraz(resultadoMerge);

		System.out.println("\n--- Numero total de intervalos seleccionado = "
				+ resultadoCompatibleMejor.size());
		System.out.println(resultadoCompatibleMejor.toString());
		System.out.println("\nUtilizacion total = "
				+ Miscelanea.calculoUtilizacion(resultadoCompatibleMejor));
		/************************************************************/
	}
}