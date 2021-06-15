package oia1_conflictoEntreReinas;

public class AppMain {
	public static void main(String[] args) {
		Tablero tablero = new Tablero("entradaEnunciado2.txt");
		
		tablero.calcularConflictos();
		tablero.escribirArchivoSalida("salidaEnunciado2.txt");
		
	}
}
