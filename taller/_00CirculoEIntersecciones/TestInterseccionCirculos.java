package _00CirculoEIntersecciones;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestInterseccionCirculos {

	@Test
	public void testEnunciado() {
		Circulo c1 = new Circulo(new Punto(0, 0), 1);
		Circulo c2 = new Circulo(new Punto(1, 1), 1.5);
		// System.out.println(c1.intersectaCon(c2));//true

		assertEquals(c1.intersectaCon(c2), true);
	}

	@Test
	public void testPuntoCoincidenteRadioDistinto() {
		Circulo c1 = new Circulo(new Punto(2, 2), 1);
		Circulo c2 = new Circulo(new Punto(2, 2), 5);

		assertEquals(c1.intersectaCon(c2), true);
	}

	@Test
	public void testFlujoNormal1() {
		Circulo c1 = new Circulo(new Punto(1, -3), 1);
		Circulo c2 = new Circulo(new Punto(2, 2), 2.4);

		assertEquals(c1.intersectaCon(c2), false);
	}

	@Test
	public void testMismoPuntoMismoRadio() {
		Circulo c1 = new Circulo(new Punto(0, 0), 1);
		Circulo c2 = new Circulo(new Punto(0, 0), 1);

		assertEquals(c1.intersectaCon(c2), true);
	}

	@Test
	public void testSeTocanCircunferencias() {
		Circulo c1 = new Circulo(new Punto(2, 2), 2);
		Circulo c2 = new Circulo(new Punto(-2, 2), 2);

		assertEquals(c1.intersectaCon(c2), true);
	}

}
