package oia5_vagonesDeTren;
import static org.junit.Assert.*;

import org.junit.Test;

public class Tests {

	@Test
	public void test() {
		
		Vagon vagon = new Vagon();

		vagon.cargarEspeciesDesdeArchivo("vagonesEnunciado.in");
		assertEquals(4, vagon.calcularVagones());
		vagon.escribirArchivo("salidasObtenidas\\vagonesEnunciado.out");
		assertEquals(45, vagon.getAgresividadTotal());
	}

}
