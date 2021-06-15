package oia2_mesadasDeGranitos;

public class AppMain {
	
	public static void main(String[] args) {
		
		PilasMesadas pila = new PilasMesadas();
		
		pila.cargarMesadasDesdeArchivo("entrada\\mesadasEnunciado.in");
		System.out.println(pila + "\n");	
		System.out.println("Cantidad de pilas necesarias antes del calculo: " + pila.getCantPilasTotales());
		
		
		System.out.println("----Calculando las pilas necesarias-----");	
		pila.calcularCantPilas();
		System.out.println("Cantidad de pilas necesarias LUEGO del calculo: " + pila.getCantPilasTotales());
		System.out.println(pila + "\n");
	}
	
	
}
