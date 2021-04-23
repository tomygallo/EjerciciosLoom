package _01ElPonyExpress;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestDePonyExpress {

	@Test
	public void testEnunciado() {
		
		assertEquals(1, PonyExpress.jinetes(new int[] {18, 15}));
		assertEquals(2, PonyExpress.jinetes(new int[] {43, 23, 40, 13}));
		assertEquals(3, PonyExpress.jinetes(new int[] {33, 8, 16, 47, 30, 30, 46}));
		assertEquals(3, PonyExpress.jinetes(new int[] {51, 51, 51}));
		assertEquals(4, PonyExpress.jinetes(new int[] {6, 24, 6, 8, 28, 8, 23, 47, 17, 29, 37, 18, 40, 49}));
		
	}
	
	@Test
	public void testCasoNormal() {
		assertEquals(0, PonyExpress.jinetes(new int[] {101, 5, 3}));
		assertEquals(1, PonyExpress.jinetes(new int[] {15, 4, 15, 6, 21, 19, 20}));
		assertEquals(7, PonyExpress.jinetes(new int[] {51, 72, 35, 66, 41, 60, 71}));
	}

}
