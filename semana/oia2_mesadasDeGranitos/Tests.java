package oia2_mesadasDeGranitos;

import static org.junit.Assert.*;

import org.junit.Test;

public class Tests {

	@Test
	public void testEnunciado() {
		
		PilasMesadas pila = new PilasMesadas();
		
		pila.cargarMesadasDesdeArchivo("entrada\\mesadasEnunciado.in");
		pila.calcularCantPilas();
		pila.generarArchivoSalida("salidaObtenida\\salidaEnunciadoObtenida.out");
		assertEquals(3, pila.getCantPilasTotales());
	}
	
	@Test
	public void testFlujoNormal1() {
		
		PilasMesadas pila = new PilasMesadas();
		
		pila.cargarMesadasDesdeArchivo("entrada\\flujoNormal1.in");
		pila.calcularCantPilas();
		pila.generarArchivoSalida("salidaObtenida\\flujoNormal1_Obtenido.out");
		assertEquals(1, pila.getCantPilasTotales());
	}
	
	@Test
	public void testFlujoNormal2() {
		
		PilasMesadas pila = new PilasMesadas();
		
		pila.cargarMesadasDesdeArchivo("entrada\\flujoNormal2.in");
		pila.calcularCantPilas();
		pila.generarArchivoSalida("salidaObtenida\\flujoNormal2_Obtenido.out");
		assertEquals(4, pila.getCantPilasTotales());
	}
	
	@Test
	public void testFlujoNormal3() {
		
		PilasMesadas pila = new PilasMesadas();
		
		pila.cargarMesadasDesdeArchivo("entrada\\flujoNormal3.in");
		pila.calcularCantPilas();
		pila.generarArchivoSalida("salidaObtenida\\flujoNormal3_Obtenido.out");
		assertEquals(6, pila.getCantPilasTotales());
	}
}
