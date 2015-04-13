package practica1;

/**
 * @author Jaime Ruiz-Borau Vizarraga (546751)
 * @author Patricia Lazaro Tello (554309)
 * 
 * Estrategia que define el mejor nodo como el mas compatible;
 * es decir, el nodo con menor numero de conflictos
 */

import java.util.Comparator;

public class EstrategiaCompatibleMejor implements Comparator<Nodo> {

	/**
	 * @param arg0
	 *            : primer nodo a comparar
	 * @param arg1
	 *            : segundo nodo a comparar
	 * @return 0 si <arg0> es igual que <arg1>, -1 si <arg0> es menor que <arg1>
	 *         y 1 si <arg0> es mayor que <arg1>
	 */
	@Override
	public int compare(Nodo arg0, Nodo arg1) {
		if (arg0.getConflictos() < arg1.getConflictos())
			return -1;
		else if (arg0.getConflictos() == arg1.getConflictos())
			return 0;
		else
			return 1;
	}

}
