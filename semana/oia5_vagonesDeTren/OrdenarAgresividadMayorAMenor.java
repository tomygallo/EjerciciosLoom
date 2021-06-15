package oia5_vagonesDeTren;
import java.util.Comparator;

public class OrdenarAgresividadMayorAMenor implements Comparator<Especie>{

	@Override
	public int compare(Especie e1, Especie e2) {
		return -(e1.getAgresividad() - e2.getAgresividad());
	}
	
	
}
