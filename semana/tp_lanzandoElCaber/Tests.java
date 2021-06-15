package tp_lanzandoElCaber;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class Tests {
	
	@Test
	public void testEnunciado() {
		
		try {
			Competencia torneo = new Competencia();
			
			torneo.cargarCompetidores("entradaEnunciado.txt");
			torneo.calcularPodioDistancia();
			torneo.calcularPodioConsistencia();
			
			torneo.escribirResultados("salidasObtenidas\\salidaEnunciado.txt");
			
			int[] listConsSalida = {2,1};
			int[] listDisSalida = {2,1,3};

			assertEquals(true, torneo.compararIds(listConsSalida, listDisSalida));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFlujoNormal() {
		
		try {
			Competencia torneo = new Competencia();
			
			torneo.cargarCompetidores("entradaFlujoNormal1.txt");
			torneo.calcularPodioDistancia();
			torneo.calcularPodioConsistencia();
			
			torneo.escribirResultados("salidasObtenidas\\salidaNormal1.txt");
			
			int[] listConsSalida = {5,4,1};
			int[] listDisSalida = {4,2,1};

			assertEquals(true, torneo.compararIds(listConsSalida, listDisSalida));
			
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	

	@Test
	public void distanciaTotal() {
		Lanzamiento L1 = new Lanzamiento(1.5 , 8);
		L1.calcularDistanciaReal();
		assertEquals(1.5, L1.getDistancia(), 0);
	}
	
	@Test
	public void distanciaAl80() {
		Lanzamiento l1 = new Lanzamiento(1, 80);
		l1.calcularDistanciaReal();
		assertEquals(0.8, l1.getDistancia(), 0);
	}
	
	@Test
	public void tiroDescalificado() {
		Lanzamiento l1 = new Lanzamiento(1, 100);
		l1.calcularDistanciaReal();
		assertEquals(-1, l1.getDistancia(), 0);
	}
	
	@Test
	public void distanciaTotalDeCompetidor() {
		Competidor c1 = new Competidor(1);
		Lanzamiento l1 = new Lanzamiento(1, 10);//suma el total
		Lanzamiento l2 = new Lanzamiento(1, 80);//suma el 80%
		Lanzamiento l3 = new Lanzamiento(1, 100);//no suma
		l1.calcularDistanciaReal();
		l2.calcularDistanciaReal();
		l3.calcularDistanciaReal();
		c1.agregarLanzamiento(l1);
		c1.agregarLanzamiento(l2);
		c1.agregarLanzamiento(l3);
		c1.calcularDistanciaTotal();
		assertEquals(1.8, c1.getDistanciaTotal(), 0);
	}
	
//	@Test
//	public void consistenciaTotalDeCompetidor() {
//		Competidor c1 = new Competidor(1);
//		Lanzamiento l1 = new Lanzamiento(1, 10);//suma el total
//		Lanzamiento l2 = new Lanzamiento(1, 80);//suma el 80%
//		Lanzamiento l3 = new Lanzamiento(1, 40);//no suma
//		l1.calcularDistanciaReal();
//		l2.calcularDistanciaReal();
//		l3.calcularDistanciaReal();
//		c1.agregarLanzamiento(l1);
//		c1.agregarLanzamiento(l2);
//		c1.agregarLanzamiento(l3);
//		c1.calcularConsistencia();
//		assertEquals(130, c1.getConsistenciaTotal());
//	}
	
	@Test
	public void compiteConsistencia() {
		Competidor c1 = new Competidor(1);
		Lanzamiento l1 = new Lanzamiento(1, 10);//valido
		Lanzamiento l2 = new Lanzamiento(1, 80);//valido
		Lanzamiento l3 = new Lanzamiento(1, 100);//no valido
		l1.calcularDistanciaReal();
		l2.calcularDistanciaReal();
		l3.calcularDistanciaReal();
		c1.agregarLanzamiento(l1);
		c1.agregarLanzamiento(l2);
		c1.agregarLanzamiento(l3);
		c1.comprobarConsistencia();
		assertEquals(false, c1.isCompiteConsistencia());
	}
}
