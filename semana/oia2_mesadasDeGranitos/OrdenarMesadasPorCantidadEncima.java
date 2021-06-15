package oia2_mesadasDeGranitos;

import java.util.Comparator;

public class OrdenarMesadasPorCantidadEncima implements Comparator<Mesada>{

	@Override
	public int compare(Mesada m1, Mesada m2) {
		return -(m1.getCantMesasEncima() - m2.getCantMesasEncima());
	}

}
