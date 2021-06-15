package tp_lanzandoElCaber;

import java.util.Comparator;

public class OrdenarCompetidorPorConsistencia implements Comparator<Competidor>{
	
	@Override
	public int compare(Competidor c1, Competidor c2) {
		int diferencia = (int) (c1.getConsistenciaXdistancia() * 1000) - (int) (c2.getConsistenciaXdistancia() * 1000);

		if(diferencia == 0) {
			diferencia = (int)(c1.getConsistenciaXangulo()) - (int)(c2.getConsistenciaXangulo());
		}
		
		return diferencia;
	}
}
