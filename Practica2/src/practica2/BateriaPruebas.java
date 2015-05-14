package practica2;

/**
 * @author Jaime Ruiz-Borau Vizarraga (546751)
 * @author Patricia Lazaro Tello (554309)
 * 
 * Clase que automatiza una bateria de pruebas del sistema implementado.
 * Ofrece un metodo main() que pregunta por un numero de pruebas y ejecuta
 * dicho numero de pruebas. Al final de la bateria de pruebas, presenta
 * los resultados obtenidos por pantalla.
 */

import java.util.ArrayList;
import java.util.Random;

public class BateriaPruebas {

	/**
	 * Metodo principal de la clase: pide por pantalla un numero de pruebas y
	 * las ejecuta, mostrando por pantalla los resultados.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		if (args.length <= 0) {
			System.out
					.println("Uso del programa BateriaPruebas: "
							+ "BateriaPruebas <listaEnteros>\n"
							+ "Donde <listaEnteros> es una secuencia de enteros separados por un espacio\n"
							+ "que indican los tamanos para las distintas matrices de adyacencias con las\n"
							+ "que se testeara la eficiencia de los algoritmos\n\n"
							+ "EJEMPLO:\n"
							+ "BateriaPruebas 4 18 26\n"
							+ "Ejecutara y cronometrara ambos algoritmos con matrices de adyacencia de\n"
							+ "tamanos 4, 18 y 26. Todas ellas seran inicializadas aleatoriamente");
		} else {
			ArrayList<Integer> listaNumeros = new ArrayList<Integer>();
			for (String numero : args) {
				try {
					int numerito = Integer.parseInt(numero);
					if (numerito < 2) {
						System.out
								.println(numerito + " no es un numero valido");
					} else {
						listaNumeros.add(numerito);
					}
				} catch (NumberFormatException e) {
					System.out.println(numero + " no es un numero");
				}
			}
			testing(listaNumeros);
		}
	}

	/**
	 * Metodo privado para la automatizacion de pruebas del sistema.
	 * 
	 * @param n
	 *            : numero de pruebas a realizar
	 * 
	 *            Precondicion: (n > 0)
	 */
	private static void testing(ArrayList<Integer> list) {
		int vecesOptimoFB = 0;
		int vecesOptimoPD = 0;

		for (int i : list) {
			int[][] matriz = generarMatrizRandom(i);
			long inicio, fin;

			// Cronometrar inicial Fuerza Bruta
			inicio = System.currentTimeMillis();
			// Fuerza Bruta
			FuerzaBruta.showCaminosHamiltonianos(matriz);
			// Cronometrar fin Fuerza Bruta
			fin = System.currentTimeMillis();

			// Mostrar resultado
			System.out.println("Fuerza Bruta ha tardado " + (fin - inicio)
					+ " milisegundos");
			long tiempoFuerzaBruta = fin - inicio;

			// Cronometrar inicial ProgDinamica
			inicio = System.currentTimeMillis();
			// ProgDinamica
			ProgDinamica.showCaminosHamiltonianos(matriz);
			// Cronometrar fin ProgDinamica
			fin = System.currentTimeMillis();

			// Mostrar resultado
			System.out.println("ProgDinamica ha tardado " + (fin - inicio)
					+ " milisegundos");
			long tiempoProgDinamica = fin - inicio;

			if (tiempoFuerzaBruta >= tiempoProgDinamica) {
				vecesOptimoPD++;
			} else {
				vecesOptimoFB++;
			}
		}
		// Mostrar cuantas veces ha sido optimo cada uno
		System.out.println("Veces que ha sido optimo Fuerza Bruta: "
				+ vecesOptimoFB);
		System.out.println("Veces que ha sido optimo ProgDinamica: "
				+ vecesOptimoPD);
	}

	/**
	 * Metodo privado para la generacion de matrices de adyacencia aleatorias
	 * 
	 * @param i
	 *            : dimensiones de la matriz (i x i)
	 * @return una matriz de adyacencia (i x i) que representa un grafo
	 */
	private static int[][] generarMatrizRandom(int i) {
		Random r = new Random();
		int[][] returned = new int[i][i];
		for (int j = 0; j < i; j++) {
			for (int k = 0; k < i; k++) {
				if (j != k) {
					returned[j][k] = r.nextInt(500) + 1;
				} else {
					returned[j][k] = 0;
				}
			}
		}
		return returned;
	}
}
