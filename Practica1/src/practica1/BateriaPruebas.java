package practica1;

/**
 * @author Jaime Ruiz-Borau Vizarraga (546751)
 * @author Patricia Lazaro Tello (554309)
 * 
 * Clase que automatiza una bateria de pruebas del sistema implementado.
 * Ofrece un metodo main() que pregunta por un numero de pruebas y ejecuta
 * dicho numero de pruebas. Al final de la bateria de pruebas, presenta
 * los resultados obtenidos por pantalla.
 */

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class BateriaPruebas {

	/**
	 * Metodo principal de la clase: pide por pantalla un numero de pruebas y
	 * las ejecuta, mostrando por pantalla los resultados.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		while (true) {
			System.out.println("Introduzca numero de pruebas: ");
			Scanner s = new Scanner(System.in);
			int n = s.nextInt();
			if (n > 0) {
				System.out.println("Ejecutando " + n + " pruebas...");
				Pruebas(n);
			}
			s.close();
		}
	}

	/**
	 * Metodo privado para la automatizacion de pruebas del sistema.
	 * 
	 * @param n
	 *            : numero de pruebas a realizar
	 */
	private static void Pruebas(int n) {

		System.out.println("....................................");

		Random r = new Random();

		/* almacena los resultados acumulados */
		int vecesPM = 0;
		int vecesUM = 0;
		int vecesCM = 0;
		int vecesCPM = 0;

		for (int i = 0; i < n; i++) {

			LinkedList<Nodo> intervalos = null;
			int numIntervalos = r.nextInt(100) + 10;
			int max_start = r.nextInt(1000) + 10;
			int max_length = r.nextInt(1000) + 10;

			try {
				intervalos = Miscelanea.generarIntervalos(numIntervalos,
						max_start, max_length);
			} catch (Exception e) {
				System.err.println("Error al generar el intervalo");
			}
			intervalos = Miscelanea.calcularConflictos(intervalos);

			/* Primero el mejor */
			LinkedList<Nodo> resultadoMerge = MergeSort.mergeSort(intervalos,
					new EstrategiaPrimeroMejor());
			LinkedList<Nodo> resultadoPrimeroMejor = AlgoritmoVoraz
					.algoritmoVoraz(resultadoMerge);

			/* Ultimo el mejor */
			resultadoMerge = MergeSort.mergeSort(intervalos,
					new EstrategiaUltimoMejor());
			LinkedList<Nodo> resultadoUltimoMejor = AlgoritmoVoraz
					.algoritmoVoraz(resultadoMerge);

			/* Corto mejor */
			resultadoMerge = MergeSort.mergeSort(intervalos,
					new EstrategiaCortoMejor());
			LinkedList<Nodo> resultadoCortoMejor = AlgoritmoVoraz
					.algoritmoVoraz(resultadoMerge);

			/* Compatible mejor */
			resultadoMerge = MergeSort.mergeSort(intervalos,
					new EstrategiaCompatibleMejor());
			LinkedList<Nodo> resultadoCompatibleMejor = AlgoritmoVoraz
					.algoritmoVoraz(resultadoMerge);

			/* obtencion y comparacion de resultados */
			int sPM = resultadoPrimeroMejor.size();
			int sUM = resultadoUltimoMejor.size();
			int sCM = resultadoCortoMejor.size();
			int sCPM = resultadoCompatibleMejor.size();

			int max = Miscelanea.maximo(sPM, sUM, sCM, sCPM);

			if (sPM == max)
				vecesPM++;
			if (sUM == max)
				vecesUM++;
			if (sCM == max)
				vecesCM++;
			if (sCPM == max)
				vecesCPM++;
		}

		System.out.println("....................................");

		System.out.println("Se han realizado " + n
				+ " pruebas. Los resultados obtenidos son los siguientes: ");

		System.out.println("---> Veces que 'Primero el mejor' fue optimo: "
				+ vecesPM);
		System.out.println("---> Veces que 'Ultimo el mejor' fue optimo: "
				+ vecesUM);
		System.out.println("---> Veces que 'Corto el mejor' fue optimo: "
				+ vecesCM);
		System.out.println("---> Veces que 'Compatible el mejor' fue optimo: "
				+ vecesCPM);

		System.out.println();

		System.out
				.println("---> Porcentaje de veces que 'Primero el mejor' fue optimo: "
						+ (vecesPM * 100 / n) + "%");
		System.out
				.println("---> Porcentaje de veces que 'Ultimo el mejor' fue optimo: "
						+ (100 * vecesUM / n) + "%");
		System.out
				.println("---> Porcentaje de veces que 'Corto el mejor' fue optimo: "
						+ (100 * vecesCM / n) + "%");
		System.out
				.println("---> Porcentaje de veces que 'Compatible el mejor' fue optimo: "
						+ (vecesCPM * 100 / n) + "%");
	}
}
