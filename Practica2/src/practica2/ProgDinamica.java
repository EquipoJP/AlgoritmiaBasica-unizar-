package practica2;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Jaime Ruiz-Borau Vizarraga (546751)
 * @author Patricia Lazaro Tello (554309)
 * 
 *         Clase que implementa el algoritmo de programacion dinamica para
 *         encontrar el camino hamiltoniano minimo del grafo
 */

public class ProgDinamica {

	private static List<Integer> recorrido;
	
	public static void main(String[] args) throws FileNotFoundException{
		int[][] testingu = Fichero.getGrafo("grafo.txt");
		showCaminosHamiltonianos(testingu);
	}
	
	public static void showCaminosHamiltonianos(int[][] matrizAdyacencia) {
		Gtab.initGtab(matrizAdyacencia);
		HashSet<Integer> h = new HashSet<Integer>();
		for(int i = 0; i<matrizAdyacencia.length;i++){
			h.add(i);
		}
		recorrido = new ArrayList<Integer>();
		System.out.println(g(0,h,matrizAdyacencia));
		System.out.println(recorrido.toString());
	}

	public static int g(int i, Set<Integer> S, int[][] L) {
		recorrido.add(i);
		if(S.size()==0){
			return L[i][0];
		}
		else{
			if(Gtab.getGtab().get(S).get(i)>=0){
				return Gtab.getGtab().get(S).get(i);
			}
			else{
				Integer masCorto = Integer.MAX_VALUE;
				for(int j : S){
					HashSet<Integer> temp = new HashSet<Integer>();
					temp.addAll(S);
					temp.remove(j);
					int distancia = L[i][j]+g(j,temp,L);
					if(distancia<masCorto){
						masCorto=distancia;
						System.out.println(masCorto);
					}
				}
				Gtab.getGtab().get(S).set(i, masCorto);
				return masCorto;
			}
		}
	}
	
	
}
