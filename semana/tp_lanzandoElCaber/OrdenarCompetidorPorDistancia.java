package tp_lanzandoElCaber;

import java.util.Comparator;

public class OrdenarCompetidorPorDistancia implements Comparator<Competidor>{
	
	@Override
	public int compare(Competidor c1, Competidor c2) {
		return  (int) (c1.getDistanciaTotal() - c2.getDistanciaTotal());
		//return c1.getDistanciaTotal().compareTo(c2.getDistanciaTotal());
		//return (int) c1.compareTo(c2);
	}
}
