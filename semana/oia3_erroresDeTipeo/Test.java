package oia3_erroresDeTipeo;
import static org.junit.Assert.*;

public class Test {

	@org.junit.Test
	public void testEnunciado() {
		
		String texto = "Estamos pintando!";
		String prueba = "ostant!Em inpados";
		ManejoCadena cad = new ManejoCadena();
		
		assertEquals(40, cad.procesador(texto, prueba));
	}
	
	
	@org.junit.Test
	public void test2() {
		
		String texto = "Aguante Argentina";
		String prueba = "nn uArganiAteegta";
		ManejoCadena cad = new ManejoCadena();
		
		assertEquals(39, cad.procesador(texto, prueba));
		
	}
}
